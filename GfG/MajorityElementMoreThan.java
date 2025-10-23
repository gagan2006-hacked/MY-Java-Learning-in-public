package com.GfG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MajorityElementMoreThan {
    public static ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        int n= arr.length;
        ArrayList<Integer>integers=new ArrayList<>();
        HashMap<Integer,Integer>copy=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if (copy.containsKey(arr[i])){
                copy.put(arr[i],copy.get(arr[i])+1);
            }else {
                copy.put(arr[i],1);
            }
        }
        for (int i = 0; i < arr.length-1; i++){
            if (copy.containsKey(arr[i])&&copy.get(arr[i])>(n/3)){
                integers.add(arr[i]);
                copy.put(arr[i],0);
            }
        }
        Collections.sort(integers);
        return integers;
    }

    public static void main(String[] args) {
        System.out.println(findMajority(new int[]{2,2,3,1,3,2,1,1}));
    }
}
