package com.Leetcode;

import java.util.*;

public class LC140 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String>set=new HashSet<>(wordDict);
        return words(s,set,"");
    }
    private static List<String> words(String s, Set<String> set,String total){
        List<String>list=new ArrayList<>();
        if (s.isBlank()){
            list.add(total.substring(0,total.length()-1));
            return list;
        }
        for (int i = 0; i <s.length(); i++) {
            String sub=s.substring(0,i+1);
            if (set.contains(sub)){
                sub+=" ";
                list.addAll(words(s.substring(i+1),set,total+sub));
            }
        }

        return list;
    }

    public static void main(String[] args) {
//        System.out.println("1133324".substring(3));
        List<String>list= Arrays.asList("cats","dog","sand","and","cat");
        System.out.println(wordBreak("catsandog",list));
    }
//    ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//    [pine apple pen apple, pine applepen apple, pineapple pen apple]
}
