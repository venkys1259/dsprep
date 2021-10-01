package com.backtracking;
/* https://leetcode.com/problems/letter-combinations-of-a-phone-number/ */
/*https://www.youtube.com/watch?v=21OuwqIC56E */

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty ()) return new ArrayList<> ();
        List<String> result = new ArrayList<> ();
        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        computeLetterCombinations(result,digits,"",0,mapping);
        return result;

    }

    private void computeLetterCombinations(List<String> result,String digits, String currentCombination,int index, String[]  mapping) {
      if(currentCombination.length () == digits.length ()){
          result.add(currentCombination);
          return ;
      }
      String letters = mapping[digits.charAt (index)-'0'];
      for(int i = 0; i<letters.length ();i++){
          computeLetterCombinations(result,digits,currentCombination+letters.charAt (i),index+1,mapping);
      }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber lcp = new LetterCombinationsOfPhoneNumber ();
        System.out.println (lcp.letterCombinations ("23"));
    }
}
