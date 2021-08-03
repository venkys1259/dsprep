package com.trees;

public class TreeCRUDOperations {
    private Node insert(int value,Node root){
        if(root == null) {
           return new Node(value);
        }else{
            Node current = root;
            Node temp=current;
            while(current!=null){
                temp = current;
                if(value < current.data){
                    current = current.left;
                }else{
                    current = current.right;
                }
            }
            if(value < temp.data){
                temp.left = new Node(value);
            }else{
                temp.right = new Node(value);
            }
            return temp;
        }
    }

    public Node find(int data,Node node){
        if(node.data == data) return node;
        else{
            Node current = node;
            Node temp=node;
            while(current!=null){
                temp = current;
                if(data == current.data){
                    return current;
                }
               else if(data<current.data){
                    current = current.left;
                }else{
                    current = current.right;
                }
            }
            if(temp.data == data) {
                return  temp;
            }else{
                return  null;
            }
        }
    }

    public void update(Node head,int oldValue,int newValue){
        Node node = find (oldValue,head);
        if(node!=null){
           node.data = newValue;
        }
    }

    public static void main(String[] args) {
        Node node = new Node (25);
        node.left = new Node(15);
        node.right = new Node(35);
        node.left.right = new Node(20);
        node.right.left  = new Node(27);
        node.right.right = new Node(45);
        TreeCRUDOperations crudOperations = new TreeCRUDOperations ();
        crudOperations.insert (9,node);
        crudOperations.insert (21,node);
        crudOperations.insert (5,node);
        TreeTraversals traversals = new TreeTraversals ();
        traversals.levelOrder (node);
        Node resultNode =  crudOperations.find (45, node);
        System.out.println ("NodeFound:::"+(resultNode!=null?resultNode.data:-1));
        Node resultNode2 =  crudOperations.find (90, node);
        System.out.println ("NodeFound:::"+(resultNode2!=null?resultNode2.data:-1));
        crudOperations.update (node,45,47);
        traversals.levelOrder (node);
    }
}
