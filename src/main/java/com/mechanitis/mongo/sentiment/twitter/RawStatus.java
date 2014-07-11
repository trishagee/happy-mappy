package com.mechanitis.mongo.sentiment.twitter;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Serialized;
import org.mongodb.morphia.annotations.Transient;
import twitter4j.GeoLocation;
import twitter4j.Place;
import twitter4j.Status;
import twitter4j.User;

import java.util.Date;

public class RawStatus {
    @Transient
    private Status status;
    private Date createdAt;
    @Serialized
    private GeoLocation geoLocation;
    private String lang;
    @Serialized
    private Place place;
    private String text;
    private User user;
    @Id
    private long id;

    //Needed for Morphia
    public RawStatus() {
    }

    public RawStatus(final Status status) {
        this.status = status;
        createdAt = status.getCreatedAt();
        geoLocation = status.getGeoLocation();
        id = status.getId();
        lang = status.getLang();
        place = status.getPlace();
        text = status.getText();
        user = status.getUser();
    }

    public Status getStatus() {
        return status;
    }

    public String getText() {
        return text;
    }

    public long getId() {
        return id;
    }
}
