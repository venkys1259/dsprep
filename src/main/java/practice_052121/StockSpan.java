package practice_052121;

import java.util.Stack;

/*
We are given list price of a stock for N days, find the stock span of each day. Stock spam is defined as the consecutive number of days where the stock price was less or equal to the given day stock price.
For ex. for P = {11, 9, 7, 5, 4, 6, 8, 10, 7, 9} the span is S = {1, 1, 1, 1, 1, 3, 5, 7, 1, 2}
*/
public class StockSpan {

    /*Tried with 2 stacks but it did not work as expected*/
    private int[] calculateSpan(int[] arr){
        int[] spans = new int[arr.length];
        spans[0] = 1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2= new Stack<>();
        // push the elements into stack if a[i] < a[i-1] and record 1 for the day as span.
        // if a[i] > a[i-1] --> pop the elements of the stack until peek is greater than a[i]
        // and push the popped element into second stack.
        // push current element into stack,
        //record the span as second stack size +1
        stack1.push(arr[0]);
        for(int i = 1; i<arr.length;i++){
            if(arr[i] < arr[i-1]){
                stack1.push(arr[i]);
                spans[i] = 1;
            }else{
                while(stack1.peek() < arr[i]){
                    stack2.push(stack1.pop());
                }
                stack1.push(arr[i]);
                spans[i] = stack2.size()+1;
            }
        }
        return spans;
    }

/*
O(N) approach:
we need to maintain the stack indexes in the descending order of stock prices.
if the ith element is grater than the top element of the stack, pop it until we reach grater element index in stack
if the stack is empty, span will be ith +1 otherwise i-top of the stack.
 */

    private int[] calcSpan(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[arr.length];
        span[0] = 1;
        stack.push(0); // Push first element index into stack.
        for(int i = 1; i<arr.length;i++){
            while(!stack.isEmpty() && arr[i]>=arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){ // All the elements are lesser than given day price.
                span[i] = i+1;
            }else {
                span[i] = i - stack.peek ();
            }
            stack.push(i);
        }
        return span;
    }


    public static void main(String[] args) {
    int[] prices ={11, 9, 7, 5, 4, 6, 8, 10, 7, 9};
    int[] span = new StockSpan().calcSpan(prices);
    for(int i = 0; i<span.length;i++){
        System.out.print(span[i]);
    }
    }
}
