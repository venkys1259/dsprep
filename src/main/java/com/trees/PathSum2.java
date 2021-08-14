package com.trees;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/path-sum-ii/ */
public class PathSum2 {
    private List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> nodesList = new ArrayList<> ();
        if(root == null) return nodesList;
        List<Integer> nodes = new ArrayList<> ();
        nodes.add (root.val);
        pathSum(root,targetSum,root.val,nodes,nodesList);
        return nodesList;
    }
    private void pathSum(TreeNode root, int targetSum,int sum,List<Integer> nodes,List<List<Integer>> nodesList) {
     if (root.left == null && root.right == null && sum == targetSum) {
         // copy nodes list to temp result, since we will be using nodes further also.
           List<Integer> resultNodes = new ArrayList<> ();
           for(Integer result: nodes){
               resultNodes.add(result);
           }
         nodesList.add(resultNodes);
         return;
        }
        else {
          if(root.left!=null) {
              nodes.add(root.left.val);
              pathSum (root.left, targetSum, root.left.val + sum,nodes,nodesList);
              nodes.remove (nodes.size ()-1);
          }
            if(root.right!=null) {
                nodes.add(root.right.val);
                pathSum (root.right, targetSum, root.right.val + sum,nodes,nodesList);
                nodes.remove (nodes.size ()-1);
            }
         }
    }
    public static void main(String[] args) {
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        PathSum2 pathSum2 = new PathSum2 ();
        TreeNode root = TreeUtils.arrayToTree (arr,0);
        System.out.println (pathSum2.pathSum(root,22));
    }
}
