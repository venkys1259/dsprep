package com.arrays.practice;

import java.util.*;

/*
https://leetcode.com/problems/sliding-window-maximum/
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.
 Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]
Example 4:

Input: nums = [9,11], k = 2
Output: [11]
Example 5:

Input: nums = [4,-2], k = 2
Output: [4]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */
public class SlidingWindow {
/*
Approach: consider a deque to measure the data in form of range ( window).
1. Initialize sliding window wit K number of elements.
if the deque has smaller element than incoming elements, smaller numbers less than incoming element
can be removed from deque.
2. perform the following steps for "i" th element until the end of the array
1) Add the first element of deque to output
2) Check if the ith element fits in the range, otherwise remove the last element from deque
3) Remove all smaller elements than i
4) insert current element
5) if window has still elements, just add those elements to result.


 */
    private int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> maxNumbers = new ArrayList<>();
        // Initialize sliding window with K elements
        for(int i = 0; i<k;i++){
            // if deque has smaller element than incoming element, we can discard that
            // so that deque will have a maximum element for that window.
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        for(int i = k; i<nums.length;i++){
            // print the first element in the deque
            maxNumbers.add(nums[deque.peekFirst()]);
            // check if the incoming element fits in the range, if not remove the last element from deque
           if((i-k) > deque.peekFirst()){
               deque.pollLast();
           }
           //remove smaller elements
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            //Insert current Element
            deque.offerLast(i);
        }
        if(!deque.isEmpty()){ // if the sliding window has elements left, we need to consider them
            Iterator<Integer> iterator = deque.iterator ();
            while(iterator.hasNext()){
                maxNumbers.add(iterator.next());
            }
        }
        int[] windowMaxNumbers = new int[maxNumbers.size()];
        int j = 0;
        for(Integer num:maxNumbers){
            windowMaxNumbers[j] = num;
            j++;
        }
       return  windowMaxNumbers;
    }
    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        int[] a = {1,3,-1,-3,5,3,6,7};
    }
}
