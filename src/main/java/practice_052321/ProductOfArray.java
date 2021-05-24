package practice_052321;

/*

https://leetcode.com/problems/product-of-array-except-self/
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.


Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*/
public class ProductOfArray {
    private int[] productExceptSelf(int[] nums){
        int prefixProduct = 1, suffixProduct = 1;
        int[] prArray = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            int j = i+1;
            while(j<nums.length){
                suffixProduct = suffixProduct * nums[j]; // suffix product will be right side elements product
                j++;
            }
            int k  =  i-1;
            while(k>=0) {
                prefixProduct = prefixProduct * nums[k]; // left side elements product
                k--;
            }
            prArray[i] = prefixProduct*suffixProduct;
            suffixProduct = prefixProduct = 1;
        }
        return prArray;
    }


    public static void main(String[] args) {
        int[] nums = {3,5,2,4};
        ProductOfArray productOfArray = new ProductOfArray();
        int[] ints = productOfArray.productExceptSelf (nums);
        for(Integer num:ints){
            System.out.println (num);
        }
    }
}
