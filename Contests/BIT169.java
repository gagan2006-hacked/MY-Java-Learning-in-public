package com.Contests;

public class BIT169 {
    public int minMoves(int[] nums) {
        if (nums.length<=1){
            return 0;
        }
        int max=0;
        for (int i = 0; i <nums.length; i++) {
            max=Math.max(max,nums[i]);
        }
        int steps=0;
        for (int i = 0; i <nums.length; i++) {
            steps+=(max-nums[i]);
        }
        return steps;
    }
}
