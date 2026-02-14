package com.Leetcode;

public class LC2980 {
    public boolean hasTrailingZeros(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j =i+1; j < nums.length; j++) {
                int numF=nums[i];
                int numS=nums[j];
                if ((numF|numS)%2==0)return true;
            }
        }
        return false;
    }
}
