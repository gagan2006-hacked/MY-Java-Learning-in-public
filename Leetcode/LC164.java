package com.Leetcode;

import java.util.Arrays;

public class LC164 {
    public int maximumGap(int[] arr) {
        if (arr.length<=1){
            return 0;
        }
        Arrays.sort(arr);
        int diff=0;
        for (int i = 0; i < arr.length-1; i++) {
            diff=Math.max(arr[i+1]-arr[i],diff);
        }
        return diff;
    }
}
