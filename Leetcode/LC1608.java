package com.Leetcode;

import java.util.Arrays;


public class LC1608 {
    public int specialArray(int[] arr) {
        Arrays.sort(arr);
        for (int x = 0; x <arr.length; x++) {
            int index=binarySearch(arr,x);
            if (index!=-1 && arr.length-index==x){
                return x;
            }
        }
        return -1;
    }

    private int binarySearch(int[] arr, int target) {
        int s=0;
        int e=arr.length-1;
        int result=arr.length;
        while (s<=e){
            int mid=(s+e)/2;
            if (arr[mid]<target){
                s=mid+1;
            }
            else if (arr[mid]>=target){
                result=mid;
                e=mid-1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
