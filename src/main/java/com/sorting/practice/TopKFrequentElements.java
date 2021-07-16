package com.sorting.practice;

import java.util.*;

/* https://leetcode.com/problems/top-k-frequent-elements/ */
public class TopKFrequentElements {
    private int[] topKFrequent(int[] nums, int k){
        Map<Integer,Integer> freqMap = new LinkedHashMap<> ();
        for(int i = 0; i<nums.length;i++){
            int existingElementCount = freqMap.getOrDefault (nums[i],0);
            freqMap.put(nums[i],existingElementCount+1);
        }
        Comparator< Map.Entry<Integer,Integer> > descFreqComparator = (e1, e2) -> e2.getValue() - e1.getValue();
        PriorityQueue< Map.Entry<Integer, Integer> > priorityQueue = new PriorityQueue<>(descFreqComparator);
        for(Map.Entry<Integer, Integer> entry:freqMap.entrySet ()){
            priorityQueue.add(entry);
        }
        int[] result = new int[k];
        int counter = 0;
        while(k != 0){
            result[counter] = priorityQueue.poll().getKey ();
            k--;counter++;
        }
        return result;
    }
    public static void main(String[] args) {
    int[] a = {2,2,2,2,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5};
    int[] result = new TopKFrequentElements().topKFrequent (a,2);
    System.out.println(Arrays.toString (result));
    }
}
