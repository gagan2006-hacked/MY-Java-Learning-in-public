package com.Leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC271 {
    public static String encode(List<String> strs) {
        if (strs.isEmpty()){
            return Character.toString((char) 258);
        }
        String string=Character.toString((char) 257);
        StringBuilder builder=new StringBuilder();
        for (String s:strs){
            builder.append(s).append(string);
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

    public static List<String> decode(String str) {
       if (str.equals(Character.toString((char) 258))){
           return new ArrayList<>();
       }
        String string=Character.toString((char) 257);
       return Arrays.asList(str.split(string));
    }

    public static void main(String[] args) {
        String v=encode(Arrays.asList("hhkd","ndfk","fdkb","",null));
        System.out.println(v);
        System.out.println(decode(v));
    }
}
