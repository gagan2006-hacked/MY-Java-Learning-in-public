package com.Leetcode;

import java.util.Arrays;
import java.util.List;

public class LC14 {
    public static String longestCommonPrefix(String[] strs) {
        List<String>list= Arrays.asList(strs);
        StringBuilder b=new StringBuilder();
        String s=list.get(0);
        if (s.isBlank()){
            return s;
        }
        for (int i = 0; i <s.length(); i++) {
            String sub=s.substring(0,i+1);
            for (int j = 0; j <list.size(); j++) {
                if (!list.get(j).startsWith(sub)){
                    return b.toString();
                }
            }
            if (!b.isEmpty()){
                b.delete(0,i);
            }
            b.append(sub);
        }
        return b.toString();
    }
   public static void main(String[] args) {
       System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
   }
}
