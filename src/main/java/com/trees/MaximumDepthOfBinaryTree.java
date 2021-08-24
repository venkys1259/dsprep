package com.trees;
/* https://leetcode.com/problems/maximum-depth-of-binary-tree/ */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root,int maxDepth) {
        if(root!=null){
            int leftCount = 1+maxDepth (root.left,maxDepth);
            int rightCount = 1+maxDepth (root.right,maxDepth);
            maxDepth= Math.max (leftCount,rightCount);
        }
     return  maxDepth;
    }
    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        MaximumDepthOfBinaryTree mdb = new MaximumDepthOfBinaryTree ();
        TreeNode root = TreeUtils.arrayToTree (arr,0);
        System.out.println (mdb.maxDepth (root,0));
    }

}
