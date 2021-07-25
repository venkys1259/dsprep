package com.linkedlist;

class Node {
    public int data;
    public Node next;
    Node(int data) {
        this.data = data;
    }
}
public class LinkedListOperations {
    Node head;
        public void add(int data) {
            Node newNode = new Node (data);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
        public void addAtFirst(int data){
            Node node = new Node(data);
            if (head != null) node.next = head;
            head = node;
        }

        public void delete(int data){ // To delete, just go to previous
            Node node = find (data);
            if(node!=null){
                node.next = node.next.next;
            }
        }

        public Node find(int data){
            Node temp = head;
            while(temp.next!=null){
                if(temp.next.data == data)
                return temp;
                temp = temp.next;
            }
           return null;
        }

        public void print(){
            Node temp= head;
            while(temp.next!=null){
                System.out.println (temp.data);
                temp = temp.next;
            }
            System.out.println (temp.data); // To print last element data.
        }

    public static void main(String[] args) {
        LinkedListOperations ll = new LinkedListOperations();
        ll.add (5);
        ll.add (6);
        ll.add (7);
        ll.print();
        System.out.println ("===================");
        ll.addAtFirst (4);
        ll.print();
        ll.delete (6);
        System.out.println ("===================");
        ll.print();

    }
}
