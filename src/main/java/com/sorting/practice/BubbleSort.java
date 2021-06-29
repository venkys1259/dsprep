package com.sorting.practice;

import java.util.Arrays;

/*
Bubble Sort:

1) Compare first element with second element
if second element is smaller than first element then swap
else compare second element with third( adjacent) element

2) After first pass is completed, you will see maximum element at the end of the array

3) Repeat step1 until you see all elements are sorted.

 */
public class BubbleSort {
    private void sort(int[] a) {
        for(int i = 0; i<a.length;i++){
            for(int j = 0; j<a.length-i-1;j++){
                if(a[j+1] < a[j]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int a[] = {12, 11, 13, 5, 6, 7};
        new BubbleSort().sort(a);
        System.out.println (Arrays.toString(a));
    }
}
