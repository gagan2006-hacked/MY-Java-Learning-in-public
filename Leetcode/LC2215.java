package com.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC2215 {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer>sub1=new HashSet<>();
        List<Integer>integers=new ArrayList<>();
        HashSet<Integer>sub2=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            sub1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!sub1.contains(nums2[i])){
                sub2.add(nums2[i]);
            }else {
                integers.add(nums2[i]);
            }
        }
        integers.forEach(sub1::remove);
        List<List<Integer>>list=new ArrayList<>();
        list.add(new ArrayList<>(sub1));
        list.add(new ArrayList<>(sub2));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1,2,3},new int[]{2,4,6}));
    }
}
