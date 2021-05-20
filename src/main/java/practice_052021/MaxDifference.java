package practice_052021;

import java.util.Arrays;
import java.util.Stack;

/*
https://www.geeksforgeeks.org/find-maximum-difference-between-nearest-left-and-right-smaller-elements/
Find maximum difference between nearest left and right smaller elements
Given an array of integers, the task is to find the maximum absolute difference between the nearest left and the right smaller element of every element in the array.
Note: If there is no smaller element on right side or left side of any element then we take zero as the smaller element. For example for the leftmost element, the nearest smaller element on the left side is considered as 0. Similarly, for rightmost elements, the smaller element on the right side is considered as 0.
Examples:
 Input : arr[] = {2, 1, 8}
Output : 1
Left smaller  LS[] {0, 0, 1}
Right smaller RS[] {1, 0, 0}
Maximum Diff of abs(LS[i] - RS[i]) = 1

Input  : arr[] = {2, 4, 8, 7, 7, 9, 3}
Output : 4
Left smaller   LS[] = {0, 2, 4, 4, 4, 7, 2}
Right smaller  RS[] = {0, 3, 7, 3, 3, 3, 0}
Maximum Diff of abs(LS[i] - RS[i]) = 7 - 3 = 4

Input : arr[] = {5, 1, 9, 2, 5, 1, 7}
Output : 1
 */
public class MaxDifference {
    // brute force solution
    private int getMaxDiff(int[] arr){
        int[] ls = new int[arr.length];
        int[] rs = new int[arr.length];
        ls[0] = 0;
        int n , maximumDiff = 0;

        for(int i = 1; i<arr.length;i++){
            if(arr[i-1] < arr[i] ){
                ls[i] = arr[i-1];
            }else{
                n = i-2;
                while(n>=0){
                    if(arr[n] < arr[i]){
                        ls[i]= arr[n];
                        break;
                    }else{
                        n--;
                    }
                }
            }
        }
        n= 0;
        for(int i = 0; i<arr.length;i++){
            n = i+1;
            while(n<arr.length && arr[i] <= arr[n]){
                n++;
            }
            if(n<arr.length) {
                rs[i] = arr[n];
            }
        }
        rs[arr.length-1] = 0;
        int previousMaxDiff = 0;
        for(int i = 0; i<ls.length;i++){
            maximumDiff  = Math.abs (rs[i]-ls[i]);
            if(maximumDiff > previousMaxDiff ){
                previousMaxDiff = maximumDiff;
            }
        }
        return previousMaxDiff;
    }
    /*
    Optimized way using stack
    1.if the i-1 element in array is smaller,push current element into stack and i-1
      element into smallest array
    2. if the i-1 element is not smaller, then compare with element in the stack
        if stack has minimum element then consider that element as smaller one and
        put into smallest array
        otherwise iterate through the stack until we find the smaller element and put that element into
        smallest array and push smaller element to stack.

    */
    private int[] getSmallestElements(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] ls = new int[arr.length];
        ls[0] = 0;
        stack.push(arr[0]);
        for(int i = 1; i<arr.length;i++){
            if(arr[i-1] < arr[i]){
                stack.push(arr[i]);
                ls[i] = arr[i-1];
            }
            else{
               if(stack.peek()<arr[i-1]){
                   ls[i] = stack.peek();
               }
               else{
                   while(!stack.isEmpty() && stack.peek()>=arr[i]){
                       stack.pop();
                   }
                   ls[i] = !stack.isEmpty()?stack.peek():0;
                   stack.push(arr[i]);
               }
            }
        }
        return  ls;
    }
     private int getMaximumDifference(int[] arr){
         int previousMaxDiff = 0,maximumDiff=0;
        int[] ls = getSmallestElements(arr);
         int[] rs = getSmallestElements (getReversed(arr)); // Reverse the current and get the smallest order and then reverse
         rs = getReversed (rs);
         for(int i = 0; i<ls.length;i++){
             maximumDiff  = Math.abs (rs[i]-ls[i]);
             if(maximumDiff > previousMaxDiff ){
                 previousMaxDiff = maximumDiff;
             }
         }
        return previousMaxDiff;
     }

     private int[] getReversed(int[] arr){
         int[] reversed = new int[arr.length];
         for(int i = arr.length-1,j=0; i>=0;i--,j++){
             reversed[j] = arr[i];
         }
         return reversed;
     }
    public static void main(String[] args) {
        MaxDifference difference = new MaxDifference();
        int[] arr = {2, 4, 8, 7, 7, 9, 3};
        System.out.println (difference.getMaxDiff(arr));
        System.out.println (difference.getMaximumDifference (arr));
    }
}
