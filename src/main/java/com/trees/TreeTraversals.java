package com.trees;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}
public class TreeTraversals {
    /* InOrder: Left Node Right */
    private void inorder(Node node){
            if(node!=null){
                inorder (node.left);
                System.out.println (node.data);
                inorder (node.right);
            }
    }
    /*PreOrder: Node Left Right */
    private void preorder(Node node){
        if(node!=null){
            System.out.println (node.data);
            preorder (node.left);
            preorder (node.right);
        }
    }
    /*PostOrder: Left Right Node */
    private void postorder(Node node){
        if(node!=null) {
            postorder (node.left);
            postorder (node.right);
            System.out.println (node.data);
        }
    }
    public static void main(String[] args) {
        Node node = new Node (25);
        node.left = new Node(15);
        node.right = new Node(35);
        node.left.right = new Node(20);
        node.right.left  = new Node(27);
        node.right.right = new Node(45);
        TreeTraversals traversals = new TreeTraversals ();
        System.out.println ("Inorder:::::" );
        traversals.inorder (node);
        System.out.println ("Preorder:::::" );
        traversals.preorder (node);
        System.out.println ("Postorder:::::" );
        traversals.postorder (node);
    }
}
