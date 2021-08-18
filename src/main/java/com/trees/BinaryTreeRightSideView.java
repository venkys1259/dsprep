package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* https://leetcode.com/problems/binary-tree-right-side-view/ */
public class BinaryTreeRightSideView {
    List<Integer> list = new ArrayList<> ();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return  list;
        Queue<TreeNode> queue = new LinkedList<> ();
        TreeNode dummy = new TreeNode ();
        queue.add(root);
        queue.add(dummy);
        list.add(root.val);
        int rightMostNumber = root.val;
        while(!queue.isEmpty ()){
            TreeNode node = queue.poll ();
            if(node == dummy){
                if(queue.isEmpty ()) break;
                queue.add (dummy);
                list.add (rightMostNumber);
                continue;
            }
            if(node.left!=null){
                queue.add(node.left);
                rightMostNumber = node.left.val;
            }
            if(node.right!=null){
                queue.add(node.right);
                rightMostNumber = node.right.val;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,null,5,null,4};
        BinaryTreeRightSideView brv = new BinaryTreeRightSideView ();
        TreeNode root = TreeUtils.arrayToTree (arr,0);
        System.out.println (brv.rightSideView(root));
    }
}
