package com.Leetcode;

public class LC1323 {
    public static int maximum69Number (int num) {
        StringBuffer s=new StringBuffer(""+num);
        int i=0;
        while (i<s.length()){
            if (s.charAt(i)=='6'){
                s.replace(i,i+1,"9");
                break;
            }
            i++;
        }
       return Integer.parseInt(s.toString());
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number(966996));

    }
}
