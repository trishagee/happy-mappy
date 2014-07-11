package com.mechanitis.mongo.sentiment;

import org.mongodb.Document;
import org.mongodb.MongoCollection;
import org.mongodb.MongoDatabase;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/sentiment")
@Produces(MediaType.APPLICATION_JSON)
public class SentimentResource {
    private final MongoDatabase database;

    public SentimentResource(final MongoDatabase database) {
        this.database = database;
    }

    @Path("sentiments")
    @GET
    public Object getSentiments() {
        MongoCollection<Document> processedPoints = database.getCollection("ProcessedPoints");
        return processedPoints.find().into(new ArrayList<Document>());
    }
    
}
