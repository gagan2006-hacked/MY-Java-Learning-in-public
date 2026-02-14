package com.Udemy_Java.Practice.CodingExercise;

public class NumberPalindrome {
    // write code here
    public static boolean isPalindrome (int num){
        if (num<0)num*=-1;
        StringBuilder builder=new StringBuilder(""+num);
        builder.reverse();
        String s=""+num;
        return s.equals(builder.toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(11));
    }
}