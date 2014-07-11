package com.mechanitis.mongo.sentiment.processor;

import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TweetDecoratorService {
    public static void main(String[] args) throws UnknownHostException {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new TweetDecorator(new MongoClient()), 5, 5, TimeUnit.SECONDS);
    }
}
