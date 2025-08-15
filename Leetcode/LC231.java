package com.Leetcode;

import java.math.BigInteger;

public class LC231 {
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
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-16));
        int n=-16;
    }
}
