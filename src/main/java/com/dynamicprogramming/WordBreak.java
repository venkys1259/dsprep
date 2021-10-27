package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    /* Normal Recursion - which gives time limit exceed exception */
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains (s)) {
            return true;
        }
        for(int i = 1; i<s.length ();i++){
            String extracted = s.substring (0,i);
            if(wordDict.contains (extracted) && wordBreak (s.substring (i), wordDict)){
                return  true;
            }
        }
        return  false;
    }
    public static void main(String[] args) {
        WordBreak wb = new WordBreak ();
        String s1 = "leet", s2 = "code";
        List<String> dictionary = new ArrayList<> ();
         dictionary.add(s1);
         dictionary.add(s2);
        System.out.println (wb.wordBreak ("leetcode",dictionary));
    }
}
