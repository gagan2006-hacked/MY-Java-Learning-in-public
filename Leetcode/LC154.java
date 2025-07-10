package com.Leetcode;

public class LC154 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1,1,1}));
    }
    public static int findMin(int[] arr) {
        int peak=findMinPeakInd(arr,0,arr.length-1,(arr.length-1)/2);
        return arr[peak];
    }



    public static int findMinPeakInd(int[]arr,int s,int e,int mid ){
        if (arr.length==1){
            return 0;
        } else if (arr.length==0) {
            return -1;
        }
        if (arr.length==2){
            int min=0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[min]>arr[i]){
                    min=i;
                }
            }
            return min;
        }
        while (s<=e){
            mid=(s+e)/2;
            if (mid==0&&(arr[mid]<arr[mid+1])&&arr[mid]<arr[arr.length-1]){
                return mid;
            }
            
            if (mid!=0&&(arr[mid-1]>arr[mid])&&arr[mid+1]>arr[mid]){
                return mid;
            }if (mid<arr.length-1) {
                if (arr[mid] > arr[mid + 1]) {
                    s = mid;
                }
            }
            if (mid>0){
                if (arr[mid] > arr[mid - 1]) {
                    e= mid;
                }
            }
                if ((mid>0)&&mid<arr.length-1)
                 if ((arr[mid]==arr[mid+1])&&arr[mid]==arr[mid-1]){
                    if (arr[arr.length-1]==arr[mid]){
                        e=mid;
                    }else if (arr[0]==arr[mid]){
                        s=s+1;
                    }
                }


        }return mid;
    }

}
