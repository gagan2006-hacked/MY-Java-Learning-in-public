package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {
   /* public static List<List<Integer>> fourSum(int[] arr, int target) {
//        [1,0,-1,0,-2,2] -> [-2,-1,0,0,1,1,2];
        if (arr.length<4){
            return new ArrayList<>();
        }
        Arrays.sort(arr);
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>list1=new ArrayList<>();
        for (int i = 0; i <arr.length-3; i++) {
            for (int j = i+1; j <arr.length-2; j++) {
                List<Integer> list = new ArrayList<>(findTarget(arr, j + 1, target - arr[i] - arr[j]));
                if (!list.isEmpty()){
                    list1.add(arr[i]);
                    list1.add(arr[j]);
                    list1.addAll(list);
                    if (!result.contains(list1)){
                        result.add(new ArrayList<>(list1));
                    }
                    list1.removeAll(list1);
                }
            }
        }
        return result;
    }
    private static List<Integer> findTarget(int []arr,int s,int targ){
        List<Integer>list=new ArrayList<>();
        for (int i = s; i <arr.length-1; i++) {
            for (int j = i+1; j <arr.length; j++) {
                if (targ==arr[j]+arr[i]){
                    list.add(arr[i]);
                    list.add(arr[j]);
                    return list;
                }
            }
        }
        return list;
    }*/


//   chat gpt
public static List<List<Integer>> fourSum(int[] arr, int target) {
    List<List<Integer>> result = new ArrayList<>();
    int n = arr.length;
    if (n < 4) return result;

    Arrays.sort(arr);

    for (int i = 0; i < n - 3; i++) {
        if (i > 0 && arr[i] == arr[i - 1]) continue; // skip duplicates for i

        for (int j = i + 1; j < n - 2; j++) {
            if (j > i + 1 && arr[j] == arr[j - 1]) continue; // skip duplicates for j

            int left = j + 1, right = n - 1;

            while (left < right) {
                long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];

                if (sum == target) {
                    result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));

                    // move left and right while skipping duplicates
                    while (left < right && arr[left] == arr[left + 1]) left++;
                    while (left < right && arr[right] == arr[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    return result;
}


    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2},0));
    }
}
