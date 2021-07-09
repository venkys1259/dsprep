package com.sorting.practice;

import java.util.*;

/* https://leetcode.com/problems/tweet-counts-per-frequency/
leetcode 1348
*
* */
public class TweetCounts {
    Map<String,List<Integer>> tweetMap;

    public TweetCounts() {
        tweetMap = new HashMap<> ();
    }

    public void recordTweet(String tweetName, int time) {
        List<Integer> tweets = tweetMap.getOrDefault (tweetName, new ArrayList<> ());
        tweets.add(time);
        tweetMap.put(tweetName,tweets);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> tweets = tweetMap.get(tweetName);
        Collections.sort(tweets);
        List<Integer> result;
        if(freq.equals("minute")){
           result = getCounts (tweets, startTime, endTime, 59);// 0-59, 60 - 119 chunks
        }else if(freq.equals ("hour")){
           result = getCounts (tweets, startTime, endTime, 3599); // 0-3599, 3600-7199 chunks
        }else{
           result = getCounts (tweets, startTime, endTime, 9990); //
        }
        return result;
    }
    private List<Integer> getCounts( List<Integer> tweets, int startTime, int endTime,int chunkDuration){
        List<Integer> result = new ArrayList<> ();
        int counter; int tempStartDate = startTime, tempEndDate;
        tempEndDate = startTime+chunkDuration;
        while(endTime > tempStartDate) { // iterate until endTime
            counter = 0;
            for(Integer tweet:tweets){
                if (tweet >= tempStartDate && tweet <=tempEndDate){
                    counter++;
                }
            }
            tempStartDate+=chunkDuration;
            tempEndDate+=chunkDuration;
            result.add(counter);
        }
        return result;
    }

    public static void main(String[] args) {
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet3", 0);
        tweetCounts.recordTweet("tweet3", 60);
        tweetCounts.recordTweet("tweet3", 10);
        System.out.println (tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59));
        System.out.println (tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60));
        tweetCounts.recordTweet("tweet3", 120);
        System.out.println (tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210));
    }
}
