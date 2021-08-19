package com.trees;
/* https://leetcode.com/problems/range-sum-of-bst/ */
public class RangeSumOfBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root!=null){
            if(root.val < low){
                rangeSumBST (root.right, low,high);
            }else{
                if(root.val <= high){
                    sum = sum+root.val;
                }
                rangeSumBST (root.left,low,high);
                rangeSumBST (root.right,low,high);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Integer[] arr = {10,5,15,3,7,13,18,1,null,6};
        TreeNode root = TreeUtils.arrayToTree (arr,0);
        RangeSumOfBST rangeSum = new RangeSumOfBST ();
        System.out.println (rangeSum.rangeSumBST (root,6,10));
    }
}
