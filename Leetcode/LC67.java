package com.Leetcode;

public class LC67 {
    public static String addBinary(String a, String b) {
        boolean aIsBig=a.length()>b.length();
        if (aIsBig){
            int times=a.length()-b.length();
            b="0".repeat(times)+b;
        } else if (a.length()<b.length()) {
            int times=b.length()-a.length();
            a="0".repeat(times)+a;
        }
        char big[]=a.toCharArray();
        char small[]=b.toCharArray();
        int carry=0;
        int bigInd= big.length-1;
        StringBuilder builder=new StringBuilder();
        for (int i = small.length-1; i>-1; i--) {
            int num1=big[bigInd]-'0';
            int num2=small[i]-'0';
            int sum=num1+num2+carry;
            if (sum>1){
                String string=Integer.toBinaryString(sum);
                builder.insert(0,string.charAt(1));
                carry=string.charAt(0)-'0';
            }else {
                builder.insert(0,sum);
                carry=0;
            }
            bigInd--;
        }
        if (carry>0){
         builder.insert(0,carry);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }
}
