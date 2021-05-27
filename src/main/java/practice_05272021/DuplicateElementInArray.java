package practice_05272021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateElementInArray {
    private List<Integer> findDuplicates(int[] nums) {
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
    public static void main(String[] args) {
        int[] a = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = new DuplicateElementInArray ().findDuplicates (a);
        System.out.println (duplicates);
    }
}
