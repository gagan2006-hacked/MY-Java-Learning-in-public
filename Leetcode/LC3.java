package com.Leetcode;


import java.util.HashSet;
import java.util.Set;

public class LC3 {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();  // keeps current non-repeating characters
        int left = 0;  // left side of the window
        int right = 0; // right side of the window
        int maxLen = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (!seen.contains(ch)) {
                seen.add(ch);  // add to window
                maxLen = Math.max(maxLen, right - left + 1);
                right++;  // expand window
            } else {
                seen.remove(s.charAt(left));  // shrink window from the left
                left++;
            }
        }

        return maxLen;
    }





    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcab"));
    }
}
