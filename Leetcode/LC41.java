package com.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LC41 {
    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int max=Integer.MIN_VALUE;
        for (Integer i:nums){
            max=Math.max(max, i);
            set.add(i);
        }
        for (int i = 1; i <=max; i++) {
            if (!set.contains(i)){
                return i;
            }
        }
        if (max<0){
            return 1;
        }
        return max+1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
