package com.Leetcode;

public class LeetCode35 {
    public static void main(String[] args) {
        int[]arr=new int[]{1,3,5,6};
        System.out.println(searchInsert(arr,7));
    }
    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }
    public static int binarySearch(int []arr,int target,int start,int end){
        if (start>end){
                return start;
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
