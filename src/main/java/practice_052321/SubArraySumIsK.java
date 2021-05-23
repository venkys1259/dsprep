package practice_052321;

import java.util.HashMap;

/*
https://leetcode.com/problems/subarray-sum-equals-k/
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 */
public class SubArraySumIsK {
    /*
    compute the prefix sum by adding the sum of the elements till ith element
    push the prefix sum into hashmap and check if (k-prefixsum) entry exists in map, if yes increment counter
    also check if the ith element is k then increment counter
     */
    private int subArraySum(int[] a,int k){
        HashMap<Integer,Integer> prefixSumMap = new HashMap<>();
        int counter = 0,prefixSum = 0;
        if(a.length == 1){ // Edge Case
            if( a[0] == k){
                counter = 1;
            }
            return counter;
        }
        for(int i = 0; i<a.length;i++){
            prefixSum = prefixSum + a[i];
            if(prefixSum == k){ // if sum till now == k then we should consider
                counter = counter+1;
            }
            if(prefixSumMap.get(prefixSum)!=null ) { // the same sum value already exists
                prefixSumMap.put (prefixSumMap.get (prefixSum), prefixSumMap.get (prefixSum) + 1);
            }
            else{
                prefixSumMap.put(prefixSum,1);
            }
            if(prefixSumMap.containsKey(prefixSum-k)){ // if prefixSum-k exists in map
                counter = counter+1;
            }
        }

        return counter;
    }




    public static void main(String[] args) {
        SubArraySumIsK sumIsK = new SubArraySumIsK();
        int[] a = {3,-1,4,-2,2,-1,4,-1};
        int numberOfSubArrays = sumIsK.subArraySum (a, 3);
        System.out.println (numberOfSubArrays);

    }
}
