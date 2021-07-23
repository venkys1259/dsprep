package com.sorting.practice;

import java.util.*;

/*
https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/
 */
public class MaximumSumObtained {
    private int maxSumRangeQuery(int[] nums, int[][] requests) {
        HashMap<Integer,Integer> freqMap = new LinkedHashMap<> ();
        for(int[] request:requests){
            for(int i = request[0]; i<=request[1];i++){
                freqMap.put (i, freqMap.getOrDefault (i, 0)+1);
            }
        } // map will tell how many times elements in the range repeated.
        List<Integer> frequencies = new ArrayList<> (freqMap.values ());
        Collections.sort (frequencies,Collections.reverseOrder ());
        Arrays.sort (nums);
        int i = nums.length-1, sum = 0;
        for(Integer frequency:frequencies){
            sum = sum + (frequency*nums[i]);
            i--;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] requests = {{0,2},{1,3},{1,1}};
        int[] nums = {1,2,3,4,5,10};
        MaximumSumObtained max = new MaximumSumObtained();
        System.out.println (max.maxSumRangeQuery (nums,requests));
    }
}
