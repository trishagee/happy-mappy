package com.mechanitis.mongo.sentiment;

import com.yammer.dropwizard.lifecycle.Managed;
import org.eclipse.jetty.util.component.LifeCycle;
import org.mongodb.MongoClient;

public class MongoClientManager implements Managed{
    private final MongoClient mongoClient;

    public MongoClientManager(final MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public void start() throws Exception {
        
    }

    @Override
    public void stop() throws Exception {
        mongoClient.close();
    }
}
