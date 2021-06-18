package com.queues.practice;

import java.util.Deque;
import java.util.LinkedList;

/*
https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/
Given an array of both positive and negative integers, the task is to compute sum of minimum and maximum elements of all sub-array of size k.
Examples:

Input : arr[] = {2, 5, -1, 7, -3, -1, -2}
        K = 4
Output : 18
Explanation : Subarrays of size 4 are :
     {2, 5, -1, 7},   min + max = -1 + 7 = 6
     {5, -1, 7, -3},  min + max = -3 + 7 = 4
     {-1, 7, -3, -1}, min + max = -3 + 7 = 4
     {7, -3, -1, -2}, min + max = -3 + 7 = 4
     Sum of all min & max = 6 + 4 + 4 + 4
                          = 18

 */
public class SumOfMinAndMaxOfSubArray {

    /*
    Approach: We have to use SlidingWindow Mechanism
    1) Need to construct array of Max Elements using Sliding window Algorithm
    2) Need to construct array of Min Elements using Sliding window Algorithm
    3) Add the sum of 2 arrays
    Process for constructing max elements using sliding window:
    1) Populate a deque with K elements. while inserting elements, if it
    encounters smaller element queue, remove it from queue.
    2) Iterate from k to till end of the queue
      a) print peek element from queue.
      a) if the ith element is out of the range i.e.index of i is grater than
      index of ( first element of queue +k), remove all the first elements which satisifies this
      b)remove all elements smaller than arr[i] in the current window
      c) add ith element to queue.
     */
    private  int SumOfKsubArray(int arr[] , int k){
        /* I have done using 2 separate calls just for my understanding, maxSum and minSum can be
           done in single method, by taking 2 deque
         */
        int maxSum = sumOfMaxElementsInSubArray (arr,k);
        int minSum = sumOfMinElementsInSubArray (arr,k);
        return (maxSum+minSum);
    }
    // method to compute sum of max elements in sub array of size k
    private int sumOfMaxElementsInSubArray(int arr[], int k){
        Deque<Integer> deque = new LinkedList<>();
        int sum = 0;
        // Step 1: Populate a deque with K elements. while inserting elements, if it
        //    encounters smaller element queue, remove it from queue.
        for(int i = 0; i<k; i++){
            while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // Step 2: Iterate from k to till end of the queue
        for(int i = k; i<arr.length; i++){
            // Print the max element found for the current window
            System.out.println("Max: "+arr[deque.peek()]);
            sum = sum + deque.peek();
            // Check if ith element fits in range
            while(!deque.isEmpty() && deque.peek() <= (i-k)){
                deque.removeFirst();
            }
            // Remove all smaller elements than arr[i]
            while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]){
                deque.removeLast ();
            }
            deque.addLast(i);
        }
        sum = sum + arr[deque.peek()];// Element from Last Window
        System.out.println("Last Max: "+arr[deque.peek()]);
        return sum;
    }

    // method to compute sum of min elements in sub array of size k
    private int sumOfMinElementsInSubArray(int arr[], int k){
        Deque<Integer> deque = new LinkedList<>();
        int sum = 0;
        // Step 1: Populate a deque with K elements. while inserting elements, if it
        //    encounters grater element queue, remove it from queue.
        for(int i = 0; i<k; i++){
            while(!deque.isEmpty() && arr[i] <= deque.peekLast()){
                deque.removeLast();
            }
            deque.addLast (i);
        }
        // Step 2: Iterate from k to till end of the queue
        for(int i = k; i<arr.length; i++) {
            // Print the Min element found for the current window
            System.out.println ("Min: " + arr[deque.peek ()]);
            sum = sum + deque.peek ();
            // Check if ith element fits in range
            while(!deque.isEmpty() && deque.peek() <= (i-k)){
                deque.removeFirst();
            }
            //  Remove all bigger elements than arr[i]
            while(!deque.isEmpty() && arr[i] <= arr[deque.peekLast()]){
                deque.removeLast ();
            }
            deque.addLast (i);
        }
        sum = sum + arr[deque.peek()];// Element from Last Window
        System.out.println("Last Min: "+arr[deque.peek()]);
        return sum;
    }

    public static void main(String[] args) {
        SumOfMinAndMaxOfSubArray sumofArray = new SumOfMinAndMaxOfSubArray();
        int a[] = {2, 5, -1, 7, -3, -1, -2};
        System.out.println ("Sum:::"+sumofArray.SumOfKsubArray (a,3));
    }
}
