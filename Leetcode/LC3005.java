package com.Leetcode;

import java.util.HashMap;


public class LC3005 {
    public int maxFrequencyElements(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <arr.length; i++) {
            if (map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            max= Math.max(max,map.get(arr[i]));
        }
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i])==max){
                count++;
            }
        }
        return count;
    }
}
