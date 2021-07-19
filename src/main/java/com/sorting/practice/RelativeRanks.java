package com.sorting.practice;

import java.util.*;

/* https://leetcode.com/problems/relative-ranks/ */
public class RelativeRanks {
    private String[] findRelativeRanks(int[] score) {
        int[] temp = new int[score.length];
        for(int i = 0; i<score.length;i++){
            temp[i]= score[i];
        }
        Arrays.sort (temp);
        Map<Integer,Integer>  rankMap = new LinkedHashMap<> ();
        String[] result = new String[score.length];
        int ranking = 1;
        for(int i = temp.length-1; i>=0;i--){
            rankMap.put (temp[i],ranking++);
        }
        for(int i = 0; i<score.length;i++){
           int value = rankMap.get (score[i]);
            if(value == 1){
                result[i] = "Gold Medal";
            }
            else if(value == 2){
                result[i] = "Silver Medal";
            }
            else if(value == 3){
                result[i] = "Bronze Medal";
            }
            else{
                result[i] = rankMap.get(score[i])+"";
            }
        }
    return result;
    }
    /** Using Heap ***/
    private String[] findRelRanks(int[] score){
        String[] result = new String[score.length];
        Map<Integer,Integer>  rankMap = new LinkedHashMap<> ();
        Map<Integer,String>  resultMap = new LinkedHashMap<> ();
        for(int i = 0; i<score.length;i++){
            rankMap.put (score[i],i+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<> ((a,b) -> a.getKey ()>b.getKey ()?-1:1);
        for(Map.Entry<Integer,Integer> entry:rankMap.entrySet ()){
            heap.add(entry);
        }
        int relativeRanking = 1; int medalists = 0;
        while(!heap.isEmpty ()){
            if(relativeRanking == 1){
                resultMap.put(heap.peek().getKey(), "Gold Medal");
            }
            else if(relativeRanking == 2){
                resultMap.put(heap.peek().getKey(), "Silver Medal");
            }
            else if(relativeRanking == 3){
                resultMap.put(heap.peek().getKey(), "Bronze Medal");
            }
            else{
                resultMap.put (heap.peek().getKey(),relativeRanking+"");
            }
            relativeRanking++;
            heap.remove();
        }
        for(int  i = 0; i<score.length;i++){
            result[i] = resultMap.get(score[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        RelativeRanks relativeRanks  = new RelativeRanks();
        int[] a = {10,3,8,9,4};
        System.out.println (Arrays.toString (relativeRanks.findRelativeRanks (a)));
        System.out.println (Arrays.toString (relativeRanks.findRelRanks (a)));
    }
}
