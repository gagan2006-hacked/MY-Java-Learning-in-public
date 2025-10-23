package com.Contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCweek469 {
    /*public static int[] decimalRepresentation(int n) {

        List<Integer>list=new ArrayList<>();
        int pow=1;
        while (n!=0){
            int num=n%10;
            if (num!=0){
                list.addFirst(num*pow);
            }
            n=n/10;
            pow*=10;
        }
        int []arr=new int[list.size()];
        for (int i = 0; i <list.size(); i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }*/
    public static boolean validMountainArray(int[] arr) {
        if (arr.length<3){
            return false;
        }
        int s=0;
        int m=-1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]<arr[i+1]){

            } else if (arr[i]>arr[i+1]) {
                m=i;
                break;
            }
            else {
                return false;
            }
        }
        if (m <= 0 || m >= arr.length - 1) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }

        return desascendingOrder(Arrays.copyOfRange(arr,m,arr.length));
    }
    private static boolean desascendingOrder(int []arr){
        for (int i = 0; i <arr.length-1; i++) {
            if (arr[i]<=arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static long splitArray(int[] arr) {
        if (!validMountainArray(arr)){
            return -1;
        }
        int peak=peakIndexInMountainArray(arr);
        long leftSum=sumOfr(arr,0,peak);
        long right=sumOfr(arr,peak+1,arr.length);
        if (leftSum>right){
            long num=right+arr[peak]-leftSum;
            if (num<0){
                num*=-1;
            }
            return num;
        } else if (leftSum<right) {
            long num=leftSum+arr[peak]-right;
            if (num<0){
                num*=-1;
            }
            return num;
        }
        return arr[peak];
    }
//    [1,2,4,3,2]
    private static long sumOfr(int []arr,int s,int e){
        long l=0;
        for (int i =s; i <e; i++) {
            l+=arr[i];
        }
        return l;
    }
    public static int peakIndexInMountainArray(int[] arr) {
        return findPeakInd(arr,0,arr.length-1,(arr.length-1)/2);
    }
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

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(decimalRepresentation(102)));
        System.out.println(splitArray(new int[]{1,2,4,3,}));
    }
}
