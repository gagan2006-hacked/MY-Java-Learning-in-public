package com.Leetcode;

public class LC3097 {
    public static int minimumSubarrayLength(int[] nums, int k) {
        if (nums.length<=1)return (nums[0]>=k)?1:-1;
        int start=0;
        int end=0;
        int min=Integer.MAX_VALUE;
        while (end< nums.length){
            int num=getOr(nums,start,end);
            if (num>=k){
                if (min==1)return min;
                min=Math.min(min,end-start+1);
                start++;
                if (start>end){
                    end++;
                }
            }
            else {
                end++;
            }
        }
        return (min==Integer.MAX_VALUE)?-1:min;
    }

    private static int getOr(int[] nums, int start, int end) {
        int num=nums[start];
        for (int i = start+1; i <end+1; i++) {
            num|=nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(minimumSubarrayLength(new int[]{2,1,8},10));
    }
}
