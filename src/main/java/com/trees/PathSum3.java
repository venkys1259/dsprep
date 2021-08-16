package com.trees;

import java.util.ArrayList;
import java.util.List;

public class PathSum3 {
    int count = 0;
    List<Integer> nodesList = new ArrayList<> ();
    public int pathSum3(TreeNode root, int targetSum) {
        calcSum (root,targetSum);
        return count;
    }

    private void calcSum(TreeNode root, int targetSum) {
        if(root == null) return;
        nodesList.add(root.val);
        calcSum (root.left, targetSum);
        calcSum (root.right, targetSum);
        int tempSum = 0;
        for(int i = nodesList.size ()-1; i>=0; i--){
            tempSum = tempSum+ nodesList.get(i);
            if(tempSum == targetSum){
                count = count+1;
            }
        }
        nodesList.remove (nodesList.size ()-1);
    }


    public static void main(String[] args) {
        Integer[] arr = {10,5,-3,3,2,null,11,3,-2,null,1};
        PathSum3 sum3 = new PathSum3 ();
        TreeNode root = TreeUtils.arrayToTree (arr,0);
        System.out.println (sum3.pathSum3(root,8));
    }
}
