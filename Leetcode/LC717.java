package com.Leetcode;

public class LC717 {
    public static boolean isOneBitCharacter(int[] bits) {
        if (bits.length<=1){
            return true;
        }
        for (int i = 0; i < bits.length-1; i++) {
            if (bits[i]==1){
                bits[i+1]=0;
            }
        }

        return bits[bits.length-2]!=1;
    }

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 0, 0, 0}));
    }
}
