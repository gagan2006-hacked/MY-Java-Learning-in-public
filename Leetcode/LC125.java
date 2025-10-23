package com.Leetcode;

public class LC125 {
    public boolean isPalindrome(String og) {
        if (og.length()<=1){
//            System.out.println(true);
            return true;
        }
        og=og.toLowerCase();
        og = og.replaceAll("[^a-z0-9]", "");
//        System.out.println(og);
        int i=0;
        int j=og.length()-1;
        while (i<j){
            if (og.charAt(i)!=og.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {


    }
}
