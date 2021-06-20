package com.arrays.practice;

/*
https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
Write an efficient program to find
the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum.
 */

public class MaxSumSubArrayUsingKadane {
    /* Approach: Using Kadane’s algorithm
    * objective is to find maximum sum of contiguous sub array
    * Iterate through the given array
    * at every ith index compute the sum of the elements including ith element,
    * if this sum is grater than ith element, consider that element into subarray
    * else if the sum is less than ith element,we will discard all the elements of
    * array till now and consider this element as new starting point of sub array
    *
    *while doing this, compare the maximum Sum at each stage with current sum,
    * if maxSum is more than  current sum then currentSum will be maxSum.
    *
    * */
    private  int maxSumOfSubArray(int[] a){
        int maxiMumSum = a[0];
        int currentSum = maxiMumSum;
        for(int i = 1; i<a.length;i++){
            if((currentSum+a[i]) > a[i]){ //sum is more after inclusion of current element
                currentSum = currentSum+a[i];
                }
            else{
                currentSum = a[i];
            }
            if(currentSum > maxiMumSum){ // if the current element inclusion/exclusion results in more sum
                maxiMumSum = currentSum;
            }
        }
        return maxiMumSum;
    }
    public static void main(String[] args) {
      int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
      MaxSumSubArrayUsingKadane max = new MaxSumSubArrayUsingKadane();
        System.out.println (max.maxSumOfSubArray(a));
    }
}
