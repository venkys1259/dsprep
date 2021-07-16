package com.stacks.practice;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/next-greater-element/
Given an array, print the Next Greater Element (NGE) for every element.
The Next greater Element for an element x is the first greater element on the right side of x in the array.
Elements for which no greater element exist, consider the next greater element as -1.
input array [4, 5, 2, 25]
Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
 */
public class NextGreaterElement {
    private void printNGE(int[] a){
        Stack<Integer> stack = new Stack<> ();
        stack.push(a[0]);
        for(int i = 1; i<a.length;i++){
            while(!stack.isEmpty() && a[i] > stack.peek()){
                System.out.println (stack.pop () + "--->" +a[i]);
            }
            stack.push (a[i]);
        }
        while(!stack.isEmpty()){
            System.out.println (stack.pop () + "--->" + " -1 ");
        }

    }
    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int[] a = {4,5,2,25};
        nge.printNGE (a);
    }
}
