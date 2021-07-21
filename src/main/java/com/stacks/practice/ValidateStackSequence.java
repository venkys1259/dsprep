package com.stacks.practice;

import java.util.Stack;

/*
https://leetcode.com/problems/validate-stack-sequences/
 */
public class ValidateStackSequence {
    private boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> pushedStack = new Stack<>();
        int j = 0;
        for(int i = 0; i<pushed.length;i++){
            pushedStack.push (pushed[i]);
            while(!pushedStack.isEmpty() && pushedStack.peek () == popped[j]){
                pushedStack.pop();
                j++;
            }
        }
        return pushedStack.isEmpty();
    }

    public static void main(String[] args) {
     int[] pushed = {1,2,3,4,5}, popped = {4,3,5,1,2};
        ValidateStackSequence validateSS = new ValidateStackSequence ();
        System.out.println (validateSS.validateStackSequences (pushed,popped));
    }

}
