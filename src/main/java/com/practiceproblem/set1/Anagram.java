package com.practiceproblem.set1;
/* https://leetcode.com/problems/valid-anagram/ */
import java.util.Arrays;

public class Anagram {
    public boolean isAnagram(String s, String t){
        if(s.length () != t.length ()) return false;
        char[] source = s.toCharArray ();
        char[] target = t.toCharArray ();
        Arrays.sort (source);
        Arrays.sort(target);
        for(int i =0;i<source.length;i++){
            if(source[i] != target[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Anagram anagram = new Anagram ();
        System.out.println (anagram.isAnagram ("anagram","nagaram"));
        System.out.println (anagram.isAnagram ("rat","car"));
    }

}
