package com.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    public void inorder(Node node){
            if(node!=null){
                inorder (node.left);
                System.out.println (node.data);
                inorder (node.right);
            }
    }
    /*InOrder: Iterative Way : Left Node Right */
    public void inorderIterative(Node node){
        if(node == null) return;
        Stack<Node> stack = new Stack<>();
        Node current = node;
        while(current!=null || !stack.isEmpty()){
            while(current!=null){
                stack.push (current);
                current = current.left;
            }
           current = stack.pop();
           System.out.println (current.data);
            current = current.right;
        }
    }

    /*PreOrder: Node Left Right */
    public void preorder(Node node){
        if(node!=null){
            System.out.println (node.data);
            preorder (node.left);
            preorder (node.right);
        }
    }
    /*PreOrder: Iterative Way Node Left Right */
    public void preorderIterative(Node node){
        Stack<Node> stack = new Stack<> ();
        Node current = node;
        while(current!=null || !stack.isEmpty ()){
            while(current!=null){
                System.out.println (current.data);
                stack.push (current);
                current = current.left;
            }
            current = stack.pop ();
            current = current.right;
        }
    }
    /*PostOrder: Left Right Node */
    public void postorder(Node node){
        if(node!=null) {
            postorder (node.left);
            postorder (node.right);
            System.out.println (node.data);
        }
    }
    /* PostOrder: IterativeWay Left Right Root */
    /*private void postorderIterative(Node node){
        Stack<Node> stack = new Stack<> ();
        Node current = node;
        while(current!=null || !stack.isEmpty ()){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.peek ();
            System.out.println (current.right.data);
            current = current.right;
        }
    }*/
    /* level order: Breadth first */
    public void levelOrder(Node node) {
        System.out.println ("Level Order Traversal:::");
        Queue<Node> queue = new LinkedList<> ();
        queue.add (node);
        while (!queue.isEmpty ()) {
            Node temp = queue.poll ();
            System.out.println (temp.data);
            if (temp.left != null) {
                queue.add (temp.left);
            }
            if (temp.right != null) {
                queue.add (temp.right);
            }
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
        System.out.println ("Inorder Iterative:::::" );
        traversals.inorderIterative (node);
        System.out.println ("Preorder:::::" );
        traversals.preorder (node);
        System.out.println ("Preorder Iterative:::::" );
        traversals.preorderIterative (node);
        System.out.println ("Postorder:::::" );
        traversals.postorder (node);
        traversals.levelOrder (node);
    }
}
