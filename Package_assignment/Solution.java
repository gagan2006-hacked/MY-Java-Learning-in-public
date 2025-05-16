package com.Package_assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
  /*  public  static int lengthOfLongestSubstring(String s) {
        ArrayList<Character> list=new ArrayList<>(s.length());
        String subset="";
        int j = 0;
        for (int i=0;i<s.length();i++){
            if (!list.contains(s.charAt(i))){
                list.add(s.charAt(i));
            } else if (list.contains(s.charAt(i))&&(i==s.length()-1)) {
                return list.size();

            } else {
                list.removeAll(list);
                list.add(s.charAt(i));
                j++;
            }
        }
        System.out.println(subset);

        return list.size();
    }*/

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring1(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int i = 0, j = 0;

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxLength;
    }
    public static int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(left, lastIndex[c]);
            maxLength = Math.max(maxLength, right - left + 1);
            lastIndex[c] = right + 1;
        }

        return maxLength;
    }

}