package com.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>list=new HashMap<>();
        List<Integer>result=new ArrayList<>();
//        boolean flag=false;
        if (nums1.length< nums2.length){
            for (int num : nums1) {
                if (list.containsKey(num)) {
                    list.put(num, list.get(num) + 1); // increase count
                } else {
                    list.put(num, 1); // first time, count = 1
                }
            }
            for (int i:nums2){
                if (list.containsKey(i)&& list.get(i) > 0){
                    result.add(i);
                    list.put(i,list.get(i)-1);
                }
            }
        }else {
            for (int num:nums2){
                if (list.containsKey(num)) {
                    list.put(num, list.get(num) + 1); // increase count
                } else {
                    list.put(num, 1); // first time, count = 1
                }
            }
            for (int i:nums1) {
                if (list.containsKey(i)&& list.get(i) > 0){
                    result.add(i);
                    list.put(i,list.get(i)-1);
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
