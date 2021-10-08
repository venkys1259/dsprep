package com.dynamicprogramming;

import java.util.Arrays;

/* https://leetcode.com/problems/coin-change/ */

/* followed https://www.youtube.com/watch?v=1R0_7HqNaW0&t=302s */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill (dp,amount+1);
        dp[0] = 0;
        for(int i = 0; i<=amount;i++){
            for(int j = 0; j<coins.length;j++){
                if(coins[j] <= i) {
                    dp[i] = Math.min (dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return  dp[amount] > amount ? -1: dp[amount];
    }
    public static void main(String[] args) {
     int[] coins = {1,2,5};
     int amount = 11;
     CoinChange coinChange = new CoinChange();
     System.out.println (coinChange.coinChange (coins,amount));
    }
}
