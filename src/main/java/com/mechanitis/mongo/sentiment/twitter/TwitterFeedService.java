package com.mechanitis.mongo.sentiment.twitter;

import com.mechanitis.mongo.sentiment.twitter.TwitterAskerer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TwitterFeedService {

    public static void main(final String[] args) {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new TwitterAskerer(), 5, 5, TimeUnit.SECONDS);
    }
}
