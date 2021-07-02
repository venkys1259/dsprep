package com.sorting.practice;

import java.util.Arrays;

/*
Approach:
1.Sort the characters of given strings
2. Compare if one string can break the other by comparing corresponding characters.
 */

public class BreakAnotherString {
    private boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int counter1 = 0, counter2 = 0;
        for(int i = 0; i< c2.length; i++){
            if(c2[i] >= c1[i]){
                counter1++;
            }
            if(c1[i] >= c2[i]){
                counter2++;
            }
        }
        if(counter1 == s1.length () || counter2 == s2.length ()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        BreakAnotherString breakAnotherString = new BreakAnotherString();
        System.out.println (breakAnotherString.checkIfCanBreak("leetcodee","interview"));
    }
}
