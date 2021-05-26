package practice_05252021;
/*
https://leetcode.com/problems/rotate-array/
Given an array, rotate the array to the right by k steps, where k is non-negative.
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArray {
    /*
    Approach: rightRotateBy 1 element and call n number of times.
     */
    private void rotate(int[] nums, int k) {
     for(int i = 1; i<=k;i++){
         rightRotateBy1(nums);
     }
    }
    private void rightRotateBy1(int[] a){
        int last = a[a.length-1];
        for(int i = a.length-1; i>0;i--){
            a[i] = a[i-1];
        }
        a[0]=last;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        RotateArray rotate = new RotateArray();
        rotate.rotate (a,3);
        for(Integer num:a) {
            System.out.println (num);
        }

    }
}
