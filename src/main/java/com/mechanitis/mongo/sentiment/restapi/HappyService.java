package com.mechanitis.mongo.sentiment.restapi;

import com.mongodb.MongoClient;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

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
        MongoClient mongoClient = new MongoClient();
        
        environment.addResource(new SentimentResource(mongoClient));
        environment.manage(new MongoClientManager(mongoClient));
    }
}
