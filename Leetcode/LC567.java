package com.Leetcode;
import java.util.HashMap;

public class LC567 {
    
    public static boolean checkInclusion(String s1, String s2) {
        int s=s1.length();
        HashMap<Character,Integer>map=new HashMap<>();
        if (s>s2.length()){return false;}

        for (int i = 0; i <s1.length(); i++) {
            if(map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
            }else {
                map.put(s1.charAt(i),1);
            }
        }

        for (int i = 0; i <=s2.length() - s; i++) {
            if (map.containsKey(s2.charAt(i))&&check(new HashMap<>(map),s2.substring(i,i+s))){
                return true;
            }
        }

        return false;
    }

    private static boolean check(HashMap<Character, Integer> map, String substring) {
        for (char c : substring.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","ca"));
    }
}
