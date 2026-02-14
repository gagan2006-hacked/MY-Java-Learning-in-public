package com.Leetcode;

import java.util.*;

public class LC49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Map to store sorted string → list of words
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch); // O(K log K)
            String key = new String(ch); // same for anagrams

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
/*class Solution {
        public static List<List<String>> groupAnagrams(String[] str) {
            List<List<String>>lists=new ArrayList<>();
            HashSet<String>set=new HashSet<>();
            for (int i = 0; i < str.length; i++) {
                if (!set.contains(str[i])) {
                    List<String>list=new ArrayList<>();
                    for (int j = 0; j < str.length; j++) {
                        if (j != i && isAnagram(str[i], str[j])) {
                            set.add(str[j]);
                            list.add((str[j]));
                        }
                    }
                    set.add(str[i]);
                    list.add(str[i]);
                    lists.add(new ArrayList<>(list));
                }
            }
            return lists;
        }

        public static boolean isAnagram(String s, String t) {
            HashMap<Character, Integer> set=new HashMap<>();
            if (s.length()==t.length()) {
                for (int i = 0; i <s.length(); i++) {
                    if (set.containsKey(s.charAt(i))){
                        set.put(s.charAt(i),set.get(s.charAt(i))+1);
                    }else {
                        set.put(s.charAt(i),1);
                    }
                }
                for (int i = 0; i <t.length(); i++) {
                    if (set.containsKey(t.charAt(i))){
                        int count=set.get(t.charAt(i));
                        if (count>0){
                            set.put(t.charAt(i),set.get(t.charAt(i))-1);
                            if (count==1){
                                set.remove(t.charAt(i));
                            }
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }*/
