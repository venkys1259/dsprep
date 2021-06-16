package com.queues.practice;
/*
https://www.geeksforgeeks.org/queue-based-approach-for-first-non-repeating-character-in-a-stream/

Given a stream of characters and we have to find first non repeating character each time a character is inserted to the stream.

Examples:

Input  : a a b c
Output : a -1 b b

Input  : a a c
Output : a -1 c


*/

import java.util.*;

public class FirstNonRepeatingCharacter {
/*
Approach:
push the character to queue only if its not repeating.
once it repeats remove from front
but maintain a Hash Map to check if the particular character is repeated
 */
    private String[] firstNonRepeating(char[] chars){
       Map<String,Integer> charMap = new HashMap<>();
       Queue<Character> queue = new LinkedList<>();
       String[] result = new String[chars.length];
       int i = 0;
       for(Character ch: chars){
           if(charMap.containsKey(ch+"")){
               result[i] = "-1";
               queue.remove(); // character is repeated so,no more we can say it as non repeating
           }else{
               charMap.put(ch+"",0);
               queue.add(ch);
               result[i] = queue.peek()+"";
           }
           i++;
       }
        return result;
    }
    public static void main(String[] args) {
        FirstNonRepeatingCharacter nonRepeating = new FirstNonRepeatingCharacter();
        char[] ch = {'a','a','b','c'};
        System.out.println (Arrays.toString(nonRepeating.firstNonRepeating(ch)));
    }
}
