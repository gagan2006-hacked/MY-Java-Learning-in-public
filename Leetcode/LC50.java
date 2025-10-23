package com.Leetcode;

public class LC50 {
    /*
    public double myPow(double x, int n) {
        if (n>0){
            return positivePower(x,n);
        }
        if (n<0){
            return negativePower(x,n);
        }
        return 0;
    }
    private double positivePower(double x,int p){
        if (p==1){
            return x;
        }
        return x*positivePower(x,p-1);
    }
    private double negativePower(double x,int p){
        if (p==-1){
            return 1/x;
        }
        return (1/x)*negativePower(x,p+1);
    }*/
    public static double myPow(double x, int n) {
        long newN=n;
        if (n<0){
            x=1/x;
            newN=-newN;
        }
        if (n==0){
            return 1;
        }
        return halfPower(x,newN);
    }

    private static double halfPower(double x, long newN) {
        if (newN==1){
            return x;
        }
        double half=halfPower(x,newN/2);
        if (newN%2==0){
            return half*half;
        }
        return half*half*x;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000,-2147483648));
    }
}
