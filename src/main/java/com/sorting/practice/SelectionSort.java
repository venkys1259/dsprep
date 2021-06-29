package com.sorting.practice;

import java.util.Arrays;

/*
Selection Sort:

1)Select first index as smallest element's index

2) Compare the first element and adjacent element, if adjacent is smaller than first,
then swap otherwise continue comparing first element with third element

3) Repeat this process until you visit all the elements in array

4) Once first pass is completed, the first element in sorted array will appear in result.

5) Repeat Step 2 and 3 from second number till last.

 */
public class SelectionSort {
    private void sort(int[] a) {
      for(int i = 0; i<a.length;i++){
          for(int j = i+1; j<a.length;j++){
              if(a[j] < a[i]){
                  int temp = a[j];
                  a[j] = a[i];
                  a[i] = temp;
              }
          }
      }
    }

    public static void main(String[] args) {
        int a[] = {12, 11, 13, 5, 6, 7};
        new SelectionSort().sort(a);
        System.out.println (Arrays.toString(a));
    }
}