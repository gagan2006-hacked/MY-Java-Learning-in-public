package com.Udemy_Java.Practice.CodingExercise;

public class MinutesToYearsDaysCalculator {
    // write code here
    public static void printYearsAndDays(long min){
        if (min<0){ System.out.println("Invalid Value");return;}
        String s=min+" min = ";
        int years=(int)(min/525600);
        int days=(int)((min-525600*years)/1440);
        if(min==0)days=0;
        s=s+years+" y and "+days+" d";
        System.out.println(s);
    }

    public static void main(String[] args) {
        printYearsAndDays(1440  );
    }
}