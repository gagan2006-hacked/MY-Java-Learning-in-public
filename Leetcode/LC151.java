package com.Leetcode;

import java.util.Arrays;

public class LC151 {
    public static String reverseWords(String s) {
        StringBuilder builder=new StringBuilder();
        s=s.trim();
        int end=s.length()-1;
        for (int i = s.length()-1; i >-1; i--) {
            if (i==0){
                builder.append(s, i, end+1);
            }
            if (s.charAt(i) == ' ') {
                if (!s.substring(i,end+1).isBlank()){
                    builder.append(s, i+1, end+1).append(" ");
                }
                end=i-1;
            }

        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
