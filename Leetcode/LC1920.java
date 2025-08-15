package com.Leetcode;

public class LC1920 {
//    brute force or common sense
  /*  public int[] buildArray(int[] arr) {
        if (arr.length==0){
            return arr;
        }
        int []result=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]< arr.length){
                result[i]=arr[arr[i]];
            }
        }
        return result;
    }*/
    public int[] buildArray(int[] arr) {
        swap(arr,0);
        return arr;
    }
    private void swap(int[]arr,int ind){
        if (ind<arr.length){
            int temp=arr[arr[ind]];
            swap(arr,ind+1);
            arr[ind]=temp;
        }
    }
}
