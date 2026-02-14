package com.Leetcode;

public class LC3110 {
    public static int scoreOfString(String s) {
        int sum=0;
        for (int i = 0; i <s.length()-1; i++) {
            int val=s.charAt(i)-s.charAt(i+1);
            if (val<0) val*=-1;
            sum+=val;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfString("hello"));
    }
}
