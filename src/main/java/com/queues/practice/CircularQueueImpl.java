package com.queues.practice;

public class CircularQueueImpl {
    int front,rear;
    int[] data;
    public CircularQueueImpl(int capacity){
        data = new int[capacity];
        front = rear = -1;
    }
    private boolean isEmpty(){
        return (front == -1 && rear == -1);
    }
    private boolean isFull(){
        return (rear+1)%data.length == front;
    }
    private boolean enQueue(int x){
        if(isFull()){
            System.out.println ("Queue is full,cant insert");
            return false;
        }else if(isEmpty ()){
            front = 0;
            rear = 0;
            data[rear] = x;
        }else{
            rear = (rear+1)%data.length; // we do this instead of rear = rear+1,
                                        // once we reach end of the array,can try to insert from 0 if any space is available
            data[rear] = x;
        }
        return true;
    }
    private boolean deQueue(){
        if(isEmpty()){
            System.out.println ("Queue is Empty. cant remove anything");
            return false;
        }
        else if(front == rear){ // Array has only one element, so when we dequeue, marking queue as empty
            rear = -1;
            front = -1;
        }else{
            front = (front+1)%data.length; // instead of front = front+1
        }
        return true;
    }

    private void display(){
        System.out.println ("Elements in Queue::");
        if(front== 0 && rear == 0){// queue has only 1 element
            System.out.println ();
        }
        else if(rear > front) { // still circular concept is not fulfilled
            for (int i = front; i < rear; i++) {
                System.out.println (data[i]);
            }
        }
        else{ // we utilized some of the deleted elements place in array
            for(int i = 0; i<=rear;i++){
                System.out.println (data[i]);
            }
            for (int i = front; i < data.length; i++) {
                System.out.println (data[i]);
            }
        }
    }

    public static void main(String[] args) {
        CircularQueueImpl queue = new CircularQueueImpl(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.display ();
        queue.deQueue ();
        queue.display ();
        queue.enQueue(4);
        queue.display ();
    }
}
