package com.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LC3442 {
    public static void main(String[] args) {
        System.out.println(maxDifference("gaga"));
    }
//     in processs
    public static int maxDifference(String s) {
        int k=0;
        long count=0;
        char target=s.charAt(0);
        List<Long> list=new ArrayList<>();
        for (int i = 0; i <s.length(); ) {
            count = s.chars().filter(ch -> ch == target).count();
            list.add(count);
            i=s.lastIndexOf(s.charAt(i+1));
        }
        return -1;
    }
}
