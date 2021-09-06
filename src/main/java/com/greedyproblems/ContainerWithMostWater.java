package com.greedyproblems;
/* https://leetcode.com/problems/container-with-most-water/ */
public class ContainerWithMostWater {
    /* BruteForce Solution */
    public int maxArea1(int[] height) {
        if(height == null) return 0;
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < height.length;i++){
            for(int j = i+1; j < height.length;j++){
                maxArea = Math.max(maxArea,((height[i] < height[j] ? height[i]:height[j])* (j-i)));
            }
        }
        return  maxArea;
    }

    /* 2 pointer approach */
    public int maxArea(int[] height) {
        if(height == null) return 0;
        int maxArea = 0, i = 0, j = height.length-1;
        while(i < j){
            maxArea = Math.max(maxArea,((height[i] < height[j] ? height[i]:height[j])* (j-i)));
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return  maxArea;
    }


    public static void main(String[] args) {
    int height[] = {1,8,6,2,5,4,8,3,7};
    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
    System.out.println (containerWithMostWater.maxArea (height));
    }

}
