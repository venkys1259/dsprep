package com.queues.practice;
/*
Double Ended Queue Implementation
 */
public class DequeImpl {
    int front,rear,size;
    int[] data;
    public DequeImpl(int size){
        front = -1; // why?
        rear = 0; // why?
        this.size = size;
        data = new int[size];
    }
    // insert element at last
    private void offerLast(int x){
        if(!isFull()){
            if(isEmpty()){ // initially queue is empty
                front = 0;
                rear = 0;
            }else{
                rear = rear+1;
            }
            data[rear] = x;
        }
    }
    // insert element at first
    private void offerFirst(int x){
        if(!isFull()){
            if(isEmpty()){ // initially queue is empty
                front = 0;
                rear = 0;
            }
            else if(front == 0){ // if front is in first position
                front = size-1;
            }
            else{
                front = front-1;
            }
            data[front] = x;
        }
    }
    // remove element at First
    private void pollFirst(){
        if(!isEmpty()){
            if(front == rear){ // if deque has single element
              front = -1;
              rear = -1;
            }else{
                if(front == size-1){
                    front = 0;
                }else{
                    front = front+1;
                }
            }
        }
    }

    //print all the elements from deque
    private void display(){
        if(front== 0 && rear == 0){// queue has only 1 element
            System.out.println (data[0]);
        }
        else if(rear > front) { // still circular concept is not fulfilled
            for (int i = front; i <= rear; i++) {
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
    private boolean isFull(){
        if ((rear == size-1 && front == 0) || front == rear+1) {
            return true;
        }
        return false;
    }

    private boolean isEmpty(){
      return  (rear == 0 && front == -1);
    }

    public static void main(String[] args) {
        DequeImpl deque = new DequeImpl(5);
        deque.offerFirst (5);
        deque.offerLast (10);
        deque.offerLast (20);
        deque.offerFirst (30);
        deque.offerLast (40);
        deque.pollFirst();
        deque.display ();
    }
}
