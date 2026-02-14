package com.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LC128 {
    public static int longestConsecutive(int[] nums) {
        TreeSet<Integer>set=new TreeSet<>();
        for (int ele:nums){
            set.add(ele);
        }
        List<Integer> list = new ArrayList<>(set);
        if (list.size()<=1){
            return list.size();
        }
        int s=-1,end=-1;
        int max=1;
        for (int i = 0; i <list.size()-1; i++) {
            if (set.contains(list.get(i)+1)){
                if (s==-1){
                    s=i;
                }
                if (i==list.size()-2){
                    end=i+1;
                    max=Math.max(max,(end-s)+1);
                    s=-1;
                }
            }
            else {
                if (s!=-1){
                    end=i;
                    max=Math.max(max,(end-s)+1);
                    s=-1;
                    end=-1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,9,4,6,0,1}));
    }
}
