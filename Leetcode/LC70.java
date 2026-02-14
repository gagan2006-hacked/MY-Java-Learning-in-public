package com.Leetcode;

public class LC70 {
    static int []dp =new int [45];
    public static int climbStairs(int n) {
        if (dp[n-1]!=0)return dp[n-1];
        if (n==1 || n==2){
            dp[n-1]=n;
            return n;
        }
        dp[n-1]=climbStairs(n-1)+climbStairs(n-2);
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(37));
    }
}
