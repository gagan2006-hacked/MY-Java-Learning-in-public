package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC15 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public static List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer>list=new HashSet<>();
        for (int ele:arr){
            list.add(ele);
        }

        List<List<Integer>> result=new ArrayList<>();
        return result;
    }


}
