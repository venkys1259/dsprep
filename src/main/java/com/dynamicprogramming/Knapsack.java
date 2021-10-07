package com.dynamicprogramming;
/* https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/ */
public class Knapsack {
    int maxKnapSack(int capacity, int[] weights, int[] val){
        int n = val.length;
        int[][] ks = new int[n+1][capacity+1];
        for(int i = 0; i <= n;i++){
            for(int w = 0; w<=capacity;w++){
                if(i ==0 || w == 0){
                    ks[i][w] = 0;
                }else if(weights[i-1] <= w){
                    ks[i][w] = Math.max (ks[i-1][w], (val[i-1]+ ks[i-1][w-weights[i-1]]));
                }else{
                    ks[i][w] = ks[i-1][w];
                }
            }
        }
        return ks[n][capacity];
    }
    public static void main(String[] args) {
    int[] val = {60,100,120};
    int[] wt = {10,20,30};
    int knapSackCapacity = 50;
    Knapsack knapsack = new Knapsack ();
    System.out.println (knapsack.maxKnapSack(knapSackCapacity,wt,val));
    }
}
