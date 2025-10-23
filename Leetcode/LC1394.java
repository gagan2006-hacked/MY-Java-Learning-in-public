package com.Leetcode;

import java.util.Arrays;

public class LC1394 {
    public static int findLucky(int[] arr) {
        Arrays.sort(arr);
        if (arr.length==1){
            return (arr[0]==1)? 1:-1;
        }
        return bS(arr,0, arr.length-1);
    }
    public static int bS(int []arr,int s,int e){
        int i=0;
        int count=0;
        int prev=-1;
        int j=0;
        while (i< arr.length){
            j=i;

            while (j< arr.length && arr[i]==arr[j]){
                count++;
                j++;
            }if (arr[i]==count){
                prev=arr[i];
            }
            count=0;
            i=j;
        }
        return prev;
    }
    public static void main(String[] args) {
        int []arr=new int[]{1,2,2,2,3,3,3};
        System.out.println(findLucky(arr));
    }
}
