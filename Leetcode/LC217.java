package com.Leetcode;

import java.util.HashSet;

public class LC217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length<=1){
            return false;
        }
        HashSet<Integer>set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
