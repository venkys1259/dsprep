package com.trees;
/* https://leetcode.com/problems/symmetric-tree/ */
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
       return isMirror(root,root);
    }

    private static boolean isMirror(TreeNode leftTree,TreeNode rightTree){
        if(leftTree == null && rightTree == null) return  true;
        if(leftTree == null || rightTree == null) return false;
        return leftTree.val == rightTree.val &&
            isMirror (leftTree.left,rightTree.right) && isMirror (leftTree.right,rightTree.left);

    }
    public static void main(String[] args) {
     Integer[] arr = {1,2,2,3,4,4,3};
     TreeNode treeNode = TreeUtils.arrayToTree (arr, 0);
     System.out.println (isSymmetric(treeNode));
    }
}
