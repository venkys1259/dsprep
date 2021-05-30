package com.basics.arrays;

import java.util.Arrays;

/*
https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

Example 1:

Input:
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated
into ascending order.
 */
public class Sort012 {
    private int[] sort(int[] a){
        int low = 0,mid = 0, high = a.length-1;
        while(mid <= high){
            if(a[mid] == 0){
                int temp = a[mid];
                a[mid] = a[low];
                a[low]= temp;
                low++;
                mid++;
            }
            if(a[mid] == 1){
                mid++;
            }
            if(a[mid] == 2){
                int temp = a[mid];
                a[mid] = a[high];
                a[high]= temp;
                high--;
            }
        }

       return a;
    }

   public static void main(String[] args) {
        Sort012 sort012 = new Sort012();
        int[] a = {0,2,1,2,0};
        int[] sorted = sort012.sort (a);
        System.out.println (Arrays.toString(sorted));
    }


}
