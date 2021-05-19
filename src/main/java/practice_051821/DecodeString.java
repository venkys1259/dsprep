package practice_051821;

/*
https://leetcode.com/problems/decode-string/
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 */

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        char[] chars = s.toCharArray ();
        Stack<String> characterStack = new Stack<> ();
        String temp = "",appendedStr ="",decodedStr="";
        characterStack.push(chars[0]+"");
        for(int i = 1; i<chars.length;i++){
            if(chars[i] != ']'){
                characterStack.push(chars[i]+"");
            }else{
                while(!characterStack.isEmpty()&&!characterStack.peek().equals ("[")){
                    temp = characterStack.pop() + temp;
                }
                characterStack.pop();
                int repeat = Integer.parseInt(characterStack.pop());
                for(int j=0; j<repeat;j++){
                    appendedStr = appendedStr +  temp;
                }
                characterStack.push(appendedStr);
                temp = "";
                appendedStr = "";

             }
        }
        while(!characterStack.isEmpty ()){
            decodedStr = characterStack.pop()+decodedStr;
        }
       return  decodedStr;
    }

    public static void main(String[] args) {
        DecodeString decode = new DecodeString();
        String decodedStr = decode.decodeString ("3[a2[c]]");
        System.out.println (decodedStr);
    }
}
