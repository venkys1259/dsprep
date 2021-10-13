package com.dynamicprogramming;
/* https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
     int[] dp = new int[n+1];
     dp[0] = 1; // for climbing 0 stairs, we have only 1 way i.e. not climbing at all
     dp[1] = 1; // for climbing 1 stair, we have only 1 way i.e climb 1 step
                // for climbing 2 stairs, either you can take 1 step at a time, ( 1+1) or 2 steps at a time
                // i.e. f[n] = f[n-1] +f[n-2];
     for(int i = 2; i<=n;i++){
         dp[i] = dp[i-2] + dp[i-1];
     }
     return dp[n];
    }
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs ();
        System.out.println (climbingStairs.climbStairs (3));
    }
}
