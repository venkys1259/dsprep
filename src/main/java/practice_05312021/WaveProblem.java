package practice_05312021;
/*
https://www.geeksforgeeks.org/sort-array-wave-form-2/
Given an unsorted array of integers, sort the array into a wave like array. An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
Examples:

 Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
 Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
                 {20, 5, 10, 2, 80, 6, 100, 3} OR
                 any other array that is in wave form

 Input:  arr[] = {20, 10, 8, 6, 4, 2}
 Output: arr[] = {20, 8, 10, 4, 6, 2} OR
                 {10, 8, 20, 2, 6, 4} OR
                 any other array that is in wave form

 Input:  arr[] = {2, 4, 6, 8, 10, 20}
 Output: arr[] = {4, 2, 8, 6, 20, 10} OR
                 any other array that is in wave form
 */
import java.util.Arrays;

public class WaveProblem {
    private int[] wave(int[] a){
        boolean increasingFlag = false;
        for(int i = 1; i<a.length;i++){
            if((a[i] > a[i-1] && increasingFlag==false) ||
                    (a[i] < a[i-1] && increasingFlag==true)
                    ){
                swap(a,i,i-1);
            }
            increasingFlag = increasingFlag==true?false:true;
        }

        return a;
    }
    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        WaveProblem waveProblem = new WaveProblem();
        int[] a = {10, 5, 6, 3, 2, 20, 100, 80};
        System.out.println (Arrays.toString(waveProblem.wave(a)));
    }
}
