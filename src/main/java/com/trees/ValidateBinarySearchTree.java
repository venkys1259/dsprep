package com.trees;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/validate-binary-search-tree/
 */
 class TreeNode {
     int val;
    TreeNode left;
   TreeNode right;
   TreeNode() {}
   TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
         this.right = right;
     }
 }
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add(root);
        while(!queue.isEmpty ()){
            TreeNode treeNode = queue.poll ();
            if(treeNode.left !=null){
                if(treeNode.left.val < treeNode.val){
                    queue.add (treeNode.left);
                }else{
                    return  false;
                }
            }
            if(treeNode.right !=null){
                if(treeNode.right.val > treeNode.val){
                    queue.add (treeNode.right);
                }else{
                    return  false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode (5);
        head.left = new TreeNode (4);
        head.right = new TreeNode (6);
        head.left.left = null;
        head.left.right = null;
        head.right.left = new TreeNode (3);
        head.right.right = new TreeNode (7);
        ValidateBinarySearchTree validate = new ValidateBinarySearchTree ();
        System.out.println (validate.isValidBST (head));

    }
}
