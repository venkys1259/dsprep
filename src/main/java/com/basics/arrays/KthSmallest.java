package com.basics.arrays;

public class KthSmallest {
    private int getKthSmallest(int[] a, int k){
        return  quickSelect(a,0,a.length-1,k);
    }

    private int quickSelect(int[] a, int low, int high, int k){
        if(low == high){
            if(low == k){
                return a[low];
            }else{
                return  -1;
            }
        }else{
            int j =  partition(a,low,high);
            if(j == k){
                return a[j];
            }else if( j > k){
             return  quickSelect(a,low,j-1,k);
            }else{
                return  quickSelect(a,j+1,high,k);
            }
        }
    }
    private int partition(int[] a, int low,int high){
        int left = low, right = high, pivot = a[0];
            while(left < right){
               while(a[left] <= pivot) left++;
               while(a[right] > pivot) right--;
               if(left<right){
                   swap(a,left,right);
               }
            }
            swap(a,low,left);
            return right;
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        int[] a = {3,2,1,5,6,4};
        System.out.println (kthSmallest.getKthSmallest (a,3));
    }
}
