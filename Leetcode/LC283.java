package com.Leetcode;

import java.util.Arrays;

public class LC283 {
    public static void moveZeroes(int[] arr) {
        int i=0;
        int index=0;
        while(i< arr.length){
            if (arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                index++;
            }
            i++;
        }
//        System.out.println(Arrays.toString(arr));
    }
    public static void moveZero(int[]arr){
        int i=0;
        int index=0;
        while(i< arr.length){
            if (arr[i]!=0){
                arr[index]=arr[i];
                index++;
            }
            i++;
        }
        while(index< arr.length){
            arr[index++]=0;
        }
                System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        moveZero(new int[]{0,0,0,0,0,4,32,0,2,3,4,4,520,0,0,0,0});
    }
}
