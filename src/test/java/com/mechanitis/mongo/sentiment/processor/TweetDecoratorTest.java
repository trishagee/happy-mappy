package com.mechanitis.mongo.sentiment.processor;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TweetDecoratorTest {
    @Test
    public void shouldReturnTrueIfASingleWordIsInTheSentence() {
        // when
        boolean result = TweetDecorator.stringContainsSentiment("This makes me happy", asList("happy", "sad", "something"));

        // then
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseIfNoWordIsInTheSentence() {
        // when
        boolean result = TweetDecorator.stringContainsSentiment("This makes me happy", asList("sad", "something"));

        // then
        assertFalse(result);
    }

}