package com.Leetcode;

public class LC58 {
    public static int lengthOfLastWord(String s) {
        s=s.trim();
        int len=0;
        int e=s.length()-1;
        for (int i = s.length()-1; i >-1 ; i--) {
            if (s.charAt(i)==' '){
                len=e-(i+1)+1;
                break;
            }
        }
        if (len==0){
            return s.length();
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
}
