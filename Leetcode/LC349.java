package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> list=new HashSet<>();
        HashSet<Integer>result=new HashSet<>();
        boolean flag=false;
        if (nums1.length< nums2.length){
            for (int i = 0; i < nums1.length; i++) {
                result.add(nums1[i]);
            }
            flag=true;
        }else {
            for (int i = 0; i <nums2.length; i++) {
                result.add(nums2[i]);
            }
        }
        if (flag){
            for (int i = 0; i < nums2.length; i++) {
                if (result.contains(nums2[i])){
                 list.add(nums2[i]);
                }
            }
        }else {
            for (int i = 0; i < nums1.length; i++) {
                if (result.contains(nums1[i])){
                    list.add(nums1[i]);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int []arr=new int[]{1,2,2,1};
        int []arr1=new int[]{2,2};
        System.out.println(Arrays.toString(intersection(arr1,arr)));
    }
}
