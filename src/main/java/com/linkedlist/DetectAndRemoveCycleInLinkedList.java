package com.linkedlist;
/*
https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 */
public class DetectAndRemoveCycleInLinkedList {
    /*
    1. Find if the loop exists
    2. if loop exists,count the number of nodes in the loop and say k is the counter
    3. start one pointer from head and other pointer from k
    4. advance each pointer by 1 and check if they are meeting at same point, which would be the starting point
       of the cycle
    5. from the starting point of the cycle, advance one pointer till its next is starting point
    6. once the other pointers next is starting point, simply disconnect the link by assigning its next to null.

     */

    private int detectAndRemoveLoop(ListNode node){
       ListNode loopNode =  detectLoop(node);
       if(loopNode!=null){
         removeLoop(loopNode, node);
         return 1;
       }
        return 0;
    }

    private void removeLoop(ListNode loopNode, ListNode head) {
        ListNode pointer1 = loopNode;
        ListNode pointer2 = loopNode;
        // count the number of nodes in loop
        int k = 1;
        while(pointer2.next != pointer1){
            pointer2 = pointer2.next;
            k++;
        }
        // fix one pointer to head
        pointer1 = head;
        // other pointer to k nodes after head
        pointer2 = head;
        for(int i = 0; i<k;i++){
            pointer2 = pointer2.next;
        }
        // Move both pointers at the same pace,they will meet at loop starting node
        while(pointer1!=pointer2){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        // move pointer2 till its next points to starting node of the loop which is pointer 1 now
         while(pointer2.next != pointer1){
             pointer2 = pointer2.next;
         }
        pointer2.next = null;
    }

    private ListNode detectLoop(ListNode head) {
        ListNode hare = head,tortoise = head;
        while(tortoise!=null & hare!=null && hare.next!=null){
            tortoise = tortoise.next;
            hare  = hare.next.next;
            if(tortoise == hare){
                return tortoise;
            }
        }
        return null;
    }
    private void print(ListNode node){
        while(node!=null){
            System.out.println (node.val);
            node = node.next;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode (1);
        head.next = new ListNode (2);
        head.next.next = new ListNode (3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next;
        DetectAndRemoveCycleInLinkedList detectNRemove = new DetectAndRemoveCycleInLinkedList ();
        detectNRemove.detectAndRemoveLoop (head);
        detectNRemove.print(head);

    }
}
