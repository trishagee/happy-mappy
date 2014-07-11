package com.mechanitis.mongo.sentiment.processor;

import com.mechanitis.mongo.sentiment.twitter.RawStatus;
import org.mongodb.morphia.annotations.Entity;

@Entity
public class SadStatus {
    private RawStatus status;

    public SadStatus() {
    }

    public SadStatus(final RawStatus status) {
        this.status = status;
    }

    public RawStatus getStatus() {
        return status;
    }
}
