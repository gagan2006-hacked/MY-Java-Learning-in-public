package com.Leetcode;

public class LC1513 {
    public static int numSub(String s) {
        if (s.isBlank()){
            return 0;
        }
        long nOfSub=0;
        StringBuilder b=new StringBuilder();
        for(char c:s.toCharArray()){
            if (c=='1'){
                b.append(c);
            }else {
                if (!b.isEmpty()){
                    long n=b.length();
                    n=(n*(n+1))/2;
                    nOfSub+=n;
                }
                b.setLength(0);
            }
        }
        if (!b.isEmpty()){
            int n=b.length();
            n=(n*(n+1))/2;
            nOfSub+=n;
        }

        return (int)(nOfSub % 1_000_000_007);
    }

    public static void main(String[] args) {
        System.out.println(numSub("0110111"));
    }
}
