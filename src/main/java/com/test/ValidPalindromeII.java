package com.test;
/*
https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if(s == null || s.length () <=1) return true;
       return isValidPalindrome(s,0,s.length ()-1,true);
    }
    public boolean isValidPalindrome(String s, int start,int end, boolean canBeDeleted){
       while(start<=end){
        if(s.charAt (start) == s.charAt (end)){
            start++;
            end--;
            continue;
        }else if(canBeDeleted){
        return (isValidPalindrome (s,start+1,end,false) ||
            isValidPalindrome (s,start,end-1,false));
        }else{
            return false;
        }
       }
        return true;
    }
    public static void main(String[] args) {
        ValidPalindromeII validPal = new ValidPalindromeII ();
        String input = "abc";
        System.out.println (validPal.isValidPalindrome (input,0,input.length ()-1,true));
    }
}
