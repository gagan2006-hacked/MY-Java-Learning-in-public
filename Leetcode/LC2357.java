package com.Leetcode;

public class LC2357 {
    public static int minimumOperations(int[] nums) {
        int op=0;
        while (true){
            int min=101;
            for (int i = 0; i <nums.length; i++) {
                if (nums[i]!=0&&min>nums[i]){
                    min=nums[i];
                }
            }
            if (101==min)break;
            op++;
            for (int i = 0; i <nums.length; i++) {
                if (nums[i]!=0)nums[i]=nums[i]-min;
            }
        }
        return op;
    }

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1,5,0,3,5}));
    }
}
