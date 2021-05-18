package practice_051721;

import java.util.Stack;

public class DeleteConsecutiveWords {
    public static void main(String[] args) {
        String[] input = {"tom","jerry","jerry","tom"}; // {"ab","aa","aa","bcd","ab"}; //
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(0);
        for(int i = 1; i<input.length;i++) {
            if (input[indexStack.peek ()].equalsIgnoreCase(input[i])){
                indexStack.pop();
            }else{
                indexStack.push(i);
            }
        }
        System.out.println ("NumberOfWordsLeft:---->" +indexStack.size ());
    }
}
