package com.trees;
/* https://leetcode.com/problems/sum-root-to-leaf-numbers/ */
// This is almost similar to PathSum2
import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        List<Integer> nodesList = new ArrayList<> ();
        List<Integer> rootToLeafList = new ArrayList<> ();
        nodesList.add (root.val);
        rootToLeaf(root,nodesList,rootToLeafList);
        int sum = 0;
        for(Integer num:rootToLeafList){
            sum = sum+num;
        }
        System.out.println (rootToLeafList);
     return sum;
    }

   public void rootToLeaf(TreeNode root, List<Integer> numbers, List<Integer> rootToLeafList){
        if(root.left == null && root.right == null){
            String nodeValue = "";
            for(Integer str:numbers){
                nodeValue = nodeValue+str;
            }
            rootToLeafList.add(Integer.parseInt (nodeValue));
            return;
        }
       if(root.left!=null) {
           numbers.add (root.left.val);
           rootToLeaf (root.left, numbers, rootToLeafList);
           numbers.remove (numbers.size () - 1);
       }
       if(root.right!=null){
           numbers.add (root.right.val);
           rootToLeaf(root.right,numbers,rootToLeafList);
           numbers.remove (numbers.size ()-1);
       }
   }

    public static void main(String[] args) {
        Integer[] arr = {4,9,0,5,1};
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf ();
        TreeNode root = TreeUtils.arrayToTree (arr,0);
        System.out.println (sumRootToLeaf.sumNumbers(root));
    }

}
