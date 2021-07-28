package com.linkedlist;


class ListNode{
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int val){
      this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
public class ReverseLinkedList {
    /* Iterative way of Reversing a linked list */
    public ListNode reverseList(ListNode currentNode) {
        ListNode prev = null, next;
        while(currentNode!=null){
            next = currentNode.next;
            currentNode.next = prev;
            prev=currentNode;
            currentNode = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode (3);
        head.next.next.next = new ListNode (4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedList rll = new ReverseLinkedList ();
        ListNode reversed =  rll.reverseList(head);
        System.out.println (reversed);
    }
}
