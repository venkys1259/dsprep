package com.practiceproblem.set1;
/* https://leetcode.ca/2020-06-06-1650-Lowest-Common-Ancestor-of-a-Binary-Tree-III/ */
public class LowestCommonAncestor {
    class Node{
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
    public Node lca(Node root,Node p, Node q){
        if(root == null) return null;
        if(root.left == null && root.right == null) return  root;
        if(root.val == p.val || root.val == q.val ){
            Node parent = root.parent;
            if(parent.left !=null && parent.right!=null){
                if((p.val == parent.left.val && q.val == parent.right.val) ||
                        (q.val == parent.left.val && p.val == parent.right.val)){
                  return parent;
                }
            }else{
                return  root;
            }
        }
        lca(root.left,p,q);
        lca(root.right,p,q);
        return root;
    }

    public static void main(String[] args) {

    }
}
