package com.queues.practice;

import java.util.*;

/*
https://leetcode.com/problems/find-the-most-competitive-subsequence/
Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.
An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.
We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first position where a and b differ, subsequence a has a number less than the corresponding number in b. For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.

Example 1:

Input: nums = [3,5,2,6], k = 2
Output: [2,6]
Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6] is the most competitive.
Example 2:

Input: nums = [2,4,3,3,5,4,9,6], k = 4
Output: [2,3,3,4]
 */
public class CompetitiveSubSequence {
    /*
    Approach: we are utilizing the concept of Deque - inserting/removing elements from both ends of queue.
    1. Push the first element of given array to deque and decrement K ( that tells how many elements left to form competitive sub sequence.
    2. Iterate the from second element to total array and perform the following:
    if the incoming ith element has less value than first element in queue
    remove the lesser element from  q and increment k
    else  insert the element to deque,provided k > 0
     */
    private int[] mostCompetitive(int[] nums, int k) {
    Deque<Integer> deque = new ArrayDeque<>();
    deque.addFirst(nums[0]);
    k--;
    for(int i = 1; i<nums.length;i++){
        // if the incoming element has lesser value, means that would be more competitive
        // so remove the element from queue and increment K.
       while(!deque.isEmpty () && (nums.length-i) > k && nums[i] < deque.peekLast()){
                   deque.pollLast();
                   k++;
               }
               if(k>0) { // what is the alternative?
                   deque.offerLast (nums[i]); // insert current element.
                   k--;
               }
    }
    int[] result = new int[deque.size()];
    int j = 0;
    Iterator<Integer> iterator = deque.iterator();
    while(iterator.hasNext()){
        result[j]=iterator.next();
        j++;
    }
    return result;
    }
    public static void main(String[] args) {
    CompetitiveSubSequence css = new CompetitiveSubSequence();
    int[] nums = {2,4,3,3,5,4,9,6};
    System.out.println(Arrays.toString(css.mostCompetitive(nums,4)));
    }
}
