package practice_051721;

/*
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 */
import java.util.Stack;


public class MinimumRemoveValidParanthesis {
        public String minRemoveToMakeValid(String s) {
            char[] ch = s.toCharArray();
            String output = "";
            char stop;
            Stack<Integer> pstack = new Stack<> ();
            for(int i = 0; i<ch.length;i++){
                if(ch[i] == '(' || ch[i] == ')'){
                    if(pstack.isEmpty()){
                        pstack.push(i);
                    } else{
                        stop = ch[pstack.peek()];
                        if(stop == '(' && ch[i] == ')' ||
                                (stop == ')' && ch[i] == '(')) {
                            pstack.pop();
                        }else{
                            pstack.push(i);
                        }
                    }
                }
            }
            System.out.println("stack size" +pstack.size());
            for(int i = 0; i<ch.length;i++){
                if(!pstack.isEmpty() && i == pstack.peek()){
                    pstack.pop();
                }else{
                    output = output+ch[i];
                }
            }
            return output;
        }

    public static void main(String[] args) {
        MinimumRemoveValidParanthesis minimumRemoveValidParanthesis = new MinimumRemoveValidParanthesis ();
       String validStr =  minimumRemoveValidParanthesis.minRemoveToMakeValid ("lee(t(c)o)de)");
        System.out.println (validStr);
    }

}
