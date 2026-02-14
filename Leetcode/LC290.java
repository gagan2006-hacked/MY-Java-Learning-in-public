package com.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC290 {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        // 1️⃣ Length check (mandatory)
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        // 2️⃣ Position-wise mapping
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // If mapping already exists, it must match
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                // Check reverse mapping to maintain bijection
                if (wordToChar.containsKey(word)) {
                    return false;
                }
                charToWord.put(c, word);
                wordToChar.put(word, c);
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
}
