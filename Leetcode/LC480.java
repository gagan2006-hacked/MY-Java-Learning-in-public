package com.Leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC480 {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        if (k==1){
            double []arr=new double[nums.length];
            for (int i = 0; i < nums.length; i++) {
                arr[i]=nums[i];
            }
            return arr;
        }
        List<Double>list=new ArrayList<>();
        int kSize=k;

        for (int i = 0; i <=nums.length-kSize; i++) {
            int[] arr = Arrays.copyOfRange(nums, i, k);
            Arrays.sort(arr);
            int med = kSize / 2;
            double d;
            if (kSize % 2 == 0) {
                d =((double) arr[med] )+ ((double)arr[med - 1]);
                d=d/2;
            } else {
                d = arr[med];
            }
            list.add(i, d);
            k++;
        }
        double []arr=new double[list.size()];
        for (int i = 0; i <list.size(); i++) {
            arr[i]=list.get(i);

        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{2147483647,2147483647},2)));
    }
}
