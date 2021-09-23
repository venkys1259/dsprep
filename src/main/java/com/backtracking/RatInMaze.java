package com.backtracking;
/*
https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
Reference: https://www.youtube.com/watch?v=BNEVpkwYqpk
 */
public class RatInMaze {
    int[] pathRow = {0,1};
    int[] pathCol = {1,0};
    public void findPathInMaze(int[][] maze,int[][] solution,int row, int col){
        // Base condition
        if(row == 3 && col == 3 ){
            printSolution (solution);
        }
        else{
            for(int index = 0; index< pathRow.length; index++){
              int newRow = row + pathRow[index];
              int newCol = col + pathCol[index];
              if((isValidMove(maze,newRow,newCol))){
                  solution[newRow][newCol] = 1;
                  findPathInMaze (maze,solution,newRow,newCol);
                  solution[newRow][newCol] = 0;
              }
            }
        }

    }

    private boolean isValidMove(int[][] maze, int newRow, int newCol) {
        if((newRow >=0 && newRow < 4  && newCol >= 0 && newCol < 4) &&
            maze[newRow][newCol] == 1){
            return true;
        }
        return false;
    }

    private void printSolution(int[][] solution) {
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print (solution[i][j] + " ,");
            }
            System.out.println ();
        }
        System.out.println ("====================");
    }

    public static void main(String[] args) {
    int[][] maze = {{1,1,0,1 },{0,1,1,1 },{0,1,0,1 },{0,1,1,1 }};
    int[][] solution = {{0,0,0,0 },{0,0,0,0 },{0,0,0,0 },{0,0,0,0 }};
    solution[0][0] = 1;
    RatInMaze ratInMaze = new RatInMaze ();
    ratInMaze.findPathInMaze(maze,solution,0,0);
    }
}
