package com.Leetcode;

import com.company.Recurrsion;

import java.util.Locale;

public class LC5 {
    public static void main(String[] args) {
        String s="wagds";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
//        return helper(s);
        String v="";
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if (!v.isEmpty()){
                if (v.length()>=s.length()){
                    return v;
                }
            }
            if (s.charAt(start)==s.charAt(end)){
                if(isPalin(start, end, s) && (end - start + 1) > v.length()){
                    v=s.substring(start,end+1);
                }
            }
            if (end==start+1){
                start=start+1;
                end=s.length()-1;
                continue;
            }
            end--;
        }
        return v;
    }

    private static boolean isPalin(int start, int end, String s) {
        while (start<end){
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
   /* public static String helper(String s){
        if (s.length()==1){
            return s;
        }
        int start=0;
        int end=s.length()-1;
        String v=""+s.charAt(0);
        int vValue=0;
        while (start<end){
            if (v.length()>=s.length()){
                return v;
            }
            if (s.charAt(start)==s.charAt(end)){
                if (Recurrsion.palindrome(s.substring(start,end+1))){
                    if (v.length()<s.substring(start,end).length()){
                        v=s.substring(start,end+1);
                    }
                }
            }
            if (start==end-1) {
                start=start+1;
                end=s.length();
            }
            end--;
        }
        return v;
    }*/
}
