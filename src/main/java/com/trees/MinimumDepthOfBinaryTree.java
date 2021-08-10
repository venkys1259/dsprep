package com.trees;
/* https://leetcode.com/problems/minimum-depth-of-binary-tree/ */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return  0;
        if(root.left == null && root.right == null) return  1;
        if(root.left!=null && root.right ==null){
            return  1+minDepth (root.left);
        }
        if(root.right!=null && root.left ==null){
            return  1+minDepth (root.right);
        }
        if(root.left!=null && root.right !=null){
            return  1+ Math.min(minDepth (root.left),minDepth (root.right));
        }
      return 0;
    }
    public static void main(String[] args) {
        MinimumDepthOfBinaryTree depth = new MinimumDepthOfBinaryTree ();
        Integer[] root = {3,9,20,null,null,15,7};
        TreeNode treeNode = TreeUtils.arrayToTree (root, 0);
        System.out.println (depth.minDepth (treeNode));
    }
}
