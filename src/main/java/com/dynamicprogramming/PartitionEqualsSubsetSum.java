package com.dynamicprogramming;
/* https://leetcode.com/problems/partition-equal-subset-sum/ */
public class PartitionEqualsSubsetSum {
    public boolean canPartition(int[] nums) {
          int sum = 0;
          for(int i = 0; i<nums.length;i++){
              sum = sum + nums[i];
          }
          // if the sum is odd we cannot partition into equal subset sum
        if(sum%2 != 0){
            return  false;
        }
        return isSubset(nums,sum/2);
    }

    private boolean isSubset(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        // base condition
        dp[0][0] = true; // sum = 0 can be achieved by not including any element in the subset.
        for(int j = 1; j<sum;j++){
           dp[0][j] = false; // sum = 0 cant be achieved by including 0
        }
        for(int i = 1; i<=n;i++){
            dp[i][0] = true; // sum = 0 can be achieved by not including any of the elements.
            // check the picture PartitionEqualsSubsetSum.jpg for understanding.
        }
        // template of constructing dp table
        for(int i = 1; i<=n;i++){
            for(int j = 1; j <=sum;j++){
                // include/ exclude the current element
                dp[i][j] = dp[i-1][sum-nums[i-1]] || dp[i-1][j];
            }
        }
        return  dp[n][sum];
    }

    public static void main(String[] args) {
        PartitionEqualsSubsetSum ps = new PartitionEqualsSubsetSum ();
        int[] nums = {1,5,11,5};
        System.out.println (ps.canPartition (nums));

    }
}
