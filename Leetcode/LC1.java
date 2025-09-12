package com.Leetcode;

import java.util.*;

public class LC1 {
    public int[] twoSum(int[] arr, int target) throws InterruptedException {
        HashMap<Integer,Integer>set=new HashMap<>();
//        Thread.sleep(100);
        for (int i = 0; i <arr.length; i++) {
            int number=target-arr[i];
            if (set.containsKey(number)){
                return new int[]{set.get(number),i};
            }
            set.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        for (int i = 0; i <1000; i++) {
            System.out.println(i);
        }
    }

}
