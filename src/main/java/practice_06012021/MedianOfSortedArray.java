package practice_06012021;

import java.util.Arrays;

/*
https://leetcode.com/problems/median-of-two-sorted-arrays/
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
 */
public class MedianOfSortedArray {
    /*
    Approach: merge the arrays with the following procedure.
    a)iterate the first array and compare corresponding ith element, whichever is lower push it to new array
    b)if first array has more elements left, just push the remaining to the end of new array
    in same way if second array has more elements left,  just push the remaining of second array elements
    to the end of new array
   c) if the number of elements in merged array is odd, median will be merged(n-1)/2
   d) if its even (merged(n/2)+merged(n/2-1))/2
     */
    private Double median(int[] a, int[] b){
        int  i1 = 0, i2= 0, length1 = a.length,length2=b.length,j=0;
        int[] merged = new int[a.length+b.length];
        while(i1<length1 && i2<length2){ // iterate through both the arrays
            if(a[i1] <= b[i2]){ // if first element of first array is less than first element of second array, push that element to merge array
                merged[j] = a[i1];
                i1++;
            }else{
                merged[j] = b[i2];
                i2++;
            }
            j++;
        }
        while(i1<length1){ // if first array has more elements left, just push them to merge array
            merged[j] = a[i1];
            i1++;
            j++;
        }
        while(i2<length2){ // if second array has more elements left, just push them to merge array
            merged[j] = b[i2];
            i2++;
            j++;
        }
        System.out.println ("Merged -->"+Arrays.toString(merged));
        int mergedArraySize = merged.length;
        if(mergedArraySize%2!=0){ // odd number of elements in  merged array
          return  (double)(merged[(mergedArraySize-1)/2]);
        }else{ //even  number of elements in  merged array
           return (double)(merged[mergedArraySize/2] + merged[mergedArraySize/2-1])/2;
        }
    }

    public static void main(String[] args) {
        MedianOfSortedArray med = new MedianOfSortedArray();
        int[] a = {1,2}, b = {3,4};
        System.out.println (med.median (a,b));
    }
}
