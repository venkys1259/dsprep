package com.sorting.practice;

import java.util.HashMap;
import java.util.Map;

/*
Counting Sort:

Read the elements and check if they are appearing only once or more
number of times.

Once all elements are read, simply print the elements

Approach:

Put all elements into hash map with key as number
and how many times appeared as value.

Then Iterate an array of fixed size and check if its index matches
key of hash map, if yes add that element that many number of times
into result array.

 */

public class CountingSort {
    private void sort(int[] a){
        Map<Integer,Integer> countMap = new HashMap();
        int result = 0;
        for(int i = 0; i<a.length;i++){
          if(countMap.containsKey (a[i])){
              countMap.put(a[i],countMap.get(a[i])+1);
          }else{
              countMap.put(a[i],1);
          }
        }
        // Iterate through arbitrary size of array
        for(int i = 1; i<30;i++){
            if( countMap.containsKey(i)){
                for(int j = 0; j<countMap.get(i);j++){
                    a[result] = i;
                    result++;
                }
            }
        }
    }
    public static void main(String[] args) {
     int[] a = {8,4,9,7,6,3,2,3};
     new CountingSort ().sort(a);
     for(int i = 0; i< a.length;i++){
         System.out.println (a[i]);
     }

    }
}
