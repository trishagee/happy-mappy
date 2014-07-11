package com.mechanitis.mongo.sentiment;

import com.mechanitis.mongo.sentiment.processor.HappyStatus;
import com.mechanitis.mongo.sentiment.processor.SadStatus;
import com.mechanitis.mongo.sentiment.twitter.RawStatus;
import twitter4j.GeoLocation;

public class MapPoint {
    private final String feeling;
    private Location location;
    private long id;

    public MapPoint(final HappyStatus happyStatus) {
        this(happyStatus.getStatus(), "happy");
    }
    public MapPoint(final SadStatus sadStatus) {
        this(sadStatus.getStatus(), "sad");
    }

    MapPoint(final RawStatus status, String feeling) {
        this.feeling = feeling;
        this.location = new Location(status.getGeoLocation());
        this.id = status.getId();
    }

    public long getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public String getFeeling() {
        return feeling;
    }

    private static class Location {
        private double[] coordinates = new double[2];
        private String type;

        public Location(final GeoLocation geoLocation) {
            System.out.println(geoLocation.getLongitude());
            this.coordinates[0] = geoLocation.getLongitude();
            this.coordinates[1] = geoLocation.getLatitude();
            this.type = "point";
        }

        public double[] getCoordinates() {
            return coordinates;
        }

        public String getType() {
            return type;
        }
    }
}
