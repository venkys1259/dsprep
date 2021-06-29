package com.sorting.practice;
/*
Insertion Sort:

As the name suggests, we will try to insert element in such a way that
the all the elements till the inserted element will be sorted.

 1. compare first ( in array 1st not 0th element) element to the left side element i.e with 0th element
 if first element is smaller, then swap it.
 else continue to second element

 2. we have to compare ith element to the previous elements until ith element is grater.
 if ith element is smaller than i-1 element, swap
 now compare i-1 element with i-2, if i-2 is smaller, swap
 repeat this process until i >0 ( till 0th element in given array).

Eg:
8,4,9,7,6,3,2,3
4,8,9,7,6,3,2,3 i = 1 ( first element is less than 0th element, so swap)
4,8,9,7,6,3,2,3 i = 2 ( second element is not less than 1st element , so no swap)
4,7,8,9,6,3,2,3 i = 3
4,6,7,8,9,3,2,3 i = 4
3,4,6,7,8,9,2,3 i = 5
2,3,4,6,7,8,9,3 i = 6
2,3,3,4,6,7,8,9 i = 7
 */
public class InsertionSort {
    private void sort(int[] a) {
      for(int i = 1; i<a.length;i++){
          while(i > 0 && a[i] < a[i-1]){ // once ith element is grater, we move to next element in array i.e for next pass
              int temp = a[i];
              a[i] = a[i-1];
              a[i-1] = temp;
              i--;
          }
      }
    }

    public static void main(String[] args) {
        int[] a = {12, 11, 13, 5, 7,6};
        new InsertionSort ().sort (a);
        for (int i = 0; i < a.length; i++) {
            System.out.println (a[i]);
        }
    }
}

