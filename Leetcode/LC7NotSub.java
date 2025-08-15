package com.Leetcode;

public class LC7NotSub {
//    brute force
    public int reverse(int x) {
        int a=x;
        boolean isNegative=a<0;
        if (isNegative){
            a=(a*-1);
            String s=""+a;
            StringBuffer string=new StringBuffer(s);
            string.reverse();
            s="-"+string.toString();
            return Integer.parseInt(s);
        }
        else {
            String s=""+a;
            StringBuffer stringBuffer=new StringBuffer(s);
            stringBuffer.reverse();
            return Integer.parseInt(stringBuffer.toString());
        }
    }
}
