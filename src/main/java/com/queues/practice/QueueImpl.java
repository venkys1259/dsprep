package com.queues.practice;
/*
This class is for demonstrating basic queue operations
 */
public class QueueImpl {
    int front ,rear, capacity;
    int[] data;
    QueueImpl(int capacity){
        data = new int[capacity];
        this.capacity = capacity;
        front = rear = -1;
    }
    private boolean enQueue(int element){
        if(isFull()) {
            return false;
        }
       else if(isEmpty()){
            front = 0;
            rear = 0;
            data[rear] = element;
        }else {
            rear++;
            data[rear] = element;
        }
        return true;
        }
    private boolean deQueue(){
        if(isEmpty()){
            System.out.println ("queue is empty");
            return false;
        }
        else if(front == rear){ // Array has only one element, so when we dequeue, marking queue as empty
            rear = -1;
            front = -1;
        }
        else{
         front++; // Just advance front pointer, then we read the queue only we read from front to rear
        }
        return true;
    }
    private boolean isFull(){
      System.out.println ("Queue is full, cant insert");
      return  rear == capacity-1;
    }
    private boolean isEmpty(){
        return (front == -1 && rear == -1);
    }

    private void display(){
        for(int i=front; i<=rear;i++){
            System.out.println ("Elements in queue are:"+data[i]);
        }
    }


    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl(5);
        queue.enQueue (5);
        queue.enQueue (6);
        queue.enQueue (7);
        queue.enQueue (8);
        queue.enQueue (9);
        queue.enQueue (10);
        queue.display ();
        queue.deQueue ();
        queue.display ();
        queue.deQueue ();
        queue.display ();
    }
}
