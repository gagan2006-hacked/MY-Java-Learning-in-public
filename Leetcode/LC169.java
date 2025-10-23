package com.Leetcode;

import java.util.Arrays;

public class LC169 {
    public static int majorityElement(int[] arr) {
        if (arr.length==1){
            return arr[0];
        }
        Arrays.sort(arr);
        int n= arr.length;
        int s=0;
        int end=n/2;
        int count=end;
        while (end<n){
            if (s<n && end<n && arr[s]==arr[end]){
                return arr[end];
            }
            s++;
            end=count+s;
        }
        return -1;
    }

    public static void main(String[] args) {
        int []arr=new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));

    }

}
