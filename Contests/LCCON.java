package com.Contests;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class LCCON {
    public int gcdOfOddEvenSums(int n) {
        int odd=(int)Math.pow(n,2);
        int even=odd+n;

        return gcd(odd,even);
    }

    private int gcd(int odd, int even) {
        if (even==0){
            return odd;
        }
        return gcd(even,odd%even);
    }
    public static boolean partitionArray(int[] arr, int k) {
        if (arr.length==k){
            HashSet<Integer>set=new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                if (set.contains(arr[i]))
                {
                    return false;
                }
                set.add(arr[i]);
            }
            return true;
        }
        if (arr.length%k!=0){
            return false;
        }
        int []copy= Arrays.copyOf(arr,arr.length);
//        Arrays.sort(copy);
        Queue<Integer> og=new ArrayDeque<>();
        Queue<Integer>remain=new ArrayDeque<>();
        HashSet<Integer>set=new HashSet<>();
        int noGrp=0;
        boolean allUsed=false;
        int i=0;
        while (i<copy.length){
            if (set.contains(copy[i])){
                remain.add(copy[i]);
            }
            else {
                set.add(copy[i]);
            }
            if (set.size()==k){
                noGrp+=1;
                set.removeAll(set);
            }
            i++;
        }
        if (!set.isEmpty()&&set.size()<k){
            if (remain.isEmpty()){
                return false;
            }
            while (!remain.isEmpty()){
                int va= remain.poll();
                if (set.contains(va)){
                    og.add(va);
                }else {
                    set.add(va);
                }
                if (set.size()==k){
                    noGrp+=1;
                    set.removeAll(set);
                }
            }
        }
        return noGrp==(copy.length)/k&&og.isEmpty()&&remain.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{57,25,79,57,23},4));
//        System.out.println(partitionArray(new int[]{81,90,35,38,98,108,87,108,92,76,108,96},3));
    }

}
