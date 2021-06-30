package com.sorting.practice;
/*
https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 Example 1:
Input: nums = [3,4,5,2]
Output: 12
Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
 */
public class MaxProductOfTwoElements {
/*
Approach:
Sort the numbers and get product of last indices of result array after deducting -1.
I used Heap Sort to get just maximum 2 numbers so that I need not sort entire array.
 */
    private int maxProduct(int[] a){
            int n = a.length;
            for(int i = n/2 -1; i>=0; i--){
                heapify(a,i,n);
            }
            for(int i = n-1; i > n-3; i--){
                int temp = a[0];
                a[0] = a[i];
                a[i] = temp;
                heapify (a,0, i);
            }
            return (a[n-1]-1) * (a[n-2]-1);
    }

    private void heapify(int a[], int i, int n){
        for(int j = i; j>=0; j-- ) {
            int largest = j;
            int left = (2 * j) + 1;
            int right = (2 * j) + 2;
            if (right < n && a[right] > a[largest]) {
                largest = right;
            }
            if (left < n && a[left] > a[largest]) {
                largest = left;
            }
            if (largest != j) {
              int temp = a[j];
              a[j] = a[largest];
              a[largest] = temp;
              heapify(a,largest,n);
            }
        }
    }
    public static void main(String[] args) {
        int a[] = {1,8,5,4,10,2,6,1,1,1,9};
        System.out.println (new MaxProductOfTwoElements().maxProduct(a));

    }
}
