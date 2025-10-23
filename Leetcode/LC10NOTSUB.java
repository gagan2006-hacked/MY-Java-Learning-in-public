package com.Leetcode;

public class LC10NOTSUB {
    public static boolean isMatch(String s, String p) {
        if (s.length()!=p.length()){
            return false;
        }
        String help="";
        int i=0;
        while (i<s.length()){
            char ch=p.charAt(i);
            if (ch=='*'||ch=='.'){
                if (ch=='*'){
                    if (!(help.contains(String.valueOf(s.charAt(i)))||help.contains(String.valueOf('.')))){
                        return false;
                    }
                }
            }else {
                if (ch!=s.charAt(i)){
                    return false;
                }
            }
            help+=p.charAt(i);
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aabbc","aa..*"));
    }
}
