package com.Leetcode;

public class LC1437 {
    public static boolean kLengthApart(int[] nums, int k) {
        if(nums.length<=1){
            return true;
        }
        int index=-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                if (index!=-1&&((i-index-1)<k) ){
                    return false;
                }
                index=i;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1,0,0,0,1,0,0,1},2));
    }
}
