package com.Udemy_Java.Practice.CodingExercise;

public class FirstLastDigitSum {
    // write code here
    public static int sumFirstAndLastDigit(int n){
        if (n<0)return -1;
        String s=n+"";
        int first=s.charAt(0)-'0';
        int last=n%10;
        return first+last;
    }

    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(252));
    }
}