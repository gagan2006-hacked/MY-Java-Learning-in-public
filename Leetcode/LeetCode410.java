package com.Leetcode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class LeetCode410 {
    public static void main(String[] args) {
        int []arr=new int[]{7,2,5,10,8};
        System.out.println(splitArray(arr,2));
//        solve(arr,0,(arr.length- 5 +1),0,5,"");
//        System.out.println(splitArray(arr,5));
       /* List<Integer>list=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        System.out.println(list);
        List<List<Integer>> re=new ArrayList<>();
        re.add(list.subList(0,1));
        re.add(list.subList(1,3));
        re.add(list.subList(3,4));
        re.add(list.subList(4,5));
        re.add(list.subList(5,6));
        System.out.println(re);*/
//        re.clear();
//        System.out.println(re);
    }
    public static int splitArray(int[] nums, int k) {
        int max=0;
        int min=0;
        for (int ele:nums){
            max+=ele;
            min=Math.max(min,ele);
        }

        return binSearchForArray(nums,min,max,0,k);
    }
    public static int binSearchForArray(int []arr,int min,int max,int pieces,int m){
        int mid=(min+max)/2;
        while (min<=max){
            mid=(min+max)/2;
            pieces=1;
            int count=0;
            if ((min==mid)&& mid == max){
                return mid;
            }
            for (int i=0;i<arr.length;i++){
                if ((arr[i]+count)<=mid){
                    count+=arr[i];
                } else {
                    pieces+=1;
                    count=arr[i];
                }

            }
            if (pieces<=m){
                max=mid;
            }else {
                min=mid+1;
            }
        }
        return mid;
    }
   /* public static void solve(int[]arr,int s,int limit,int length,int k,String value){
       if (length==k){
           System.out.println(value);
           return;
       }
       if
    }*/







    /*public static int solve(int []arr,int s,int e,int mid,int k,int max){
        if (k==0) {
            if (s >=1){
                return getMaxofGivenArray(arr, s-1 , e, mid, max);
            }else {
                return getMaxofGivenArray(arr,s,e,mid,max);
            }
        }
        int next=0;
        boolean b=false;
        for (int i=s;i<arr.length-1;i++){
            if (i+1<arr.length-(k-1)){
                next=solve(arr,s+1,e,i+1,k-1,max);
                b=true;
            }
            if (b && next<max){
                max=next;
            }
        }
        return max;
    }

    private static int getMaxofGivenArray(int[] arr, int s, int e,int mid, int max) {
        int sum1=0;
        int sum2=0;
        int i=s;
        while (i<mid){
            sum1+=arr[i++];
        }
        while (mid<=e){
            sum2+=arr[mid++];
        }
        return Math.max(sum1, sum2);
    }*/
}
