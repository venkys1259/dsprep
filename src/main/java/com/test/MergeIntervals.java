package com.test;

/*https://leetcode.com/problems/merge-intervals/ */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1){
            return intervals;
        }
        Arrays.sort (intervals, (arr1,arr2) -> (arr1[0]-arr2[0]));
        List<int[]> result = new ArrayList<> ();
        int[] currentInterval = intervals[0];
        for(int i = 1; i<intervals.length;i++){
            int nextBegin = intervals[i][0];
            int nextEnd = intervals[i][1];
            int currentEnd = currentInterval[1];
            if(nextBegin <= currentEnd){
                currentInterval[1] = Math.max (currentEnd,nextEnd);
            }else{
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        result.add(currentInterval);
        return result.toArray (new int[result.size ()][]);
    }
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals ();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = mergeIntervals.merge (intervals);
        for(int i=0; i< result.length;i++){
            System.out.println (result[i][0] + "," + result[i][1]);
        }
    }
}
