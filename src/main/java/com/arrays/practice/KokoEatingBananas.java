package com.arrays.practice;

import java.util.Arrays;

/*
https://leetcode.com/problems/koko-eating-bananas/
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 ,

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
 */
public class KokoEatingBananas {
    /*
    Approach:
    1. sort the array
    2. left = 0, right = length-1, mid = (l+r)/2
    3. we assume mid point as minimum number of bananas that koko can eat in an hour
    4. calculate the speed for the above mid point
    5. if the resultant speed is greater than given speed (h), proceed to right of the array else left.
     */

    private int minEatingSpeed(int[] piles, int h){
        Arrays.sort(piles);
        int left = 0, right = piles.length-1,calculatedSpeed=0;
        while(left <= right) {
            calculatedSpeed = 0;
            int mid =  left + (right-left)/2;
            int minBananasEatenByKoko = piles[mid];
            for (int i = 0; i < piles.length; i++) {
                if (piles[i] < minBananasEatenByKoko) { // if the number of bananas are less in that peel, then take 1 hour
                    calculatedSpeed = calculatedSpeed + 1;
                } else {
                    // if the peel has more bananas than minBananasEatenByKoko, hours will be Math.ceil(piles[i]/min);
                    calculatedSpeed = calculatedSpeed + (int) (Math.ceil((double) piles[i] / minBananasEatenByKoko));
                }
            }
            if(calculatedSpeed == h ){
                return  piles[mid];
            }
            else if(calculatedSpeed > h ){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
              return  calculatedSpeed;
    }


    public static void main(String[] args) {
        KokoEatingBananas koko = new KokoEatingBananas();
        int[] a = {30,11,23,4,20};
        System.out.println (koko.minEatingSpeed (a,6));
    }
}
