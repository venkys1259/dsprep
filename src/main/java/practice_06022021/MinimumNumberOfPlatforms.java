package practice_06022021;

import java.util.Arrays;
/*
https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
    Given the arrival and departure times of all trains that reach a railway station, the task is to find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays that represent the arrival and departure times of trains that stop.

Examples:

Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
Explanation: There are at-most three trains at a time (time between 11:00 to 11:20)

Input: arr[] = {9:00, 9:40}
dep[] = {9:10, 12:00}
Output: 1
Explanation: Only one platform is needed.
 */
public class MinimumNumberOfPlatforms {
    private int minNumberOfPlatsForms(int[] a, int[] b){
        int i  = 0,j = 0,counter = 0;
        Arrays.sort (a);
        Arrays.sort (b);
        while(i<a.length){
            if(a[i] < b[j]){ // arrival train is coming, so it needs platform
                counter++;
            }else{ // some train departed. so we can use that space
                j++;
            }
            i++;// give a way to next arrival
        }

        return counter <= 0 ? 1 : counter;
    }
    public static void main(String[] args) {
        MinimumNumberOfPlatforms minimumNumberOfPlatforms = new MinimumNumberOfPlatforms();
        int a[] = {900, 940, 950, 1100, 1500, 1800}, b[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println (minimumNumberOfPlatforms.minNumberOfPlatsForms(a,b));
    }
}
