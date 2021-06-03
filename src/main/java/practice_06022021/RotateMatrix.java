package practice_06022021;

import java.util.Arrays;

/*
https://leetcode.com/problems/rotate-image/
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateMatrix {
    /*
    Approach:
    Flip the matrix Horizontally and apply transpose of that matrix ( rows will be cols, cols will be rows)
     */
    private void rotateNinetyDegrees(int[][] a){
        // Reverse the matrix
        for(int i=0; i<a.length / 2; i++)
        {
            int[] row = a[i];
            a[i] = a[a.length - 1];
            a[a.length - 1] = row;
        }
        //Apply Transpose
        for(int i = 0; i<a.length;i++){
            for(int j = i; j<a.length;j++){
                int temp= a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        System.out.println (Arrays.deepToString (a));
    }

    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
          rotateMatrix.rotateNinetyDegrees (a);
    }
}
