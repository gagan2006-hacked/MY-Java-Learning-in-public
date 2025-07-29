package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC49 {
    public static List<List<String>> groupAnagrams(String[] str) {
        List<List<String>>lists=new ArrayList<>();
        List<String>minList=new ArrayList<>();
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"bat","cat","kat","ate","tea","eat"}));
    }
}
