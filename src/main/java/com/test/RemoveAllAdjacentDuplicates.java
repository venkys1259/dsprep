package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class RemoveAllAdjacentDuplicates {
    public String removeDuplicates(String s) {
        List<Character> characterList = new ArrayList<> ();
        for(Character ch: s.toCharArray ()){
            if(!characterList.isEmpty () && characterList.get(characterList.size ()-1) == ch){
                characterList.remove (characterList.size ()-1);
            }else{
                characterList.add (ch);
            }
        }
       String result = "";
        for(Character letter:characterList){
            result =result + letter;
        }
      return  result;
    }

    public String removeDuplicatesUsingStack(String s) {
        Stack<Character> stack = new Stack<> ();
        char[] chars = s.toCharArray ();
        for(int i = chars.length-1; i>=0;i--){
            if(!stack.isEmpty () && stack.peek () == chars[i]){
                stack.pop();
            }else{
                stack.push (chars[i]);
            }
        }
        String result = "";
        while (!stack.isEmpty ()){
            result = result + stack.pop();
        }
        return  result;
    }
    public static void main(String[] args) {
        RemoveAllAdjacentDuplicates removeAllAdjacentDuplicates = new RemoveAllAdjacentDuplicates ();
        System.out.println (removeAllAdjacentDuplicates.removeDuplicates ("azxxzy"));
        System.out.println (removeAllAdjacentDuplicates.removeDuplicatesUsingStack ("azxxzy"));
    }
}
