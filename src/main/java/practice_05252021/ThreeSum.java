package practice_05252021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
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
    public static void main(String[] args) {
      int[] a = {-1,0,1,2,-1,-4};
      List<List<Integer>> lists = new ThreeSum().threeSum(a);
        System.out.println (lists);
    }
}
