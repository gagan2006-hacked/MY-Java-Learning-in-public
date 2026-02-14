package com.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LC260 {
    public static int[] singleNumber(int[] nums) {
        HashSet<Integer>help=new HashSet<>();
        HashSet<Integer>main=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!help.contains(nums[i])){
                help.add(nums[i]);
                main.add(nums[i]);
            }
            else {
                main.remove(nums[i]);
            }
        }
        int []arr=new int[main.size()];
        int i=0;
        for (Integer integer:main){
            arr[i]=integer;
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1,2,1,3,2,5})));
    }
}
