package com.Leetcode;

public class Leetcode852 {
    public static void main(String[] args) {
        int []arr=new int[]{2,2,2,0,1};
        System.out.println(findPeakInd(arr,0,arr.length-1,(arr.length-1)/2));
    }
   /* public static int findPeakInd(int[]arr,int s,int e,int mid ){
        if (s>e){
            return -1;
        }
        if (s==0 && e==0 && arr[s]>arr[s+1]){
            return s;
        }
        mid=(s+e)/2;
        if ((mid>0)&&(arr[mid-1]<arr[mid])&&arr[mid]>arr[mid+1]){
            return mid;
        } else if ((arr[s] < arr[mid]) && arr[mid] > arr[e]) {
                return findPeakInd(arr,s+1,e-1,mid);
        }

    }*/
   public static int findPeakInd(int[]nums,int s,int e,int mid ){
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

}
