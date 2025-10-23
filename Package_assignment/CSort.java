package com.Package_assignment;

import java.util.Arrays;

import static com.company.Dissper_elle.swap;

public class CSort {
    public static void main(String[] args) {
        int []arr=new int[]{5,4,3,2,2};
        cSort(arr,0);
        System.out.println(Arrays.toString(arr));
    }
    //not op
    // order at 0 -> 1 at 1->2
    public static void  cSort(int []arr,int start){
        if (start==arr.length){
            return;
        }
        int correctValue=arr[start]-1;
        if (arr[start]==arr[correctValue]){
            cSort(arr,start+1);
        }else {
            swap(start,arr[start]-1,arr);
            cSort(arr,start);
        }
    }

}
