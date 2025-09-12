package com.Leetcode;

public class LC342 {
    /*public static boolean isPowerOfFour(int n) {
        if (n<=0){
            return false;
        }
        if (n%2==1){
            return n==1;
        }
        long nNEW=n;
        int count=0;
        if (isPowerOfTwo(n)) {
            while (nNEW != 0) {
                System.out.println(Integer.toBinaryString((int) nNEW));
                if ((nNEW & 1) == 1) {
                    count++;
                }
                if (count > 1) {
                    break;
                }
                nNEW = nNEW >> 2;
            }
        }
        return count==1;
    }
    public static boolean isPowerOfTwo(int n) {
        long new_N=n;
        if (new_N<0){return false;
        }
        int count=0;
        int power=-1;
        while (new_N!=0){
            if ((new_N&1)==1){
                count++;
            }
            if (count>1){
                break;
            }
            new_N=new_N>>1;
            power++;
        }
        return count==1;
    }*/
    public static boolean isPowerOfFour(int n) {
        // must be positive
        if (n <= 0) return false;
        // must be a power of two: only one bit set
        if ((n & (n - 1)) != 0) return false;
        // that one bit must be in an even position
        return (n & 0x55555555) != 0;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfFour(6));
    }
}
