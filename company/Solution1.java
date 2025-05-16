package com.company;

import java.util.*;

public class Solution1{
    public static int[] twoSum(int[] nums, int target) {
        ArrayList list=new ArrayList<>(Arrays.asList(nums));
        for (int i = 0;; i++) {
            int x=nums[i];
            int y=target-x;
            if (list.contains(y)) {
                return new int[]{list.indexOf(y),i };
            }
            if (i>=nums.length-1){
                break;
            }
        }


        return new int[]{-1,-1};
    }
  /*  public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0;; ++i) {
            int x = nums[i];
            int y = target - x;
            if (d.containsKey(y)) {
                return new int[] {d.get(y), i};
            }
            d.put(x, i);
        }
    }*/


    public static void main(String[] args) {
        int []arr={2,5,5,11};
        System.out.println(Arrays.toString(twoSum(arr, 10)));
    }
}