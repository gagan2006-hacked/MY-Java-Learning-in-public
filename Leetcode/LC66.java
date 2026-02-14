package com.Leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LC66 {
    public static int[] plusOne(int[] digits) {
        List<Integer>list=new ArrayList<>();
        int last=digits.length-1;
        if (digits[last]!=9){
            digits[last]=digits[last]+1;
            return digits;
        }

        while (last>-1){
            if (digits[last]==9){
                list.add(0);
            }else {
                break;
            }
            last--;
        }
        if (last!=-1){
        list.add(1+digits[last]);
        last--;
        }else {
            list.add(1);
        }

        while (last>-1){
            list.add(digits[last]);last--;
        }
        Collections.reverse(list);
        return makeArray(list);
    }

    private static int[] makeArray(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{2,4,9,3,9})));
    }
}
