package com.mechanitis.mongo.sentiment.twitter;

import com.mongodb.MongoClient;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import java.net.UnknownHostException;

public class TwitterStreamService {
    public static void main(String[] args) throws TwitterException, UnknownHostException {
        MongoClient mongoClient = new MongoClient();

        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
        StatusListener listener = new TwitterStreamListener(mongoClient);
        twitterStream.addListener(listener);
        twitterStream.sample();
    }

}
