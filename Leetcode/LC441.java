package com.Leetcode;

public class LC441 {
    public static int arrangeCoins(int n) {
        if (n==1){
            return 1;
        }
        long s=1;
        long e=n;
        while (s <= e) {
            long mid = s + (e - s) / 2;
            long sum = mid * (mid + 1) / 2;
            if (sum == n) {
                return (int) mid;
            }
            if (sum < n) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return (int) s;
    }
   /*  time complex is not good
   public static  int findRow(int n,int i,int row){
        if (n==0){
            return row;
        }
        if (n<0){
            return row-1;
        }
        row=findRow(n-i,i+1,row+1);
        return row;
    }*/

    public static void main(String[] args) {
//        System.out.println(findRow(5,1,0));
        System.out.println(arrangeCoins(2));
    }
}
