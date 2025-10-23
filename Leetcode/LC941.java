package com.Leetcode;

import java.util.Arrays;

public class LC941 {
    public static boolean validMountainArray(int[] arr) {
        if (arr.length<3){
            return false;
        }
        int s=0;
        int m=-1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]<arr[i+1]){

            } else if (arr[i]>arr[i+1]) {
                m=i;
                break;
            }
            else {
                return false;
            }
        }
        if (m <= 0 || m >= arr.length - 1) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }

        return desascendingOrder(Arrays.copyOfRange(arr,m,arr.length));
    }
    private static boolean desascendingOrder(int []arr){
        for (int i = 0; i <arr.length-1; i++) {
            if (arr[i]<=arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{1,7,9,5,4,1,2}));
    }
}
