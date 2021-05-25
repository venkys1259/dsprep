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
        int[] result = new int[nums.length];
        int[] prefixArray = new int[nums.length];
        int[] suffixArray = new int[nums.length];
        int product = 1;
        prefixArray[0] = 1;
        for(int i = 1; i<nums.length;i++){
            product = product * nums[i-1];
            prefixArray[i] = product;
        }
        product = 1;
        suffixArray[nums.length-1] = 1;
        for(int i = nums.length-1; i>=0;i--){
            if( i  == nums.length-1){
                suffixArray[nums.length-1] = 1;
                product = 1;
            }else {
                product = product * nums[i + 1];
                suffixArray[i] = product;
            }
            result[i] = suffixArray[i]*prefixArray[i] ;

        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProductOfArray productOfArray = new ProductOfArray();
        int[] products = productOfArray.productExceptSelf (nums);
        for(Integer num:products){
            System.out.println (num);
        }
    }
}