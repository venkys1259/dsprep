package practice_05272021;
/*
https://leetcode.com/problems/find-all-duplicates-in-an-array/
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

 Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []
 */
import java.util.*;

public class DuplicateElementInArray {
    private List<Integer> findDup(int[] nums) {
        List<Integer> dupList = new ArrayList<> ();
        Map<Integer,Integer> numsMap = new HashMap<> ();
        int counter = 0;
        for(int i = 0; i<nums.length;i++){
            if(numsMap.containsKey(nums[i])){
                dupList.add(nums[i]);
            }else{
                numsMap.put(nums[i],counter);
            }

        }
        return dupList;
    }

    private List<Integer> findDups(int[] nums) {
        List<Integer> dupList = new ArrayList<> ();
        int position = 0;
        for(int i = 0; i<nums.length;i++){
            position = Math.abs(nums[i])-1;
            if(nums[position] <0 ){
                dupList.add(position+1);
            }
            nums[position] = -nums[position];
        }
        return dupList;
    }

    /*
     O(N) with Constant space.
     */

    private List<Integer> findDuplicates(int[] nums) {
        List<Integer> dupList = new ArrayList<> ();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                dupList.add(nums[i]);
            }

        }
        return dupList;
    }


    public static void main(String[] args) {
        int[] a = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = new DuplicateElementInArray ().findDuplicates (a);
        System.out.println (duplicates);
    }
}
