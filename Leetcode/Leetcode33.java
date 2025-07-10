package com.Leetcode;

public class Leetcode33 {
    public static void main(String[] args) {
        int []ar=new int[]{1,3};
        System.out.println(search(ar,3));
    }
    public static int search(int[] nums, int target) {
        int peak=findPeakInd(nums,0,nums.length-1,(nums.length-1)/2);
        if (nums[0]<target){
            return binarySearch(nums,target,0,peak);
        }
        return binarySearch(nums,target,peak+1,nums.length-1);
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


    public static int binarySearch(int []arr,int target,int start,int end){
        if (start>end){
            return -1;
        }
        if (arr[end]==target){
            return end;
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
