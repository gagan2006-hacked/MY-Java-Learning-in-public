package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LC26 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,2,2,3,3}));
    }
    /*public static int removeDuplicates(int[] arr) {
        int k=1;
        int p=arr[0];
        for (int i = 1; i <arr.length; i++) {
            if (p==arr[i]){
                continue;
            }else {
                arr[k++]=arr[i];
            }
            p=arr[i];
        }
        System.out.println(Arrays.toString(arr));
        return k;
    }*/
    public static int removeDuplicates(int[] arr) {
        List<Integer>list=Arrays.stream(arr).boxed().collect(Collectors.toUnmodifiableList());
        HashSet<Integer>set=new HashSet<>(list);
        return set.size();
    }


}
