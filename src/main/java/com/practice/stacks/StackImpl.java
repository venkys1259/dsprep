package com.practice.stacks;

public class StackImpl {
   static int top = -1;
    static int a[] = new int[5];
    private static  void  push(int data){
        if(top!=-1 && top == a.length-1){
          int  b[] = new int[a.length+5];
            for(int i = 0; i<a.length;i++){
                b[i] = a[i];
            }
            a = b;
        }
        top++;
        a[top] = data;
    }

    private static int pop(){
      int temp =  a[top];
      top--;
      System.out.println("Removing element "+temp +" From Stack");
      return  temp;
    }
    private static int peek(){
        System.out.println("Peek in Stack :"+a[top]);
        return  a[top];
    }
    private static void display(){
        System.out.println("Elements in Stack are:");
        for(int i = top; i>=0;i--){
           System.out.println (a[i]);
       }
    }


    public static void main(String[] args) {
        StackImpl.push(5);
        StackImpl.push(6);
        StackImpl.push(7);
        StackImpl.display ();
        StackImpl.peek ();
        StackImpl.pop();
        StackImpl.display ();
    }
}
