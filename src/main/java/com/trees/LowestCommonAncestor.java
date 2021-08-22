package com.trees;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/ */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return  root;
        TreeNode left = lowestCommonAncestor (root.left,p,q);
        TreeNode right = lowestCommonAncestor (root.right,p,q);
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }


    public static void main(String[] args) {
        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeUtils.arrayToTree (arr,0);
        LowestCommonAncestor lca = new LowestCommonAncestor ();
        TreeNode p = new TreeNode (5);
        TreeNode q = new TreeNode (1);
        TreeNode node = lca.lowestCommonAncestor (root,p,q);
        System.out.println (node.val);
    }
}
