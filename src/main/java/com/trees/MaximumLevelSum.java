package com.trees;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/ */
public class MaximumLevelSum {
    int maxLevel = 1,sum = 0;
    public int maxLevelSum(TreeNode root) {
    if(root == null) return 0;
    if(root.left == null && root.right == null)
        return 1;
    else {
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add (root);
        TreeNode dummy = new TreeNode (Integer.MAX_VALUE);
        queue.add(dummy);
        int level = 1, prevSum = Integer.MIN_VALUE;
        while (!queue.isEmpty ()) {
            TreeNode temp = queue.poll ();
            if(temp == dummy){
                if(sum>prevSum) {
                    maxLevel =level;
                }
                if(queue.isEmpty ()) break;
                queue.add(dummy);
                level++;
                prevSum = sum;
                sum = 0;
                continue;
            }else{
                sum = sum +temp.val;
            }
            if(temp.left != null){
                queue.add (temp.left);
            }
           if(temp.right != null){
               queue.add(temp.right);
           }
        }
        return maxLevel;
    }
    }
    private int maxLevelSum(TreeNode root,int sum,int level){
        if(root!=null && (root.left!=null || root.right!=null)) {
            level++;

            int temp = (root.right!=null?root.right.val:0) + (root.left!=null?root.left.val:0);

            if (temp > sum) {
                maxLevel = level;
                sum = temp;
            }

            if (root != null) {
                maxLevelSum (root.left, sum,  level);
                maxLevelSum (root.right, sum, level);
            }
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,1,0,7,-8,-7,9};
        MaximumLevelSum mSum = new MaximumLevelSum ();
        TreeNode root = TreeUtils.arrayToTree (arr,0);
        System.out.println (mSum.maxLevelSum (root));
    }
}
