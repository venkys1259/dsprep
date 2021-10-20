package com.dynamicprogramming;

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                result = Math.max(result,longest(matrix,i,j,-1,dp));
            }
        }
       return  result;
    }

    private int longest(int[][] matrix, int i, int j, int prev, int[][] dp) {
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j] <= prev){
            return 0;
        }
        else{
            if(dp[i][j] != 0){
                return dp[i][j];
            }
            int max = Math.max(1 + longest(matrix, i + 1, j, matrix[i][j], dp), 1 + longest(matrix, i, j+ 1, matrix[i][j], dp));
            max = Math.max(max, 1 + longest(matrix, i - 1, j, matrix[i][j], dp));
            max = Math.max(max, 1 + longest(matrix, i, j - 1, matrix[i][j], dp));
            dp[i][j] = max;
            return max;
        }
    }

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix lipm = new LongestIncreasingPathInAMatrix ();
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println (lipm.longestIncreasingPath (matrix));
    }
}
