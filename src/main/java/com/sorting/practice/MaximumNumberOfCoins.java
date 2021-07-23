package com.sorting.practice;

import java.util.Arrays;

/*
https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
 */
public class MaximumNumberOfCoins {
    public int maxCoins(int[] piles) {
        int count = 0, n = piles.length;
        Arrays.sort (piles);
        for( int i = n-2; i>= n/3; i= i-2){
            count = count + piles[i];
        }
        return count;
    }
    public static void main(String[] args) {
        MaximumNumberOfCoins coins  = new MaximumNumberOfCoins ();
        int[] piles = {9,8,7,6,5,1,2,3,4};
        System.out.println ( coins.maxCoins(piles));
    }
}
