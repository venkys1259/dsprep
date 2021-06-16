package com.arrays.practice;
/*
https://leetcode.com/problems/jump-game-vi/
You are given a 0-indexed integer array nums and an integer k.
You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.
You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.
Return the maximum score you can get.
Example 1:

Input: nums = [1,-1,-2,4,-7,3], k = 2
Output: 7
Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.
Example 2:

Input: nums = [10,-5,-2,4,0,3], k = 3
Output: 17
Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.
Example 3:

Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
Output: 0
 */
/*
Approach:
Take first element as starting score.
Run through given array and take K Jumps
Find the maximum in K jumps each time and get maximum number
add it to score.

 */

public class JumpGame6 {
    private int maxResult(int[] nums, int k){
       int score = nums[0];// have to start the jump from here, so take it as first score
       int maxIndex = 0;
          while(maxIndex <nums.length-1){
           int j = maxIndex+1,max=Integer.MIN_VALUE,jumps = 0;
           while(j<nums.length && jumps < k){ // Jump K times , but make sure jumping within window
               if(nums[j] > max){ // Finding maximum in K Jumps
                   max = nums[j];
                   maxIndex = j;
               }
               j++;
               jumps++;
           }
           score = score + max;
       }
        return score;
    }

    public static void main(String[] args) {
        int[] nums = {10,-5,-2,4,0,3};
        JumpGame6 jump = new JumpGame6();
        System.out.println (jump.maxResult(nums,3));
    }
}
