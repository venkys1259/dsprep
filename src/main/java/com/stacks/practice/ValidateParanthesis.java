package com.stacks.practice;

import java.util.*;

/*
https://leetcode.com/problems/valid-parentheses/
 */
public class ValidateParanthesis {
    public boolean isValid(String s) {
        HashMap<Character,Character> charMap = new HashMap<> ();
        charMap.put('(',')');
        charMap.put('[',']');
        charMap.put('{','}');
        Set<Character> charsSet = charMap.keySet ();
        Stack<Character> charStack = new Stack<>();
        char[] chars = s.toCharArray ();
        for(Character ch:chars){
            if(charsSet.contains (ch)){
                charStack.push(ch);
            }else{
                if(charStack.isEmpty () ){
                    return false;
                }else {
                    if (charMap.get (charStack.pop ()) != ch) {
                        return false;
                    }
                }
            }
        }
        if(!charStack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        ValidateParanthesis valPar = new ValidateParanthesis();
        System.out.println (valPar.isValid ("()"));
    }

}
