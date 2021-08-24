package com.trees;
/*https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/ */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> totalList = new ArrayList<> ();
        if(root == null) return totalList;
        Queue<TreeNode> queue = new LinkedList<> ();
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        queue.add(root);
        queue.add(dummy);
        List<Integer> list = new ArrayList<> ();
        boolean needToZigZag = false;
        while(!queue.isEmpty ()){
            TreeNode node = queue.poll ();
            if(node == dummy){
                if(needToZigZag){ // if we need to zigzag for that level, make 0th as 1st and 1st as 0th element of list
                    List<Integer> reArrangedList = new ArrayList<> ();
                    for(int i = list.size ()-1; i>=0;i--){
                        reArrangedList.add (list.get (i));
                    }
                    totalList.add(reArrangedList);
                }else{
                    totalList.add (list);
                }
                needToZigZag = !needToZigZag;
                if(queue.isEmpty ()){
                    break;
                }
                 queue.add(dummy);
                 list = new ArrayList<> ();
                continue;
            }
            if(node != null){
                list.add (node.val);
            }
           if(node.left!=null) {
                queue.add (node.left);
            }
            if(node.right!=null) {
                queue.add (node.right);
            }
        }
         return  totalList;
    }
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        TreeNode root = TreeUtils.arrayToTree (arr,0);
        ZigZagLevelOrder zigZag = new ZigZagLevelOrder ();
        System.out.println (zigZag.zigzagLevelOrder (root));
    }
}
