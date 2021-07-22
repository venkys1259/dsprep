package com.sorting.practice;

/*
https://leetcode.com/problems/the-k-strongest-values-in-an-array/
 */
import java.util.Arrays;

public class KStrongestValues {
    public int[] getStrongest(int[] arr, int k) {
       int[] result = new int[k];
       Arrays.sort (arr);
       int n = arr.length, median;
       if(n%2 == 0){
           median = arr[(n-1)/2];
       }else{
           median = (arr[n/2] + arr[(n-1)/2])/2;
       }
       int i = 0, j = 0, l = n-1;
       while(i<n){
           if(k == 0){
               return  result;
           }
           else  {
               if (Math.abs (arr[i] - median) > Math.abs (arr[l] - median)) {
                   result[j] = arr[i];
                   i++;
               }else{
                   result[j] = arr[l];
                   l--;
               }
               k--;
               j++;
           }
       }
       return  result;
    }
    public static void main(String[] args) {
    int[] a = {1,1,3,5,5};
    KStrongestValues kStrong = new KStrongestValues();
    System.out.println (Arrays.toString (kStrong.getStrongest (a, 2)));
    }
}
