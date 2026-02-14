package com.Udemy_Java.Practice.CodingExercise;

public class SumOddRange {
    // write code here
    public static boolean isOdd(int num){
        return num>0 && !(num%2==0);
    }
    public static int sumOdd(int start,int end){
        if ((start<0 || end<0)||(start>end))return -1;
        if (start%2==0){
            if (start==end)return 0;
            start++;
        }
        if (end%2==0){
            end--;
        }
        int n=(((end-start)/2)+1);
        return n*(2*start+(n-1)*2)/2;
    }

    public static void main(String[] args) {
        System.out.println( sumOdd(10,20));
    }
}