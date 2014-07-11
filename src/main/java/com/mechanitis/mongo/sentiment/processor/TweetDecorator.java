package com.mechanitis.mongo.sentiment.processor;

import com.mechanitis.mongo.sentiment.twitter.RawStatus;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import twitter4j.Status;

import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class TweetDecorator implements Runnable {
    private final Datastore datastore;
    private static final List<String> YAY = asList("happy", "good", "great", "keen", "awesome", "marvelous", "yay", "pleased");
    private static final List<String> BOO = asList("sad", "mad", "blargh", "boo", "terrible", "horrible", "bad", "awful");

    public TweetDecorator(final MongoClient mongoClient) {
        datastore = new Morphia().createDatastore(mongoClient, "MongoDBHappinessIndex");
    }

    @Override
    public void run() {
        try {
            List<RawStatus> rawStatii = datastore.find(RawStatus.class).asList();
            System.out.println(rawStatii);
            List<HappyStatus> happyStatii = rawStatii.stream()
                                                     .filter(status -> stringContainsSentiment(status.getText(), YAY))
                                                     .map(HappyStatus::new)
                                                     .collect(toList());
            System.out.println(happyStatii);
            datastore.save(happyStatii);

            List<SadStatus> sadStatii = rawStatii.stream()
                                                 .filter(status -> stringContainsSentiment(status.getText(), BOO))
                                                 .map(SadStatus::new)
                                                 .collect(toList());
            datastore.save(sadStatii);

            List<MehStatus> mehStatii = rawStatii.stream()
                                                 .filter(status -> !stringContainsSentiment(status.getText(), YAY)
                                                                   && !stringContainsSentiment(status.getText(), BOO))
                                                 .map(MehStatus::new)
                                                 .collect(toList());
            datastore.save(mehStatii);
            List<Long> idsToDelete = rawStatii.stream().map(RawStatus::getId).collect(toList());
            WriteResult delete = datastore.delete(RawStatus.class, idsToDelete);
            System.out.println(delete.getN());
        } catch (final RuntimeException e) {
            e.printStackTrace();
        }
    }

    static boolean stringContainsSentiment(final String sentence, final List<String> items) {
        return items.stream().anyMatch(sentence::contains);
    }
}
