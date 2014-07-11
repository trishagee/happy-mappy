package com.mechanitis.mongo.sentiment.twitter;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

public class TwitterAskerer implements Runnable {
    @Override
    public void run() {
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            //            https://api.twitter.com/1.1/search/tweets.json?q=%23mongodb&src=typd
            Query query = new Query("#MongoDB");
            QueryResult result;
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
            for (final Status tweet : tweets) {
                System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
            }
        } catch (final TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
        }

    }
}
