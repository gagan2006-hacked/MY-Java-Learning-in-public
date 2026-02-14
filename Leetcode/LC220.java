package com.Leetcode;

import java.util.TreeSet;

public class LC220 {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            long current = nums[i];
            Long candidate = set.ceiling(current - valueDiff);

            if (candidate != null && candidate <= current + valueDiff) {
                return true;
            }

            set.add(current);

            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,2,3,4,5,6,7,1},3,2));
    }
}