package com.company;

import java.util.Arrays;

public class QuickSortUser {
    public static void main(String[] args) {
        int []arr1=new int[5];
        for (int i = 0; i <arr1.length ; i++) {
            arr1[i]=arr1.length-i;
        }
        quickSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    static void quickSort(int[] arr){
        quickSortHelp(arr,0,arr.length-1);
    }

    private static void quickSortHelp(int[] arr,int low ,int hi) {
        if (low>=hi)return;
        int start=low;
        int end=hi;
        int mid=(start+end)/2;
        int pivot=arr[mid];
        while (start<end){
            while (arr[start]<pivot){
                start++;
            }
            while (arr[end]>pivot){end--;
            }
            if (start<=end){
                int temp =arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
        quickSortHelp(arr,low,end);
        quickSortHelp(arr,start,hi);
    }
}
