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

    public boolean delete(Node head,int value){
        if(head == null) {
            return false;
        }
        Node current = head;
        Node parent = head;
        boolean isLeftChild = false;
        // Find the node to be deleted
        while(current!=null && current.data != value){
            parent = current;
            if(value == current.data){
                break;
            }
            else if(value < current.data){
                current = current.left;
                isLeftChild = true;
            }
            else{
                current = current.right;
                isLeftChild = false;
            }
        }
        if(current == null){
            return false;
        }
        // No children
        if(current.left == null && current.right == null) {
           if(isLeftChild){
               parent.left = null;
           }else{
               parent.right = null;
           }
        }
        // 1 children - has left child and no right child
       else if(current.left !=null && current.right==null){
            // copy the left child and link as
            if(isLeftChild) {
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
       else if ( current.left == null && current.right!=null){
           if(!isLeftChild) {
               parent.right = current.right;
           }else{
               parent.left = current.right;
           }
        }
       // Has 2 children - both left and right
       else{
           // find the successor of current and assign it to parent's left/right based on current node left/right
            Node successor = getSuccessor(current);
            if(current.right != successor){
                if(isLeftChild){
                    parent.left.data = successor.data;
                }else {
                    parent.right.data = successor.data;
                }
                delete (head,successor.data);
            }else{
               // if the successor is right child, we cannot replace the deleted node with it
                // it will violate BST property
                Node predecessor = getPredecessor (current);
                int tobeReplaced = predecessor.data;
                delete (head,predecessor.data);
                if(isLeftChild){
                    parent.left.data = tobeReplaced;
                }else {
                    parent.right.data = tobeReplaced;
                }
            }

        }
      return true;
    }
    // Successor: from current go to right child and then left most node
    public Node getSuccessor(Node current) {
        Node successor = null;
        if(current.right!=null){
            Node node = current.right;
            while(node!=null){
                successor = node;
                node = node.left;
            }
        }
        return  successor;
    }
    // Predecessor: from current go to left child and then right most node
    public Node getPredecessor(Node current){
        Node predecessor = null;
        if(current.left!=null){
           Node node = current.left;
            while(node!=null){
                predecessor = node;
                node = node.right;
            }
        }
           return predecessor;
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
        traversals.inorder (node);
        Node resultNode =  crudOperations.find (45, node);
        System.out.println ("NodeFound:::"+(resultNode!=null?resultNode.data:-1));
        Node resultNode2 =  crudOperations.find (90, node);
        System.out.println ("NodeFound:::"+(resultNode2!=null?resultNode2.data:-1));
        traversals.levelOrder (node);
        crudOperations.delete (node,35);
        System.out.println ("After deletion of 35 which has 2 children:::");
        traversals.levelOrder (node);
        crudOperations.delete (node,15);
        System.out.println ("After deletion of 15 which has 1 children:::");
        traversals.inorder (node);
        crudOperations.delete (node,5);
        System.out.println ("After deletion of 5 which has No children:::");
        traversals.inorder (node);
    }
}

