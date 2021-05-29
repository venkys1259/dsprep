package com.basics.arrays;

/*
https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
Write a C function to return minimum and maximum in an array.
Your program should make the minimum number of comparisons.
 */
import java.util.ArrayList;
import java.util.List;

public class MaxMin{
    private List<Integer> minMax(int[] a){
        List<Integer> minMaxList = new ArrayList<>();
        int min = a[0],max = a[0];
        for(int i = 0; i< a.length;i++){
            if(a[i]<= min){
                min = a[i];
            }else{
                max = a[i];
            }
        }
        minMaxList.add(min);
        minMaxList.add(max);
        return  minMaxList;
    }
    public static void main(String[] args) {
        MaxMin maxMin = new MaxMin();
        int a[] = {1000, 11, 445, 1, 330, 3000};
        System.out.println (maxMin.minMax(a));
    }
}
