package com.Leetcode;

public class LC392 {
    public boolean isSubsequence(String s, String t) {
        if (s.isBlank()){
            return true;
        }
        int i=0;
        for (int j = 0; j <t.length(); j++) {
            if (t.charAt(j)==s.charAt(i)){
                i++;
            }
        }
        return s.length()==i;
    }
}
