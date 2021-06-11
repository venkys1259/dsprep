package com.queues.practice;
/*
This class is for demonstrating basic queue operations
 */
public class QueueImpl {
    int front  = 0,rear = 0, capacity;
    int[] data;
    QueueImpl(int capacity){
        data = new int[capacity];
        this.capacity = capacity;
    }
    private boolean enQueue(int element){
        if(!isFull()){
        data[rear] = element;
        rear++;
        return true;
        }
        return false;
    }
    private boolean deQueue(){
        if(rear == front){
            System.out.println ("queue is empty");
            return false;
        }else{
            for(int i = front; i<rear-1;i++){
                data[i] = data[i+1];
            }
            rear--;
           // front++;
        }
        return true;
    }
    private boolean isFull(){
      return  capacity == rear;
    }
    private void display(){
        for(int i=front; i<rear;i++){
            System.out.println (data[i]);
        }
    }


    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl(5);
        queue.enQueue (5);
        queue.enQueue (6);
        queue.enQueue (7);
        queue.display ();
        queue.deQueue ();
        queue.display ();
        queue.deQueue ();
        queue.display ();

    }
}
