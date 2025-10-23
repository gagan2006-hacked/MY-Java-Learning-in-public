package com.GfG;

public class NextPermutation {
    void nextPermutation(int[] arr) {
        // code here
        int point=-1;
        int large=-1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]<arr[i+1]){
            }
            else {
                point=i+1;
            }
        }
        swap(arr,point, arr.length);
    }
    public static void swap(int []arr,int s,int e){
        while (s<e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
}
