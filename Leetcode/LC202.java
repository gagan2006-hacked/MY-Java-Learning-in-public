package com.Leetcode;

public class LC202 {
    public static boolean isHappy(int n) {
        long s=getTheNumberSquare(n);
        long f=getTheNumberSquare(getTheNumberSquare(n));
        while (f!=1 && s!=1 && f!=s){
            s=getTheNumberSquare(s);
            f=getTheNumberSquare(getTheNumberSquare(f));
        }
        if (f==1){
            return true;
        } else if (s==1) {
            return true;
        }
        return false;
    }
    public static long getTheNumberSquare(long n){
        long val=0;
        while (n!=0){
            long dig=n%10;
            val+=(long) (Math.pow(dig,2));
            n/=10;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
