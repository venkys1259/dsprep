package com.basics.arrays;
/*
https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
Move all negative numbers to beginning and positive to end with constant extra space
Difficulty Level : Easy
Last Updated : 05 May, 2021
An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers appear before all positive numbers.
Examples :

Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5
 */

import java.util.Arrays;

public class MoveNegativesToBeginning {
    private void arrangeNums(int[] a){
        int i = 0, j = a.length-1;
        while(i<j){
            if(a[i]<0 && a[j]<0){
                i++;
            }
            if(a[i]>0 && a[j]<0){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;j--;
            }
            if(a[i]<0 && a[j]>0){
                i++; j--;
            }
            if(a[i]>0 && a[j]>0){
                j--;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        MoveNegativesToBeginning move = new MoveNegativesToBeginning();
        move.arrangeNums(a);
        System.out.println(Arrays.toString(a));
    }
}
