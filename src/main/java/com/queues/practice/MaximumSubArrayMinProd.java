package com.queues.practice;
/*
https://leetcode.com/problems/maximum-subarray-min-product/
The min-product of an array is equal to the minimum value in the array multiplied by the array's sum.

For example, the array [3,2,5] (minimum value is 2) has a min-product of 2 * (3+2+5) = 2 * 10 = 20.
Given an array of integers nums, return the maximum min-product of any non-empty subarray of nums. Since the answer may be large, return it modulo 109 + 7.

Note that the min-product should be maximized before performing the modulo operation. Testcases are generated such that the maximum min-product without modulo will fit in a 64-bit signed integer.

A subarray is a contiguous part of an array.


Example 1:

Input: nums = [1,2,3,2]
Output: 14
Explanation: The maximum min-product is achieved with the subarray [2,3,2] (minimum value is 2).
2 * (2+3+2) = 2 * 7 = 14.
Example 2:

Input: nums = [2,3,3,1,2]
Output: 18
Explanation: The maximum min-product is achieved with the subarray [3,3] (minimum value is 3).
3 * (3+3) = 3 * 6 = 18.
Example 3:

Input: nums = [3,1,5,6,4,2]
Output: 60
Explanation: The maximum min-product is achieved with the subarray [5,6,4] (minimum value is 4).
4 * (5+6+4) = 4 * 15 = 60.
 */
import java.util.Stack;

public class MaximumSubArrayMinProd {

    /*Approach:
    1. Compute Prefix Sum Array for given Array
    2. Compute Right Bound for all the elements in array
    Right Bound:
    for any ith element, next smaller element to the right of the array from ith position, will be the right bound
    3. Compute Left Bound for all the elements in array
    Left Bound:
    for any ith element, next smaller element to the left of the array from i th position.
    4. With Help of Right Bound, Left Bound and Prefix Sum, calculate
       Product for each element as  ith element * (Prefix[RightBound]- Prefix[LeftBound+1])
    5. get the maximum element from above calculated product.

    * */
    private int maxSumArrayMinProduct(int[] nums){
        int n = nums.length;
        // calculate prefix sum array
        int[] prefixSum = new int[n+1];
        int sum = 0;
        prefixSum[0] = 0;
        for(int i = 1; i<=n;i++){
            sum = sum+nums[i-1];
            prefixSum[i] = sum;
        }
        // Calculate Left Bound --> index of next smaller element on Left side
       Stack<Integer> lbs = new Stack<>(); // Building Monotonic increasing stack
       int[] left = new int[n];
       for(int i = 0; i<n;i++){
           // very critical we should not use if  condition here because
           // we will check if the current element is lesser than all the elements inserted till now
           // The moment we find the nums[i] is smaller, we will pop it and continue the check
           while(!lbs.isEmpty() && nums[i] <= nums[lbs.peek()]){
               lbs.pop();
           }
           if(lbs.isEmpty()){
               left[i] = -1;// left bound, nums[i] is the smallest element till now.
           }else{
               left[i] = lbs.peek();
           }
           lbs.push(i);
       }
        // Calculate Right Bound --> index of next smaller element on Right side
        Stack<Integer> rbs = new Stack<>();
        int[] right = new int[n];
       for(int i = n-1; i>=0; i--){
         while(!rbs.isEmpty() && nums[i] <= nums[rbs.peek()]){
             rbs.pop();
         }
           if(rbs.empty()){
             right[i] = n; // we take length of the stack as max bound
         }else{
             right[i] = rbs.peek();
         }
         rbs.push(i);
       }
       // calculate product array --> nums[i] * prefix[right[i]]-prefix[left[i]+1]
        int[] productArray = new int[n];
        for(int i = 0; i<n;i++){
                productArray[i] = nums[i] *(prefixSum[right[i]] - prefixSum[left[i]+1]);
        }
        // calculate maximum from product Array
        int max = 0;
        for(int i = 0; i<productArray.length; i++){
            if(productArray[i] > max){
                max = productArray[i];
            }
        }
        return  max;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,3,1,2};
        MaximumSubArrayMinProd max = new MaximumSubArrayMinProd();
        System.out.println (max.maxSumArrayMinProduct(nums));
    }
}
