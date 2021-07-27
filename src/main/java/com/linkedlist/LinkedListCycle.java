package com.linkedlist;
/*
https://leetcode.com/problems/linked-list-cycle/
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
       ListNode hare = head;
       ListNode tortoise = head;
       if(head == null || head.next == null){
           return false;
       }
       while(tortoise!=null && hare!=null && hare.next!=null){
           tortoise = tortoise.next;
           hare = hare.next.next;
           if(tortoise == hare){
               return true;
           }
       }
       return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode (3);
        head.next = new ListNode (2);
        head.next.next = new ListNode (0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        LinkedListCycle lc = new LinkedListCycle ();
        System.out.println (lc.hasCycle (head));
    }
}
