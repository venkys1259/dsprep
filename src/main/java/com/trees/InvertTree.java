package com.trees;
/* https://leetcode.com/problems/invert-binary-tree/ */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
       if(root!=null){
           invertTree(root.left);
           invertTree(root.right);
           TreeNode temp = root.right;
           root.right = root.left;
           root.left = temp;
       }
       return root;
    }
    public static void main(String[] args) {
        Integer[] arr = {4,2,7,1,3,6,9};
        InvertTree iTree = new InvertTree ();
        TreeNode root = TreeUtils.arrayToTree (arr,0);
        root = iTree.invertTree(root);
        TreeUtils.levelOrder (root);
    }
}
