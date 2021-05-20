package practice_051921;

import java.util.Stack;

/*
https://leetcode.com/problems/basic-calculator/
Given a string s representing an expression, implement a basic calculator to evaluate it.
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
Input: s = "1 + 1"
Output: 2
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
Constraints:
1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
 */
public class BasicCalculator {
  private int calculate(String s){
      Stack<String> expStack = new Stack<>();
      Stack<String> subExpStack = new Stack<>();
      String[] expression = s.trim().split("\\)");
      String tempVal = "";
      for(int i = 0; i<expression.length;i++){
           String[] split = expression[i].trim().split ("\\(");
          for(String str:split){
              if(!str.equals ("")) {
                  subExpStack.push (str);
              }
          }
         tempVal = String.valueOf(calc(subExpStack));
           while(!expStack.isEmpty()){
              expStack.pop ();
              expStack.push(tempVal);
          }
      }
      return 0;
  }

    private String calc(Stack<String> inputStack){
        int calculated = 0;String operator = "";
        int op1 = 0, op2 = 0;
        while(inputStack.size ()!=1){
          op1 = Integer.parseInt(inputStack.pop());
          operator = inputStack.pop();
          op2 = Integer.parseInt (inputStack.pop());
          if(operator.equals("+")){
                calculated = op2+op1;
            }
           if(operator.equals("-")){
                calculated = op2-op1;
            }
          inputStack.push(String.valueOf (calculated));
           }
        return inputStack.pop() ;
    }

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        int calculated = calculator.calculate ("(1+(4+5+2)-3)+(6+8)");
       // System.out.println (calculated);

    }
}
