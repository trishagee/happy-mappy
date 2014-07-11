package com.mechanitis.mongo.sentiment.twitter;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

class TwitterStreamListener implements StatusListener {
    private final Datastore datastore;

    TwitterStreamListener(final MongoClient mongoClient) {
        datastore = new Morphia().createDatastore(mongoClient, "MongoDBHappinessIndex");
    }

    @Override
    public void onStatus(Status status) {
        if (status.getGeoLocation() != null && meetsCriteria(status)) {
            System.out.println(status.getGeoLocation());
            datastore.save(status);
        }
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
    }

    @Override
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
    }

    @Override
    public void onScrubGeo(long userId, long upToStatusId) {
    }

    @Override
    public void onStallWarning(StallWarning warning) {
    }

    @Override
    public void onException(Exception ex) {
        ex.printStackTrace();
    }

    private boolean meetsCriteria(final Status status) {
//        return status.getText().contains("#WorldCup");
        //for testing
        return true;
    }
}
