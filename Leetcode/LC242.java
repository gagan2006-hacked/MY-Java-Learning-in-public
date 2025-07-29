package com.Leetcode;
import java.util.HashMap;
import java.util.Hashtable;

public class LC242 {
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

    public static void main(String[] args) {
        System.out.println(isAnagram("gagan","gaagn"));
    }
}
