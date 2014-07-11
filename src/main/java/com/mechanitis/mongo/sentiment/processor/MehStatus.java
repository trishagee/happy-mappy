package com.mechanitis.mongo.sentiment.processor;

import com.mechanitis.mongo.sentiment.twitter.RawStatus;
import twitter4j.Status;

public class MehStatus {
    private final RawStatus status;

    public MehStatus(final RawStatus status) {
        this.status = status;
    }
}
