package com.trees;
/* https://www.geeksforgeeks.org/maximum-average-of-subtree-values-in-a-given-binary-tree/ */
public class MaximumAverageValue {
    double currentMax = Double.MIN_VALUE;
    public double maxAvgValue(TreeNode root){
        return maxAvg (root,Double.MIN_VALUE);
    }
    public double maxAvg(TreeNode root,double max){
        if(root!=null){
            double left = maxAvg(root.left,max);
            double right = maxAvg(root.right,max);
            if(root.left == null && root.right == null){
                max = root.val;
            }
            else if(root.left != null && root.right != null){
                max = (left+right+ root.val) / 3;
            }
            else if(root.left == null && root.right!=null){
                max = (right+root.val)/2;
            }
            else{
                max = (left+root.val)/2;
            }
            currentMax =  Math.max(max,currentMax);
        }
        return currentMax;
    }

    public static void main(String[] args) {
        MaximumAverageValue maxAvgVal = new MaximumAverageValue ();
        Integer[] arr = {5,6,10,7,8,2,3};
        TreeNode root = TreeUtils.arrayToTree (arr,0);
        System.out.println (maxAvgVal.maxAvgValue (root));
    }
}
