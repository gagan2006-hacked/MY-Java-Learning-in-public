package com.Leetcode;

import java.util.Arrays;

public class LC215 {
    public static int findKthLargest(int[] arr, int k) {
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        while (i<j){
            int t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            i++;
            j--;
        }
        return arr[k-1];
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
}
