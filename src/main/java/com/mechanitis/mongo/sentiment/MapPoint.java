package com.mechanitis.mongo.sentiment;

import com.mechanitis.mongo.sentiment.processor.HappyStatus;
import com.mechanitis.mongo.sentiment.processor.SadStatus;
import com.mechanitis.mongo.sentiment.twitter.RawStatus;

public class MapPoint {
    private final String feeling;
    private double[] location = new double[2];
    private long id;

    public MapPoint(final HappyStatus happyStatus) {
        this(happyStatus.getStatus(), "happy");
    }

    public MapPoint(final SadStatus sadStatus) {
        this(sadStatus.getStatus(), "sad");
    }

    MapPoint(final RawStatus status, String feeling) {
        this.feeling = feeling;
        this.id = status.getId();
        this.location[0] = status.getGeoLocation().getLongitude();
        this.location[1] = status.getGeoLocation().getLatitude();
    }

    public long getId() {
        return id;
    }

    public double[] getLocation() {
        return location;
    }

    public String getFeeling() {
        return feeling;
    }
}
