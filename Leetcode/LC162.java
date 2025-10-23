package com.Leetcode;

public class LC162 {
    public int findPeakElement(int[] arr) {
        int s=0;
        int e=arr.length-1;
        while (s<=e){
            int mid=(s+e)/2;
            if (arr[mid]>arr[mid+1]){
                e=mid-1;
            }else {
                s=mid+1;
            }
        }
        return s;
    }
}
