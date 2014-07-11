package com.mechanitis.mongo.sentiment.processor;

import com.mechanitis.mongo.sentiment.twitter.RawStatus;
import org.mongodb.morphia.annotations.Entity;

@Entity
public class MehStatus {
    private final RawStatus status;

    public MehStatus(final RawStatus status) {
        this.status = status;
    }
}
