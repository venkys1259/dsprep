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
    /* Recursive way of Reversing a linked list*/
    public ListNode reverseList2(ListNode currentNode) {
        if(currentNode == null || currentNode.next == null)
            return currentNode;
        ListNode temp = reverseList2 (currentNode.next);
        currentNode.next.next = currentNode;
        currentNode.next = null;
        return temp;
    }

    public void print(ListNode node){
        while(node!=null) {
            System.out.println (node);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode (3);
        head.next.next.next = new ListNode (4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedList rll = new ReverseLinkedList ();
        ListNode reversed =  rll.reverseList(head);
        rll.print(reversed);
        System.out.println ("==========Recursive way==============");
        head = new ListNode(5);
        head.next = new ListNode(6);
        head.next.next = new ListNode (7);
        head.next.next.next = new ListNode (8);
        head.next.next.next.next = new ListNode(9);
        ListNode reversed2 =  rll.reverseList2(head);
        rll.print(reversed2);
    }
}
