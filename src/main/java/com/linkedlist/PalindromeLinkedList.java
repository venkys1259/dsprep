package com.linkedlist;
/*
https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    ListNode leftPtr;
    private boolean isPalindrome(ListNode head, ListNode right){
        leftPtr = head;
        if(right == null) {
            return true;
        }
       boolean isPal  = isPalindrome(head,right.next);
        if(!isPal){
            return false;
        } // if we dont include above if condition, the comparison of left pointer value and right pointer value happens
          //   for all the elements even though we discovered the given linked is not palindrome at early point.

           if (right.val != leftPtr.val) { // compare first and last, then next first next last etc
                isPal = false;
            }
           leftPtr = leftPtr.next;
        return isPal;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode (6);
        head.next = new ListNode (2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode (1);
        head.next.next.next.next = new ListNode (2);
        head.next.next.next.next.next = new ListNode (1);
        PalindromeLinkedList pll = new PalindromeLinkedList();
        System.out.println (pll.isPalindrome (head,head));
    }
}
