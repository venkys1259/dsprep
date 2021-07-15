package com.sorting.practice;

import java.util.*;

/*
https://leetcode.com/problems/find-median-from-data-stream/

Approach: we need to use 2 heaps, maxHeap and minHeap

 */
public class MedianFinder {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    int size = 0;
    public MedianFinder() {
       this.minHeap = new PriorityQueue<>();
       this.maxHeap = new PriorityQueue<> (Comparator.reverseOrder ()); // java does not have maxHeap by default,
                                                                       // so need to reverse the minHeap
    }
    public void addNum(int num) {
      if(maxHeap.size() == minHeap.size () || maxHeap.size()+1 < minHeap.size()){
          // have to push the element to maxHeap, to do this push the element to minHeap and
          // Pop the root of minHeap and then add it to maxHeap - that way it balance.
          minHeap.add (num);
          int poppedFromMinHeap = minHeap.poll();
          maxHeap.add(poppedFromMinHeap);
      }
      else if(maxHeap.size()+1 > minHeap.size ()){
          // have to push the element to minHeap, to do this push the element to maxHeap and
          // Pop the root of maxHeap and then add it to minHeap
          maxHeap.add(num);
          int poppedFromMaxHeap = maxHeap.poll ();
          minHeap.add(poppedFromMaxHeap);
      }
      size++;
    }

    public double findMedian() {
        // if the size of the number of elements is odd, then median will be just peek of maxHeap
        if(size %2 != 0){
            return (double) maxHeap.peek();
        }
        // if the size of the number of elements is even, then median will be just peek of maxHeap
        else{
            return (maxHeap.peek () + minHeap.peek ())/2.0;
        }
    }
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println ("Median is :"+medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println ("Median is:"+medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println ("Median is"+medianFinder.findMedian());
    }
}
