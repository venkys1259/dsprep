package com.sorting.practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/*
https://leetcode.jp/problemdetail.php?id=1772
You are given a string array features where features[i] is a single word that represents the name of a feature of the latest product you are working on. You have made a survey where users have reported which features they like. You are given a string array responses, where each responses[i] is a string containing space-separated words.
The popularity of a feature is the number of responses[i] that contain the feature. You want to sort the features in non-increasing order by their popularity. If two features have the same popularity, order them by their original index in features. Notice that one response could contain the same feature multiple times; this feature is only counted once in its popularity.
Return the features in sorted order.

Example 1:
Input: features = ["cooler","lock","touch"], responses = ["i like cooler cooler","lock touch cool","locker like touch"]
Output: ["touch","cooler","lock"]
Explanation: appearances("cooler") = 1, appearances("lock") = 1, appearances("touch") = 2. Since "cooler" and "lock" both had 1 appearance, "cooler" comes first because "cooler" came first in the features array.
Example 2:
Input: features = ["a","aa","b","c"], responses = ["a","a aa","a a a a a","b a"]
Output: ["a","aa","b","c"]
 */
public class SortFeaturesByPopularity {
    /*
    Approach:
    Build a hash map with key as feature and number of times feature word exists in response strings.
  For each feature,Iterate through responses  and check if the word of feature exists in each response.
  if yes, increment the counter for particular feature.
  Then sort the hash map with values in decreasing order.
     */

    private String[] sortByPopularity(String[] features, String[] responses){
    Map<String, Integer> featureMap = new HashMap<>();
    for(int i = 0; i<features.length;i++){
        int counter = 0;
        for(int j = 0; j<responses.length;j++){
            if(isContain(responses[j],features[i])){ // if response has exact feature word
                counter++;
            }
        }
        featureMap.put (features[i],counter);
    }
        featureMap = featureMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
       .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
               LinkedHashMap::new)); // sort featureMap by values

        return  featureMap.keySet().stream().toArray(String[] :: new);
    }

    // This method checks if exact word of given string exists in source string or not
    private boolean isContain(String response,String feature){
        String pattern = "\\b"+feature+"\\b";
        Pattern p= Pattern.compile(pattern);
        Matcher m=p.matcher(response);
        return  m.find();
    }

    public static void main(String[] args) {
      String[] features = {"cooler","lock","touch"};
      String[] responses = {"i like cooler cooler","lock touch cool","locker like touch"};
      SortFeaturesByPopularity sort =new SortFeaturesByPopularity();
      System.out.println(Arrays.toString(sort.sortByPopularity (features,responses)));
    }
}
