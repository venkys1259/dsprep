package com.basics.arrays;

import java.util.Arrays;

public class RotateBy1 {
    private void rotate(int[] a){
    int n = a.length;
    int numTobeRotated = a[n-1];
    for(int i = n-1; i>0;i--){
        a[i] = a[i-1];
    }
    a[0] = numTobeRotated;
    }
    public static void main(String[] args) {
        RotateBy1 ro = new RotateBy1();
        int[] a = {9, 8, 7, 6, 4, 2, 1, 3};
        ro.rotate (a);
        System.out.println (Arrays.toString(a));
    }
}
