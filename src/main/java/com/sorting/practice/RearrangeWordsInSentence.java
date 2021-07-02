package com.sorting.practice;
/*
https://leetcode.com/problems/rearrange-words-in-a-sentence/
Given a sentence text (A sentence is a string of space-separated words) in the following format:
First letter is in upper case.
Each word in text are separated by a single space.
Your task is to rearrange the words in text such that all words are rearranged in an increasing order of their lengths. If two words have the same length, arrange them in their original order.

Return the new text following the format shown above.

 Example 1:

Input: text = "Leetcode is cool"
Output: "Is cool leetcode"
Explanation: There are 3 words, "Leetcode" of length 8, "is" of length 2 and "cool" of length 4.
Output is ordered by length and the new first word starts with capital letter.
 */
public class RearrangeWordsInSentence {

    /* Using Heap Sort*/
    private String arrangeWords(String text){
        String[] words = text.split("\\s");
        int n = words.length;
        for(int i = n/2-1; i>=0;i--){
            heapify(words,n,i);
        }
        for(int i = n-1; i > 0; i--){
            String temp = words[0];
            words[0] = words[i];
            words[i] = temp;
            heapify (words,i,0);
        }
        String result = "";
        for(String s: words){
            result = result + s.toLowerCase()  + " ";
        }
        result = result.trim();
        result = String.valueOf (result.charAt(0)).toUpperCase() + result.substring (1);
        return  result.trim();
    }

    private void heapify(String[] s, int n, int i){
       int left = (2*i)+1;
       int right = (2*i)+2;
       int largest = i;
       if(left < n &&  s[left].length() > s[largest].length()){
           largest = left;
       }
       if(right < n && s[right].length () > s[largest].length()){
           largest = right;
       }
       if(largest != i){
           String temp = s[largest];
           s[largest] = s[i];
           s[i] = temp;
           heapify (s,n,largest);
       }
    }
    /*
    Approach:
    1. Sort the words in the input
    2. Iterate through words array and form sentence.
    Used Bubble sort to sort the words in given sort
     */
    private String reArrangeWords(String text){
        String[] words = text.split("\\s");
        int n = words.length;
        for(int i = 0; i<n;i++){
            for(int j= 0; j<n-i-1;j++){
                if(words[j].length() > words[j+1].length()){
                    String temp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp;
                }
            }
        }
        String result = "";
        for(String s: words){
            result = result + s.toLowerCase()  + " ";
        }
        result = String.valueOf (result.charAt(0)).toUpperCase() + result.substring (1); // First Character need to be uppercase
        return  result.trim();
    }

    public static void main(String[] args) {
        String s = "Leetcode is cool";
        System.out.println (new RearrangeWordsInSentence().reArrangeWords(s));

    }
}
