package practice_05262021;

import java.util.*;

/*
https://leetcode.com/problems/4sum/
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.
Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
*/
public class FourSum {
    /*
    Approach:   sort the given array
  Maintain 3 pointers ( j k l) for every ith iteration,
  if sum is 0, move both j,k,l such that j,k will go forward, l will come backward
  if sum <0, means we need  more number to get 0 so do j++,k++
  if sum >0,  means we need  less number to get 0 so do l--, this is where sorted array helps

     */
    private List<List<Integer>> sum(int[] nums,int target){
        Set<List<Integer>> result = new HashSet<> ();
        Arrays.sort(nums);
        for(int i = 0; i< nums.length-2; i++){
           int j = i+1, k = j+1, l = nums.length-1;
           while(j<k && k<l){
               List<Integer> quat = new ArrayList<>();
               int sum = nums[i] + nums[j] + nums[k]+nums[l];
               if( sum == target){
                   quat.add(nums[i]);
                   quat.add(nums[j]);
                   quat.add(nums[k]);
                   quat.add(nums[l]);
                   result.add(quat);
                   j++;
                   k++;
                   l--;
               }
               else if(sum>target) l--;
               else j++;k++;
           }
        }


        return new ArrayList<>(result);
    }


    public static void main(String[] args) {
        int[] a = {1,0,-1,0,-2,2};
        FourSum fourSum = new FourSum();
        List<List<Integer>> sum0Lists = fourSum.sum (a,0);
        System.out.println (sum0Lists);
    }

}
