package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC78 {
    public static List<List<Integer>> subsetsHelp(int[] arr,List<Integer> result,int i) {
        if (i==arr.length){
            List<List<Integer>>list=new ArrayList<>();
            list.add(new ArrayList<>(result));

            return list;
        }
        List<List<Integer>>list=new ArrayList<>();
        result.add(arr[i]);
        list.addAll(subsetsHelp(arr,result,i+1));
        result.removeLast();
        list.addAll(subsetsHelp(arr,result,i+1));
        return list;
    }
    public static void subset(String value,String up){
        if (up.isEmpty()){
            System.out.println(value);
            return;
        }
        subset(value+up.charAt(0),up.substring(1));
        subset(value,up.substring(1));
    }

    public static void main(String[] args) {
//        subset("","123");
//        System.out.println(Arrays.toString(Arrays.copyOfRange(new int[]{1,2,3,4,5},1,5)));
        System.out.println(subsetsHelp(new int[]{1,2,2},new ArrayList<>(),0));
    }

}
