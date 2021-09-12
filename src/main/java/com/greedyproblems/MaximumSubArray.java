package com.greedyproblems;
/* https://leetcode.com/problems/maximum-subarray/ */
// Kadanes Algorithm

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
      int globalSum = nums[0], currentSum = nums[0];
      for(int i = 1; i<nums.length;i++){
          currentSum = Math.max (nums[i],currentSum+nums[i]);
          if(currentSum > globalSum){
              globalSum = currentSum;
          }
      }
      return  globalSum;
    }
    public static void main(String[] args) {
    int[] nums = {5,4,-1,7,8};
    MaximumSubArray maximumSubArray = new MaximumSubArray ();
    System.out.println (maximumSubArray.maxSubArray (nums));
    }
}
