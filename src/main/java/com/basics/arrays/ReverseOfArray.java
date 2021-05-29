package com.basics.arrays;

import java.util.Arrays;

public class ReverseOfArray {
    private int[] reverse(int[] a){
        int  start = 0, end = a.length-1;
             while(start<end) {
                 int temp = a[start];
                 a[start] = a[end];
                 a[end] = temp;
                 start++;
                 end--;
             }

        return  a;
    }

    private int[] reverseWithLessSwaps(int[] a){
        int n = a.length;
        for(int i = 0 ; i<n/2;i++){
            int temp = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        ReverseOfArray reverseOfArray = new ReverseOfArray();
        int[] a = {9,8,7,6,5,4,3,2,1,10};
        int[] reversed = reverseOfArray.reverseWithLessSwaps (a);
        System.out.println (Arrays.toString (reversed));

    }
}
