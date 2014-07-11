package com.mechanitis.mongo.sentiment.processor;

import com.mechanitis.mongo.sentiment.twitter.RawStatus;
import twitter4j.Status;

public class HappyStatus {
    private final RawStatus status;

    public HappyStatus(final RawStatus status) {
        this.status = status;
    }
}
