package com.mechanitis.mongo.sentiment.processor;

import com.mechanitis.mongo.sentiment.twitter.RawStatus;
import twitter4j.Status;

public class SadStatus {
    private final RawStatus status;

    public SadStatus(final RawStatus status) {
        this.status = status;
    }
}
