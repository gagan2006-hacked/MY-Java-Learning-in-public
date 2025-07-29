package com.Leetcode;

import java.util.HashMap;
import java.util.Objects;

public class LC1 {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer,Integer>set=new HashMap<>();
        for (int i = 0; i <arr.length; i++) {
            int number=target-arr[i];
            if (set.containsKey(number)){
                return new int[]{set.get(number),i};
            }
            set.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }

}
