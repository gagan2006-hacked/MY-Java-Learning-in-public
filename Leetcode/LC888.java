package com.Leetcode;

import java.util.HashSet;

public class LC888 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int pointer=0;
        int aliceNumber=-1;
        int bobNumber=-1;
        int aliceSum=0;
        int bobSum=0;
        HashSet<Integer>alice=new HashSet<>();
        HashSet<Integer>bob=new HashSet<>();
        for (int ele:aliceSizes){
            aliceSum+=ele;
            alice.add(ele);
        }
        for (int ele:bobSizes){
            bobSum+=ele;
            bob.add(ele);
        }
        if (alice.size()==1 && bob.size()==1){
            return new int[]{aliceSizes[0],bobSizes[0]};
        }
        int delta = (aliceSum - bobSum) / 2;
        for (int a : aliceSizes) {
            int b = a - delta;
            if (bob.contains(b)) {
                return new int[]{a, b};
            }
        }
        return new int[]{-1,-1};
    }
}
