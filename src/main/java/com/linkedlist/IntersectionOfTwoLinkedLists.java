package com.linkedlist;
/* https://leetcode.com/problems/intersection-of-two-linked-lists/*/

/*
Approach:
calculate sizes of both the lists
we need to traverse the higher length list up to ( |sizeOfList1-sizeOfList2).
Then start comparing list 1 and list2, if they point to same value.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int listASize = 0, listBSize = 0;
        ListNode temp = headA;
        while(temp!=null){
            temp = temp.next;
            listASize++;
        } // calculateFirstListSize
        temp = headB;
        while(temp!=null){
            temp = temp.next;
            listBSize++;
        }// calculateSecondListSize
        int counter = Math.abs(listASize-listBSize);
        // Traverse max Length list up to counter
        if(listASize > listBSize){
            while(counter!= 0){
                headA = headA.next;
                counter--;
            }
        }else if(listBSize > listASize){
            while(counter!= 0){
                headB = headB.next;
                counter--;
            }
        }
        while(headA!=null){
            if(headA == headB){
                return headA;
            }else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode headA = new ListNode (4);
        headA.next  = new ListNode (1);
        headA.next.next = new ListNode (8);
        headA.next.next.next = new ListNode (4);
        headA.next.next.next.next = new ListNode (5);

        ListNode headB = new ListNode (5);
        headB.next  = new ListNode (6);
        headB.next.next  = new ListNode (1);
        headB.next.next.next = new ListNode (8);
        headB.next.next.next.next = new ListNode (4);
        headB.next.next.next.next.next = new ListNode (5);

        IntersectionOfTwoLinkedLists intersection = new IntersectionOfTwoLinkedLists ();
        System.out.println (intersection.getIntersectionNode(headA,headB));


    }
}
