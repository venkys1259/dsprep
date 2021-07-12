package com.sorting.practice;

import java.util.Arrays;
/*
Quick Sort:

It follows divide and conquer approach:

1. Assume first element as pivot element.

2. let second element (i) as low and last element (j) as high

3. increment i pointer until a[i] less than pivot
   decrement j pointer until a[j  more than pivot
   once both above condition fails
   if i does not cross j, swap a[i] and a[j]
   else swap jth index with pivot

4. Once Pivot index is found, the elements before pivot will be less than pivot
   and elements after pivot will be grater than pivot.

5. Run the steps from 1 to 4 recursively as low,pivot <--> pivot+1, high
until all elements are sorted.


 */

public class QuickSort {
    private void quickSort(int[] a,int low, int high){
        if(low < high) {
            int pivot = getPivotIndex (a, low, high);
            quickSort (a, low, pivot - 1);
            quickSort (a, pivot + 1, high);
        }
    }
    private int getPivotIndex(int[] a,int low,int high){
        int i = low, j = high;
        while(i<j) {
            int pivot = low;
            while (i<= high && a[i] <= a[pivot]) {
                i++;
            }
            while (j >= 0 && a[j] > a[pivot]) {
                j--;
            }
            if (i < j) {
                swap (a,i,j);
            } else {
                swap (a,j,pivot);
            }
        }
        return j;
    }
    private void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        int[] a = {50,30,67,40,89,10,20,90};
        QuickSort sort = new QuickSort();
        sort.quickSort(a, 0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
