package com.dynamicprogramming;

import java.util.Arrays;

/* https://leetcode.com/problems/longest-increasing-subsequence/ */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int n = nums.length;
        Arrays.fill (dp, 1);
        for(int i = 0; i<n;i++){
            for(int j = 0; j<i;j++){
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max (dp[i], (1 + dp[j]));
                }
            }
        }
        // in general, last element of dp gives the result, but here i had to find the maximum once dp array is built.
        // not sure why?
        int max = -1;
        for(int i = 0; i<dp.length;i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
       int[] nums = {10,9,2,5,3,7,101,18};
       LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
       System.out.println (lis.lengthOfLIS (nums));
    }
}
