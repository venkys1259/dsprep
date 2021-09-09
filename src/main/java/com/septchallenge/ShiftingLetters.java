package com.septchallenge;
/* https://leetcode.com/problems/shifting-letters/  */

public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        char arr[]=s.toCharArray();

        int tot_shifts=0;

        for(int i=s.length()-1;i>=0;i--)
        {
            tot_shifts+=shifts[i]%26;
            arr[i]=(char)((arr[i]-97+tot_shifts)%26+97);
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        String s = "ruu";
        int[] shifts = { 26,9,17};
        ShiftingLetters shiftingLetters = new ShiftingLetters ();
        System.out.println (shiftingLetters.shiftingLetters (s,shifts));
    }
}
