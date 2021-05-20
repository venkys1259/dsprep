package practice_052021;

import java.util.Stack;

/*
https://www.interviewbit.com/problems/balanced-parantheses/
Given a string A consisting only of '(' and ')'.
You need to find whether parantheses in A is balanced or not ,if it is balanced then return 1 else return 0.
Input Format
First argument is an string A.
Output Format
Return 1 if parantheses in string are balanced else return 0.

 */
public class BalancedParantheses {
    private int isBalanced(String expr){
    Stack<Character>  stack = new Stack<>();
    char[] chars = expr.toCharArray ();
    stack.push(chars[0]);
    for(int i = 1; i<chars.length;i++){
        if(!stack.isEmpty() && stack.peek() == chars[i]){
            stack.push(chars[i]);
        }else{
            stack.pop();
        }
    }
   return (stack.size()==0)?1:0;
    }

    public static void main(String[] args) {
        BalancedParantheses balancedParantheses = new BalancedParantheses();
        int balanced = balancedParantheses.isBalanced ("(()())");
        System.out.println (balanced);
    }
}
