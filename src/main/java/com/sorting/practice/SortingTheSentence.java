package com.sorting.practice;

import java.util.*;

/*
https://leetcode.com/problems/sorting-the-sentence/
 */
public class SortingTheSentence {
    public String sortSentence(String s) {
        String[] str = s.split ("\\s");
        Map<Integer,String> map = new HashMap<>();
        for(int i = 0; i<str.length;i++){
            map.put(Integer.valueOf (str[i].charAt(str[i].length()-1)),str[i].substring (0,str[i].length()-1));
        }
        Comparator<Map.Entry<Integer,String>> comparator = (e1,e2)->e1.getKey ()-e2.getKey ();
        Queue<Map.Entry<Integer,String>> heap = new PriorityQueue<> (comparator);
        for(Map.Entry<Integer,String> entry: map.entrySet ()){
            heap.add(entry);
        }
        String result = "";
        while(!heap.isEmpty()){
            result = result +heap.poll().getValue ()+" ";
        }
        return result.trim ();
    }
    public static void main(String[] args) {
        SortingTheSentence sort = new SortingTheSentence();
        System.out.println (sort.sortSentence("is2 sentence4 This1 a3"));
    }
}
