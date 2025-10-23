package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1935 {
    public static int canBeTypedWords(String text, String brokenLetters) {
        char []arr=brokenLetters.toCharArray();
        List<String>list=new ArrayList<>(Arrays.asList(text.split(" ")));
        for (char c:arr){
            list.removeIf(s -> s.contains(c + ""));
        }
        return list.size();
    }

    public static void main(String[] args) {
//        System.out.println(canBeTypedWords("leet code","e"));

    }
}
