package com.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lc39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<Integer>set=new HashSet<>();
        for (int ele:candidates){
            set.add(ele);
        }
        return combinationSumHelper(new ArrayList<>(set),new ArrayList<>(),0,0,target);
    }
    public static List<List<Integer>> combinationSumHelper(List<Integer> arr,List<Integer> list,int index,int sum,int target){
        if (index>=arr.size()){
            if (sum==target){
                List<List<Integer>> re=new ArrayList<>();
                re.add(new ArrayList<>(list));
            }
            else {
                return new ArrayList<>();
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        for (int i = index; i <arr.size(); i++) {
            if (sum==target){
                result.add(new ArrayList<>(list));
                return result;
            } else if (sum<target) {
                int ele=arr.get(i);
                list.add(ele);
                result.addAll(combinationSumHelper(arr,list,i,sum+ele,target));
                list.removeLast();
            }else {
                return new ArrayList<>();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2},1));
    }
}
