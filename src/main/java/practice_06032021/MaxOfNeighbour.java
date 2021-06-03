package practice_06032021;
/*
https://leetcode.com/problems/find-peak-element/submissions/
A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6

 */

public class MaxOfNeighbour {
    public int findPeakElement(int[] a) {
        int low = 0,high = a.length-1;
        if(a.length == 1) return 0; // if there is single element
        if(a.length == 2){ //2 elements
            if(a[0] > a[1]){
                return 0;
            }else{
                return 1;
            }
        }
        while(low<high){
            int  mid = low+((high-low)/2);
            if(mid == 0) return 0;
            if((a[mid] > a[mid+1]) && ( a[mid] > a[mid-1])) // if the middle element value is more than neighbour
                return mid;
            if(a[mid] > a[mid+1]){
                high = mid;

            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        MaxOfNeighbour max = new MaxOfNeighbour();
        int[] a = {1,2,3,1};
        System.out.println ("Max Element Index is :"+max.findPeakElement(a));
    }
}
