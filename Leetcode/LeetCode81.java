package com.Leetcode;

public class LeetCode81 {
    public static void main(String[] args) {
        int []arr=new int[]{1,0,1,1,1};

    }
//    public static int findPeakInd(int[]nums,int s,int e,int mid ){
//        if (nums.length==1){
//            return 0;
//        } mid=(s+e)/2;
//        if (mid!=0 && mid!=nums.length-1){
//            if ((nums[mid-1]<nums[mid])&&nums[mid]>nums[mid+1]){
//                return mid;
//            } else if ((nums[mid-1]>nums[mid])&& nums[mid]>nums[mid+1]) {
//                return findPeakInd(nums,s,mid-1,mid);
//            } else if ((nums[mid-1]<nums[mid])&& nums[mid]<nums[mid+1]) {
//                return findPeakInd(nums,mid+1,e,mid);
//            }
//        }if (s==0 && e==0 && nums[s]>nums[s+1]){
//            return s;
//        }
//        if (s>=0 && s<nums.length && e>=0 &&e<nums.length) {
//
////            [4,5,6,7,0,1,2]
//            if ((nums[s] < nums[mid]) && nums[mid] > nums[e]) {
//                return findPeakInd(nums,s+1,e-1,mid);
//            }
////            [7,0,1,2,3,4,5]
//            else if ((nums[s]>nums[mid])&& nums[mid]>nums[e]){
//                return findPeakInd(nums,s,mid-1,mid);
//            }
////            [1,2,3,4,7,5]
/*
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
    public static boolean searchHelper(int []arr,int start,int end,int target){
        while (start<=end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid]<target){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return false;
    }
*/
/* public boolean search(int[] arr, int target) {
         int peak=findPeakInd(arr,0,arr.length-1,(arr.length-1)/2);
        if (arr[peak]==target){
            return true;
        }
        if(peak!=0&&(arr[peak]==arr[peak-1])||(peak!=arr.length-1)&& arr[peak]==arr[peak+1])
        {for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return true;
            }
        }return false;
        }
        if (arr[0]<=target){
            return searchHelper(arr,0,peak,target);
        }else {
           return searchHelper(arr,peak+1,arr.length-1,target);
        }

    }

    public  int findPeakInd(int[]nums,int s,int e,int mid ){
        if (nums.length==1){
            return 0;
        } mid=(s+e)/2;
        if (mid!=0 && mid!=nums.length-1){
            if ((nums[mid-1]<nums[mid])&&nums[mid]>nums[mid+1]){
                return mid;
            } else if ((nums[mid-1]>nums[mid])&& nums[mid]>nums[mid+1]) {
                return findPeakInd(nums,s,mid-1,mid);
            } else if ((nums[mid-1]<nums[mid])&& nums[mid]<nums[mid+1]) {
                return findPeakInd(nums,mid+1,e,mid);
            }
        }if (s==0 && e==0 && nums[s]>nums[s+1]){
            return s;
        }
        if (s>=0 && s<nums.length && e>=0 &&e<nums.length) {

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
    public boolean searchHelper(int []arr,int start,int end,int target){
        while (start<=end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid]<target){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return false;
    }
     */
    // new mod date;5/07/25 event python lab exam
     /*public boolean search(int[] nums, int target) {


     }*/
}
