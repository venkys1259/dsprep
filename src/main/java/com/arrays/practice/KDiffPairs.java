package com.arrays.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KDiffPairs {
    /*
    Insert all array elements into HashMap.
    Iterate through the array and check if nums[i] -k value is present in Map
    if it is present, we got the pair.
    we should return only unique pairs, so if already pair found, don't include it
     */
    public int findPairs(int[] nums, int k) {
        int counter = 0;
        Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();
        List<Integer> alreadyPairedIndexList = new ArrayList<Integer>();
        for(int i = 0; i<nums.length;i++){
            numMap.put(nums[i],i);
        }
        for(int i = 0; i<nums.length;i++){
            if(numMap.containsKey(nums[i]-k) && i!= numMap.get(nums[i]-k)){
                if(!alreadyPairedIndexList.contains(numMap.get(nums[i]-k))){
                    counter++;
                    alreadyPairedIndexList.add(numMap.get(nums[i]-k));
                }
            }

        }
        return counter;
    }

    public static void main(String[] args) {
        KDiffPairs kdiff = new KDiffPairs ();
        int[] nums = {1,2,4,4,3,3,0,9,2,3};
        System.out.println (kdiff.findPairs (nums,3));
    }
}
