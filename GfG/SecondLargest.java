package com.GfG;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        System.out.println(getSecondLargest(new int[]{1,1,1}));
    }
    public static int getSecondLargest(int[] arr) {
        // code here
        int first =arr[0];
        int second=0;
        for (int i = 1; i < arr.length; i++) {
            if (first<arr[i]){
                second=first;
                first=arr[i];
            }if (first!=arr[i]&&(second<arr[i])){
                second=arr[i];
            }
            second=(second==0)? -1:second;
        }
        return second;
    }


}
