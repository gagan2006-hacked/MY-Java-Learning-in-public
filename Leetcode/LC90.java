package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90 {
    /*public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // sort to handle duplicates
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public static void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }*/
    public static List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> list=new ArrayList<>();
        helper(nums,list,0);
        return list;
    }
    private static void helper(int []arr,List<List<Integer>> result,int i){
        if (i>=arr.length){
            return;
        }

    }




    public static void main(String[] args) {
//        subset("","123");
//        System.out.println(Arrays.toString(Arrays.copyOfRange(new int[]{1,2,3,4,5},1,5)));
//        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }


}
