package com.Leetcode;

public class LC154 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,2,2,0,1}));
    }
    public static int findMin(int[] arr) {
        if (arr.length==1){
            return arr[0];
        }
        int peak=findMinPeakInd(arr,0,arr.length-1);
        if (peak== arr.length-1){
            return arr[0];
        } else {
            return arr[peak+1];
        }
    }



    public static int findMinPeakInd(int[]arr,int s,int e){
        int mid=(s+e)/2;
        int n=arr.length-1;
        while (s<e){
            mid=(s+e)/2;
            if (arr[s] == arr[mid] && arr[mid] == arr[e]) {
                s++;
                e--;
            }
            if (mid>0 && mid< arr.length-1){
                if (arr[mid]<arr[mid+1] && (arr[0]<=arr[mid]&&arr[mid]<arr[n])){
                    s=mid+1;
                }
                else if (arr[mid]>arr[mid+1]){

                }
                else if (arr[mid]==arr[mid+1]){
                    while (mid<n &&arr[mid]==arr[mid+1]){
                        mid++;
                    }
                    s=mid;
                }
            }else {
                if (mid== arr.length-1){
                    if (arr[mid]>arr[0]){
                        return mid;
                    }else {
                        return 0;
                    }
                }else {
                    if (arr[mid]<arr[arr.length-1]){
                        return arr.length-1;
                    }else {
                        return mid;
                    }
                }
            }
        }
        return s;
    }

}
