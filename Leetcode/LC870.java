package com.Leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

public class LC870 {
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Queue<Integer>unUse=new ArrayDeque<>();
        HashMap<Integer,Queue<Integer>> map=new HashMap<>();
        for (int i = 0; i <nums2.length; i++) {
            if (map.containsKey(nums2[i])){
                Queue<Integer>in=map.get(nums2[i]);
                in.offer(i);
            }else {
                Queue<Integer> in=new ArrayDeque<>();
                in.add(i);
                map.put(nums2[i],new ArrayDeque<>(in));
            }
        }
        Arrays.sort(nums2);

        int i=0;
        int j=0;
        int []arr=new int[nums1.length];
        Arrays.fill(arr,-1);
        while (i<nums1.length&&j<nums2.length){
            if (nums1[i]>nums2[j]){
                Queue<Integer> queue=map.get(nums2[j]);
                int ind=queue.remove();
                arr[ind]=nums1[i];
                if (queue.isEmpty()){
                    map.remove(nums2[j],queue);
                }
                j++;

            }else {
                unUse.offer(i);
            }
            i++;
        }
        int n=0;
        while (!unUse.isEmpty()&&n< nums1.length){
            if (arr[n]==-1){
                int ind=unUse.remove();
                arr[n]=nums1[ind];
            }
            n++;
        }

        return arr;

    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(advantageCount(new int[]{12,24,8,32},new int[]{13,25,32,11})));
    }
}
