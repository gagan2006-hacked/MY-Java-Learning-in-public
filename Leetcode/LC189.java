package com.Leetcode;

import java.util.Arrays;

public class LC189 {
    public static void main(String[] args) {
        int []arr=new int[]{1,2};
        rotate(arr,3);
        System.out.println(Arrays.toString(arr));
    }
    public static void rotate(int[] arr, int k) {
        if (arr.length<=1 || k==0){
            return;
        }
        k=k% arr.length;
        if (k!=0) {
            k = arr.length - k;
            swapInBtw(arr, 0, k - 1);
            swapInBtw(arr, k, arr.length - 1);
            swapInBtw(arr, 0, arr.length - 1);
        }

    }
    public static void swapInBtw(int []arr,int start,int end){
        while (start<end){
            int t=arr[start];
            arr[start]=arr[end];
            arr[end]=t;
            end--;
            start++;
        }
    }
}
