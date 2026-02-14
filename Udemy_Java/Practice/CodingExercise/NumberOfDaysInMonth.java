package com.Udemy_Java.Practice.CodingExercise;

public class NumberOfDaysInMonth {
    // write code here
    public static boolean isLeapYear(int yr){
        return (yr>=1&&yr<=9999)&&((yr%4==0 &&(yr%100!=0))||yr%400==0);
    }
    public static int getDaysInMonth(int month,int year){
        if (month<1||month>12)return -1;
        if (year<1||year>9999)return -1;
        if (month<=7){
            if (month==2){
                if (isLeapYear(year))return 29;
                return 28;
            }
            if (month%2==0) return 30;
            else return 31;
        }else {
            if (month%2==0) return 31;
            return 30;
        }
    }
}