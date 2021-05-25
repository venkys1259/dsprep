package practice_05252021;
/*
https://leetcode.com/problems/3sum/
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:
Input: nums = []
Output: []
Example 3:
Input: nums = [0]
Output: []
 */
import java.util.*;

public class ThreeSum {
    // Tried similar to 2Sum
    /*
    Approach:
    1)put all the elements into hash map with key as number and
    there will be chance of same number in given input, so value will be list of indexes.
    2)iterate through given array
      a) check if map contains ( k-sum of i and i+1), if yes add them to result
      b) if the result already contains same tuple, don't add.


    **/
    private List<List<Integer>> threeSum(int[] nums){
        HashMap<Integer,List<Integer>> numMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int k = 0;
        for(int i = 0; i<nums.length;i++){
          if(!numMap.containsKey(nums[i])){
              List<Integer> keysList = new ArrayList<>();
              keysList.add(i);
              numMap.put(nums[i],keysList);
          }else{
              List<Integer> existingKeys = numMap.get (nums[i]);
              existingKeys.add(i);
              numMap.put(nums[i],existingKeys);
          }
        }
        for(int i=0;i<nums.length-1;i++){
            int searchElement = k-(nums[i] + nums[i+1]);
            int thirdEleIndex;
            boolean tripletExists = false;
            if(numMap.containsKey(searchElement)){
                thirdEleIndex = numMap.get(searchElement).get(0);
                // Check if same type of triplet exists, if yes dont add
                for(List<Integer> list: result) {
                    if ((nums[i] == list.get (0) || nums[i] == list.get (1) || nums[i] == list.get (2)) &&
                            (nums[i + 1] == list.get (0) || nums[i + 1] == list.get (1) || nums[i + 1] == list.get (2)) &&
                            (nums[thirdEleIndex] == list.get (0) || nums[thirdEleIndex] == list.get (1) || nums[thirdEleIndex] == list.get (2))) {
                        tripletExists = true;
                    }
                }
                   if(!tripletExists){
                       ArrayList<Integer> triplet = new ArrayList<>();
                       triplet.add(nums[i]);
                       triplet.add(nums[i+1]);
                       triplet.add(nums[thirdEleIndex]);
                       result.add(triplet);
                   }
            }
        }
        return result;
    }
/*
  Optimized way -->
  sort the given array
  Maintain 2 pointers ( j and k) for every ith iteration,
  if sum is 0, move both j and k such that j will go forward, k will come backword
  if sum <0, means we need  more number to get 0 so do j++
  if sum >0,  means we need  less number to get 0 so do k--, this is where sorted array helps
 */
    private List<List<Integer>> sum(int[] nums){
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2;i++){
            int j = i+1, k = nums.length-1;
            while(j<k){
                List<Integer> triplet = new ArrayList<>();
                int sum = nums[i] + nums[j] + nums[k];
                if( sum == 0){
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    result.add(triplet);
                    j++;k--;
                }
                else if(sum>0) k--;
                else j++;
            }
        }
       return new ArrayList(result);
    }


    public static void main(String[] args) {
      int[] a = {-1,0,1,2,-1,-4};
      List<List<Integer>> lists = new ThreeSum().sum (a);
        System.out.println (lists);
    }
}
