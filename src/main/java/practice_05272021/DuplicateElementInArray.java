package practice_05272021;

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
        int index = 0;
       for(int i = 0; i<nums.length;i++){
           index = Math.abs(nums[i]) -1 ;
           if(nums[index] < 0){
               dupList.add(nums[i]);
           }else{
               nums[index] = -nums[index];
           }
       }
        return dupList;
    }

    /*
     O(N) with Constant Time.
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
