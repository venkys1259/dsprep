package practice_051721;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a string A denoting an expression. It contains the following operators ’+’, ‘-‘, ‘*’, ‘/’.

Chech whether A has redundant braces or not.

Return 1 if A has redundant braces, else return 0.

Note: A will be always a valid expression.
Input 1:
    A = "((a + b))"
Output 1:
    1
    Explanation 1:
        ((a + b)) has redundant braces so answer will be 1.
 */
public class RedundantBraces {
    public static void main(String[] args) {
        String input = "(a + (a + b))";
        char[] chars = input.toCharArray ();
        List<Character> operatorsList = new ArrayList<> ();
        operatorsList.add ('+');
        operatorsList.add ('-');
        operatorsList.add ('*');
        operatorsList.add ('/');
        Stack<Character> istack = new Stack<> ();
        char ch;
        for (int i = 0; i < chars.length; i++) {
            boolean flag = false;
            char ch1 = chars[i];
            if (ch1 == ')') {
                while (!istack.isEmpty () && istack.peek () != '(') {
                    ch = istack.pop ();
                    if (operatorsList.contains (ch)) flag = true;
                }
                istack.pop ();
                if (!flag) {
                    System.out.println ("its redundant paranthesis");
                    System.exit (0);
                }
            } else {
                istack.push (chars[i]);
            }

        }
        System.out.println ("its not redundant paranthesis");
    }
}




