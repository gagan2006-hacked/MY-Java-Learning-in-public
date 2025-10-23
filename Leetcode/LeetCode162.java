package com.Leetcode;

public class LeetCode162 {
    public static void main(String[] args) {
        int []ar=new int[]{2,1};
        System.out.println(findPeakElement(ar));
    }
    public static int findPeakElement(int[] nums) {
        return findPeakInd(nums,0,nums.length-1,(nums.length-1)/2);
    }
    public static int findPeakInd(int[]nums,int s,int e,int mid ){
        if (nums.length==1){
            return 0;
        } mid=(s+e)/2;
        if (s>e){
            return -1;
        }
        if (mid==nums.length-1){
            if (nums[mid-1]<nums[mid]) {
                return mid;
            }
        }
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
            }
        }
        if ( mid!= 0 && nums[mid-1]<nums[mid]){
            return findPeakInd(nums,mid,e,mid);
        }else if (mid!=0 &&nums[mid]<nums[mid-1]){
            return findPeakInd(nums,s,mid,mid);
        }else if (mid==0){
            mid+=1;
            if (  nums[mid-1]<nums[mid]){
                return findPeakInd(nums,mid,e,mid);
            }
            mid-=1;
        }

        return mid;
    }
}
