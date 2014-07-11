package com.mechanitis.mongo.sentiment.restapi;

import com.mechanitis.mongo.sentiment.processor.HappyStatus;
import com.mechanitis.mongo.sentiment.processor.SadStatus;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Path("/sentiment")
@Produces(MediaType.APPLICATION_JSON)
public class SentimentResource {
    private final Datastore datastore;

    public SentimentResource(final MongoClient mongoClient) {
        datastore = new Morphia().createDatastore(mongoClient, "MongoDBHappinessIndex");
    }

    @Path("sentiments")
    @GET
    public List<MapPoint> getSentiments() {
        Stream<MapPoint> happyPoints = datastore.find(HappyStatus.class).asList()
                                                .stream().map(happyStatus -> new MapPoint(happyStatus));

        Stream<MapPoint> sadPoints = datastore.find(SadStatus.class).asList()
                                              .stream().map(sadStatus -> new MapPoint(sadStatus));
        return Stream.concat(happyPoints, sadPoints).collect(toList());
    }

}
