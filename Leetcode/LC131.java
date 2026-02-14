package com.Leetcode;

import com.company.Assignments;

import java.util.ArrayList;
import java.util.List;

public class LC131 {
    /*public static List<List<String>> partition(String s) {
        List<String>list=helper(s,"");
        List<List<String>>result=new ArrayList<>();
        for (int i = 0; i <list.size(); i++) {
            String []string=list.get(i).split(",");
            List<String>l=new ArrayList<>();
            for (String s1:string){
                if (!s1.isBlank()){
                    l.add(s1);
                }
            }
            result.add(l);
        }
        return result;
    }

    public static List<String> helper(String s,String build){
        if (s.length()<=1){
            List<String>list=new ArrayList<>();
            list.add(build+s);
            return list;
        }
        List<String>list=new ArrayList<>();

        int i=0;
        while (i<s.length()){
            if (palindrome(s.substring(0,i+1)))
                list.addAll(helper(s.substring(i+1), build + s.substring(0, i+1) + ","));
            i++;
        }
        return list;
    }
    public static boolean palindrome(String og){
        return og.equalsIgnoreCase(new StringBuilder(og).reverse().toString());
    }*/

    public static void main(String[] args) {
//        System.out.println(partition("aaba"));
    }

    /*public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(s, 0, path, result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        // If start reached the end → we found a valid partition
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Try all possible substrings from start to end
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));  // choose
                backtrack(s, end + 1, path, result);    // explore
                path.remove(path.size() - 1);           // un-choose
            }
        }
    }

    // Efficient palindrome check using indices
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }*/

}
