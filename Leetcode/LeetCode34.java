package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode34 {
    public static void main(String[] args) {
        int []arr=new int[]{2,2};
        System.out.println(Arrays.toString(searchRange(arr,2)));

    }
    public static int[] searchRange(int[] nums, int target) {
        int start=findFirstBinarySearch(nums,target,0,nums.length-1);
        int last=findLastBinarySearch(nums,target,0,nums.length-1);
        return new int[]{start,last};
    }
    public static int findFirstBinarySearch(int []arr, int target, int start, int end){
        if (start>end){
            return -1;
        }
        if (arr.length==1){
            if (arr[0]==target){
                return 0;
            }
        }
        int mid =(start+end)/2;
        if (arr[mid]==target){
            if (mid!=0 && arr[mid-1]<arr[mid]){
               return mid;
            }
            if (mid==0){
                return mid;
            }
             else {
                 return findFirstBinarySearch(arr,target,start,mid-1);
            }
        }
        if (arr[mid]>target){
            return findFirstBinarySearch(arr,target,start,mid-1);
        }
        return findFirstBinarySearch(arr,target,mid+1,end);
    }
    public static int findLastBinarySearch(int []arr,int target,int start,int end){
        if (start>end){
            return -1;
        }
        int mid=(start+end)/2;
        if (arr[mid]==target){
            if (mid!=arr.length-1 && arr[mid+1]>arr[mid]){
                return mid;
            }
            if (mid==arr.length-1){
                return mid;
            }
            else {
                return findLastBinarySearch(arr,target,mid+1,end);
            }
        }
        if (arr[mid]>target){
            return findLastBinarySearch(arr,target,start,mid-1);
        }
        return findLastBinarySearch(arr,target,mid+1,end);
    }
}
