package com.sorting.practice;

import java.util.*;

public class TopKFrequentWords {
    class FrequencyComparator implements Comparator<Map.Entry<String,Integer>>{
        @Override
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            if(e1.getValue () > e2.getValue ()){
                return -1;
            }else if(e1.getValue () < e2.getValue()){
                return 1;
            }else{
                return e1.getKey().compareTo (e2.getKey());
            }
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String,Integer> freqMap = new HashMap<> ();
        for(int i = 0; i< words.length;i++){
            freqMap.put (words[i], freqMap.getOrDefault (words[i],0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> heap = new PriorityQueue<> (new FrequencyComparator());
        for(Map.Entry<String,Integer> entry : freqMap.entrySet ()){
            heap.add (entry);
        }
        while(k!=0){
            result.add(heap.poll().getKey());
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
    String[] strings = {"i", "love", "leetcode", "i", "love", "coding","love","coding","coding","love","coding"};
    TopKFrequentWords topk = new TopKFrequentWords();
    System.out.println (topk.topKFrequent(strings,2));
    }

}
