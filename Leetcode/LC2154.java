package com.Leetcode;

import java.util.HashSet;

public class LC2154 {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer>set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
        }
        while (set.contains(original)){
            original=original*2;
        }
        return original;
    }
}
