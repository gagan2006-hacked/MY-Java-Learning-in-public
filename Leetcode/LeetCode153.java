package com.Leetcode;

public class LeetCode153 {
    public static void main(String[] args) {
        int []arr=new int[]{11,13,14,15,17};
        int peak=findPeakInd(arr,0,arr.length-1,(arr.length-1)/2);
        System.out.println(findTheSmallestInTwoArray(arr,peak,0,arr.length-1));
    }
    public static int findPeakInd(int[]nums,int s,int e,int mid ){
        if (nums.length==1){
            return 0;
        }
        if (mid!=0 && mid!=nums.length-1){
            if ((nums[mid-1]<nums[mid])&&nums[mid]>nums[mid+1]){
                return mid;
            }
        }if (s==0 && e==0 && nums[s]>nums[s+1]){
            return s;
        }
        if (s>=0 && s<nums.length && e>=0 &&e<nums.length) {
            mid=(s+e)/2;
//            [4,5,6,7,0,1,2]
            if ((nums[s] < nums[mid]) && nums[mid] > nums[e]) {
                return findPeakInd(nums,s+1,e-1,mid);
            }
//            [7,0,1,2,3,4,5]
            else if ((nums[s]>nums[mid])&& nums[mid]>nums[e]){
                return findPeakInd(nums,s,mid-1,mid);
            }
//            [1,2,3,4,7,5]
            else if ((nums[e]>nums[mid])&& nums[mid]>nums[s]){
                return findPeakInd(nums,mid+1,e,mid);
            }else if ((nums[s]>nums[mid])&&nums[mid]<nums[e]){
                if (nums[s]<nums[e]){
                    return findPeakInd(nums,mid+1,e,mid);
                }else {
                    return findPeakInd(nums,s,mid-1,mid);
                }
            }else if (s==mid){
                if (nums[s]<nums[e]){
                    return e;
                }else {
                    return s;
                }
            }
        }
        return mid;
    }
    public static int findTheSmallestInTwoArray(int []arr,int peak,int start,int end){
        if (arr.length==1){
            return arr[0];
        }if (arr.length==0){
            return -1;
        }
        if (peak==end){
            return arr[0];
        }
        if (arr[start]<arr[peak+1]){
            return arr[start];
        }else {
            return arr[peak + 1];
        }
    }
}
