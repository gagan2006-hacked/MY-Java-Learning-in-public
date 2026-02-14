package com.Leetcode;

import java.util.*;

public class LC15 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

     public static List<List<Integer>> threeSum(int[] arr) {
         Arrays.sort(arr);
         HashSet<Integer>list=new HashSet<>();
         for (int ele:arr){
             list.add(ele);
         }

         List<List<Integer>> result=new ArrayList<>();
         return result;
     }
    /*public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr.length < 3) return result;
        TreeSet<Integer> set = new TreeSet<>();
        for (int ele : arr) set.add(ele);
        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < list.size() - 2; i++) {
            for (int j = i + 1; j < list.size() - 1; j++) {
                int sum=list.get(i)+list.get(j);
                int t=(sum<0)?sum*-1:sum;
                int ind=binarySearch(list,t,j,list.size()-1);
                if (ind!=-1&&sum+list.get(ind)==0){
                    List<Integer>list1=new ArrayList<>();
                    list1.add(list.get(i));
                    list1.add(list.get(j));
                    list1.add(list.get(ind));
                    result.add(list1);
                }
            }
        }
        return result;
    }

    public static   int binarySearch(List<Integer>list,int target,int start,int end){
        if (start>end){
            return -1;
        }
        int mid =(start+end)/2;
        if (list.get(mid)==target){
            return mid;
        }
        if (list.get(mid)>target){
            return binarySearch(list,target,start,mid-1);
        }
        return binarySearch(list,target,mid+1,end);
    }*/

}
