package practice_052321;
/*
https://leetcode.com/problems/two-sum/
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
*/

import java.util.HashMap;


public class TwoSum {
    private int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        HashMap<Integer, Integer> checkMap = new HashMap<>();// put all ith number in map until we find target-nums[i] exist in map
        checkMap.put(nums[0],0);
        for(int i = 1; i<nums.length;i++){
          if(checkMap.containsKey(target-nums[i])){ // if map has the target-nums[i], we got the pair.
                result[0] = checkMap.get(target-nums[i]);
                result[1] = i;
                break;
            }else{
              checkMap.put(nums[i],i);
          }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = {3,3};
        int[] result = twoSum.twoSum (arr, 6);
        System.out.println (result[0] + "," +result[1]);

    }
}
