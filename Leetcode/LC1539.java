package com.Leetcode;

public class LC1539 {
    public static int findKthPositive(int[] arr, int k) {
        int s=0;
        int e= arr.length-1;
        int noOfMissing=0;
        int mid=(s+e)/2;
        while (s<=e){
            mid=(s+e)/2;
            noOfMissing=arr[mid]-(mid+1);
            if (noOfMissing<k){
                s=mid+1;
            }else {
                e=mid-1;
            }
        }
        return s+k;
    }

    public static void main(String[] args) {
        int []arr=new int[]{2,3,4,7,11};
        System.out.println(findKthPositive(arr,5));
    }
}
