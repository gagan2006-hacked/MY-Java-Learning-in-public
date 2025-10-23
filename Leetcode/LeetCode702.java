package com.Leetcode;

public class LeetCode702 {
    public static void main(String[] args) {
        int[]arr=new int[]{1,3,5,6};
        System.out.println(search(arr,2));

    }
    public static int search(int[] nums, int target) {return binarySearch(nums,target,0,nums.length-1);
    }
    public static int binarySearch(int []arr,int target,int start,int end){
        if (start>end){
            return -1;
        }
        int mid =(start+end)/2;
        if (arr[mid]==target){
            return mid;
        }
        if (arr[mid]>target){
            return binarySearch(arr,target,start,mid-1);
        }
        return binarySearch(arr,target,mid+1,end);
    }
}
