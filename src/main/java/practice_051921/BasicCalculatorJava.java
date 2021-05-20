package practice_051921;

import java.util.Stack;

public class BasicCalculatorJava {

    private int calculate(String expr){
       Stack<Integer> stack = new Stack<>();
       int number = 0,sign = 1,result = 0;
        for(Character c: expr.toCharArray()){
           if(c == '('){
               stack.push(result);
               stack.push(sign);
               result = 0;
               sign = 1;
           }
           else if(c == ')'){
               result = result+(sign*number);
               number = 0;
               result = result*stack.pop();
               result =  result+stack.pop();
           }
           else if(Character.isDigit(c)){
               number = number*10 + Integer.parseInt (c+"");
           }
           else if(c == '+'){
               result = result+(sign*number);
               number = 0;
               sign = 1;
           }
           else if(c == '-'){
               result = result+(sign*number);
               number = 0;
               sign = -1;
           }
        }
        result= result+(number*sign);

        return result;
    }


    public static void main(String[] args) {
        BasicCalculatorJava javaCalculator = new BasicCalculatorJava();
        int calculatedValue = javaCalculator.calculate ("(1+(4+5+2)-3)+(6+8)");
        System.out.println (calculatedValue);

    }
}
