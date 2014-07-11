package com.mechanitis.mongo.sentiment;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import org.mongodb.MongoClient;
import org.mongodb.MongoClients;
import org.mongodb.MongoDatabase;
import org.mongodb.connection.ServerAddress;

public class HappyService extends Service<SentimentConfiguration> {

    public static void main(String[] args) throws Exception {
        new HappyService().run(args);
    }
    
    @Override
    public void initialize(final Bootstrap<SentimentConfiguration> bootstrap) {
        AssetsBundle bundle = new AssetsBundle("/html", "/");
        bootstrap.addBundle(bundle);
    }

    @Override
    public void run(final SentimentConfiguration configuration, final Environment environment) throws Exception {
        MongoClient mongoClient = MongoClients.create(new ServerAddress());
        
        environment.addResource(new SentimentResource(mongoClient.getDatabase("MongoDBHappinessIndex")));
        environment.manage(new MongoClientManager(mongoClient));
    }
}
