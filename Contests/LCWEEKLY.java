package com.Contests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LCWEEKLY {
    public int[] recoverOrder(int[] order, int[] friends) {
        int []arr=new int[friends.length];
        HashSet<Integer>set=new HashSet<>();
        for (int e:friends){
            set.add(e);
        }

        int in=0;
        for (int i = 0; i <order.length; i++) {
            if (set.contains(order[i])){
                arr[in]=order[i];
                in++;
                set.remove(order[i]);
            }
        }
        return arr;
    }
    /*public static long maxProduct(int[] nums) {
        long l=0;
        for (int i = 0; i < nums.length; i++) {
            int j=i+1;
            while (j< nums.length){
                if ((nums[i]&nums[j])==0){
                    l=Math.max(l, (long) nums[i]*nums[j]);
                }
                j++;
            }
        }
        return l;
    }*/
    public static long maxProduct(int[] nums) {
        List<Integer>odd=new ArrayList<>();
        List<Integer>even=new ArrayList<>();
        for (int e:nums){
            if (e%2==0){
                even.add(e);
            }
            else {
                odd.add(e);
            }
        }
        long l=0;
        for (int i = 0; i <odd.size(); i++) {
            int j=0;
            while(j<even.size()){
                if ((odd.get(i)& even.get(j))==0){
                    l=Math.max(l,((long) odd.get(i) *even.get(j)));
                }
                j++;
            }
        }
        for (int i = 0; i <even.size(); i++) {
            int j=i+1;
            while (j<even.size()){
                if ((even.get(i)&even.get(j))==0){
                    l=Math.max(l,((long) even.get(i) *even.get(j)));
                }
                j++;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{64,8,32}));
//        System.out.println(5&6);;
//        System.out.println();
    }

}
