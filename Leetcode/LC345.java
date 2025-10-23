package com.Leetcode;

import java.util.HashSet;

public class LC345 {
    public static String reverseVowels(String s) {
        if (s.length()<2){
            return s;
        }
        int st=0,end =s.length()-1;
        HashSet<Character>set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char []arr=s.toCharArray();
        while (st<end){
            char en=s.toLowerCase().charAt(end);
            char sn=s.toLowerCase().charAt(st);
            if (set.contains(sn) && set.contains(en)) {
                char temp = arr[st];
                arr[st] = arr[end];
                arr[end] = temp;
                st++;
                end--;
            } else {
                if (!set.contains(sn)) st++;
                if (!set.contains(en)) end--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }
}
