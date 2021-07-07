package com.sorting.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;

/*
https://leetcode.com/problems/reorganize-string/
 */
public class ReOrganizeString {
    /*Brute force Approach --> not passing all test cases*/
    private String reorganizeString(String s) {
        char[] chars = s.toCharArray ();
        int n = chars.length;
        Map<Character,Integer> charMap = new HashMap<>();
        List<Character> repeated = new ArrayList<>();
        List<Character> nonRepeated = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(charMap.containsKey(chars[i])){
                if(nonRepeated.contains(chars[i])){
                    nonRepeated.remove(nonRepeated.indexOf (chars[i]));
                    repeated.add(chars[i]);
                }
                repeated.add(chars[i]);
            }else{
                charMap.put(chars[i],0);
                nonRepeated.add(chars[i]);
            }
        }
        char[] result = new char[s.length()];
        int j = 0, repeatedSize = repeated.size (), nonRepeatSize = nonRepeated.size();
        for(int i = 0; i<result.length;i++){
            if( j < repeatedSize && i%2 == 0 ) {
                result[i] = repeated.get(j);
                j++;
            }
        }
        if(j!=repeatedSize){
            return  "";
        }
        j = 0;
        for(int i = 1; i<result.length;i++){
            if(j < nonRepeatSize && i%2!=0) {
                result[i] = nonRepeated.get(j);
                j++;
            }
        }
        if(j!=nonRepeatSize){
            return  "";
        }
        for(int i = 0; i<result.length-1;i++){
            if( result [i] == result[i+1]){
                return "";
            }
        }

        return  new String(result);
    }
    /*
    Implementation using Priority Queue
    Approach:
    1. Prepare a map which records how many times each character occurred in given input
       key will be Character and value will be number of occurrences of that character
    2. Create a Priority Queue as heap( priority order will be more number of occurrences will be first)
    3. Iterate through the queue until queue has grater than 1 character
    4. While iterating just club maximum occurred character with next maximum occurred character
    5. After iteration if the queue has one element left and if that has more number of occurrences then
       it means we cannot reorganise the string in such a way that no adjacent elements are same, so return "";
       else simply append this character to result.
     */
    private String reOrg(String s) {
        char[] chars = s.toCharArray ();
        int n = chars.length;
        Map<Character,Integer> charMap = new HashMap<>();
        for(int i = 0; i<n; i++){
            if(charMap.containsKey(chars[i])){
                charMap.put(chars[i],charMap.get(chars[i])+1);
            }else{
                charMap.put(chars[i],1);
            }
        }
        Queue<Character> heap = new PriorityQueue<Character>((a,b) -> charMap.get(a)>charMap.get(b)?-1:1); // heap with max number of occurrences at top
        for(Character ch: charMap.keySet()){
            heap.add(ch);
        }
        StringBuilder result = new StringBuilder();
        while(heap.size() > 1){
            Character current = heap.remove ();
            Character next = heap.remove();
            result.append(current);
            result.append(next);
            charMap.put(current,charMap.get(current)-1);
            charMap.put(next,charMap.get(next)-1);
            if(charMap.get(current) > 0){
                heap.add(current);
            }
            if(charMap.get(next) > 0){
                heap.add(next);
            }
        }
        if(!heap.isEmpty ()){ // heap has some element left, so we need to check if that element is occurred once or many times
           Character last = heap.remove();
            if(charMap.get(last) > 1){
                return "";
            }
          result.append(last);
        }
        return result.toString ();
    }

    public static void main(String[] args) {
        ReOrganizeString reOrganizeString = new ReOrganizeString();
        System.out.println (reOrganizeString.reOrg("blflxll"));
       }
}
