package com.arrays.practice;
/*
This class implements methods of deque such as frontInsert, frontRemove
RearInsert, RearRemove, isFull, IsEmpty,getRear,getFront
 */
public class DequeImplUsingCircularArray {
    int[] a;
    int front = -1, rear = -1;
    int n;
    public DequeImplUsingCircularArray(){
        a = new int[5];
        n = a.length;
    }
    // Insert the element from rear
    private void rearInsert(int data){
       if(isFull())
           System.out.println ("queue is full, cant insert");
       else if (isEmpty ()){
           front = rear = 0;
       }
       else{
           rear = (rear+1)%n; // instead of rear++, we do %n  for circular functionality
       }
       a[rear] = data;
    }

    // Remove the element from front
    private void frontRemove(){
        if (isEmpty ()){
            System.out.println ("Cant remove from empty queue");
        }
        else{
            front = (front+1)%n; // instead of rear++, we do %n  for circular functionality
        }
    }

    // Insert the element from front
    private void frontInsert(int data){
        if(isFull())
            System.out.println ("queue is full, cant insert");
        else if (isEmpty ()){
            front = rear = 0;
        }
        else{
            // in case of rear insert we just increment rear
            // but if we just increment rear, that will not make frontInsert
            // so we decrement rear but add length of array to avoid negative index
            front = (front-1+n)%n;
        }
        a[front] = data;
    }

    // Remove the element from rear
    private void rearRemove(){
        if (isEmpty ()){
            System.out.println ("Cant remove from empty queue");
        }
        else{
            rear = (rear-1+n)%n; // instead of rear++, we do %n  for circular functionality
        }
    }

   // Print the elements from queue
    private void display(){
     int i = front;
     while(i!=rear){
         System.out.println (a[i]);
         i = (i+1)%n;
     }
     System.out.println (a[rear]);
    }
    // Check if queue is full
    private boolean isFull(){
        return ((rear+1)% n) == front;
    }
    // Check if queue is empty
    private boolean isEmpty(){
        return (rear == -1 && front == -1);
    }


    public static void main(String[] args) {
        DequeImplUsingCircularArray deque = new DequeImplUsingCircularArray();
        deque.rearInsert(5);
        deque.rearInsert(6);
        deque.rearInsert(7);
        deque.display ();
        deque.rearRemove ();
        deque.frontInsert (9);
        deque.frontInsert (10);
        deque.display ();
        deque.frontRemove ();
        deque.display ();
    }
}
