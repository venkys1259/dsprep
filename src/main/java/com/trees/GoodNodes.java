package com.trees;

import java.util.List;

/* https://leetcode.com/problems/count-good-nodes-in-binary-tree/ */
public class GoodNodes {
    public int goodNodes(TreeNode root) {
        return goodNodes(root,Integer.MIN_VALUE);
    }

    public int goodNodes(TreeNode root,Integer max){
        int goodNode = 0;
        if (root == null) return goodNode;
        //check if current node is a good node
        if (root.val >= max) {
            goodNode++;
        }
        max = Math.max(root.val, max);
        return goodNode + goodNodes(root.left, max) + goodNodes(root.right, max);
    }

    public void goodNodes(TreeNode root, List<TreeNode> goodNodesList,List<TreeNode> goodNodesInPathList){
        if(root!=null){
            if(isGoodNode(root, goodNodesInPathList)) {
                goodNodesList.add (root);
                goodNodesInPathList.add (root);
            }
            if(root.left==null && root.right == null) {
                goodNodesInPathList.remove (goodNodesInPathList.size () - 1);
            }
            goodNodes (root.left,goodNodesList,goodNodesInPathList);
            goodNodes (root.right,goodNodesList,goodNodesInPathList);
        }
    }
    public boolean isGoodNode(TreeNode node, List<TreeNode> goodNodesInPathList){
       for(TreeNode treeNode:goodNodesInPathList){
           if(node.val < treeNode.val){
               return false;
           }
       }
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr = {3,1,4,3,null,1,5};
        GoodNodes goodNodes = new GoodNodes ();
        TreeNode root = TreeUtils.arrayToTree (arr,0);
        System.out.println (goodNodes.goodNodes (root));
    }
}
