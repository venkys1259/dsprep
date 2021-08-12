package com.trees;
/*
https://leetcode.com/problems/path-sum/


 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        else if(root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        else{
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum -                                      root.val);
        }
    }
    public boolean hasPathSum2(TreeNode root, int targetSum, int sum){
       if(root!=null) {
       boolean result =  hasPathSum2(root.left,targetSum,sum+root.val);
       if(result) {
          return true;
       }else {
           hasPathSum2 (root.right, targetSum, sum + root.val);
       }
        }
        return (sum==targetSum) ;
    }

    public boolean hasPathSum3(TreeNode root, int targetSum, int sum){
        if(root!=null) {
         return  (hasPathSum3 (root.left,targetSum,sum+root.val) ||
                 hasPathSum3 (root.right,targetSum,sum+root.val));
        }
        return (sum==targetSum) ;
    }

    public static void main(String[] args) {
     Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,null,1,22};
     PathSum pathSum = new PathSum ();
     TreeNode root = TreeUtils.arrayToTree (arr,0);
     System.out.println (pathSum.hasPathSum (root,22));
    }
}
