package com.greedyproblems;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/* https://leetcode.com/problems/majority-element/ */
public class MajorityElement {
    /* bruteforce */
    public int majorityElement2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<> ();
        for(int i = 0; i<nums.length;i++){
          map.put(nums[i], map.getOrDefault (nums[i],0)+1);
        }
        map = map.entrySet ().stream ().sorted ((a,b) -> b.getValue ()- a.getValue ()).collect (
                Collectors.toMap (Map.Entry::getKey,Map.Entry::getValue,(e1,e2) ->e1, LinkedHashMap::new));


        return map.entrySet ().iterator ().next ().getKey ();
    }

    /* Moore voting algorithm
    *
    * step 1 : find the candidate for majority element
    *
    * ste 2: verify if the candidate is really a majority element
    *
    *
    * */

    public int findCandidate(int[] nums){
        int count = 1, candidate = nums[0];
        for(int i = 1; i < nums.length;i++){
            if(nums[i]  == candidate){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                candidate = nums[i];
                count = 1;
            }
        }
       if(isMajorityElement(nums,candidate)){
           return candidate;
       }else{
           return  -1;
       }
    }

    public boolean isMajorityElement(int[] nums,int num){
        int n = nums.length/2, counter = 0;
        for(Integer i: nums){
            if(i == num){
                counter ++;
            }
        }
        if(counter > n){
            return true;
        }
        return false;
    }

    public int majorityElement(int[] nums){
        return  findCandidate(nums);
    }

    public static void main(String[] args) {
     int[] nums = {2,2,1,1,1,2,2};
     MajorityElement mel = new MajorityElement ();
     System.out.println (mel.majorityElement (nums));
    }
}
