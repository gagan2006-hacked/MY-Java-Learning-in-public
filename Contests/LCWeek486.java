package com.Contests;

import com.Udemy_Java.Practice.CodingExercise.SumOddRange;

import java.util.Arrays;

public class LCWeek486 {
    public static int minimumPrefixLength(int[] nums) {
        int i=0;
        boolean flag=false;
        for (int j = 0; j <nums.length-1; j++) {
            if (nums[j]>=nums[j+1]){
                i=j;
                flag=true;
            }
        }
        return (!flag)?i:i+1;
    }

//    Q2
    public static int[] rotateElements(int[] nums, int k) {
        if (nums.length<=1)return nums;
        int n=0;
        int []arr=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=0){
                arr[n]=nums[i];
                n++;
            }
        }
        int []myarr= Arrays.copyOfRange(arr,0,n);
        if (myarr.length<=1)return nums;
        rotateArr(myarr,k);
        n=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=0){
                if (n< myarr.length) {
                    nums[i] = myarr[n];
                    n++;
                }
            }
        }
        return nums;
    }
    static void rotateArr(int arr[], int r) {
        // add your code here
        int n=arr.length;
        r%=n;
        swap(arr,0,r-1);
        swap(arr,r,n-1);
        swap(arr,0,n-1);
    }
    public static void swap(int []arr,int i,int j){
        while (i<j){
            int t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            i++;
            j--;
        }
    }

//    Q3
    /*public long nthSmallest(long n, int k) {

    }*/


    public static void main(String[] args) {
//        System.out.println(minimumPrefixLength(new int[]{-4,-10}));
//        System.out.println(Arrays.toString(rotateElements(new int[]{1,-2,3,-4},3)));
        
    }
}
