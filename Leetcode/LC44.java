package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC44 {
    /*public static boolean isMatch(String s, String p) {
        if (p.isEmpty())return s.isEmpty();
        if (p.length()==1){
            if (p.charAt(0)=='*'){
                return true;
            } else if (p.charAt(0)=='?'&&s.length()==1) {
                return true;
            }
            else {
                return p.length()==s.length()&&p.charAt(0)==s.charAt(0);
            }
        }
        int i=0;
        int j=0;
        int n=s.length();
        int m=p.length();
        while (i<n&&j<m){
            char sh=s.charAt(i);
            char ph=p.charAt(j);
            if (ph=='*'){
                int len=m-(j+1);
                i=n-len;
                j++;
            } else if (ph!='?') {
                if (sh==ph){
                    i++;
                    j++;
                }else {
                    return false;
                }
            }else {
                i++;
                j++;
            }
        }
        return i==n&&j==m;
    }*/

    public static void main(String[] args) {
        /*List<String>list=new ArrayList<>();
        list.add("*aa");
        list.add("a*aa");
        list.add("a**a");
        list.add("a*");
        list.add("a**");
        list.add("aa*");
        list.add("*");
        for (String s:list){
            System.out.println(s+" -> "+isMatch("aaafaa",s));
        }*/
        System.out.println(isMatch("adceb","*a*b"));
    }

    public static boolean isMatch(String s, String p) {
        int i = 0;        // pointer for s
        int j = 0;        // pointer for p
        int star = -1;    // last position of '*' in p
        int match = 0;   // position in s when last '*' was found

        while (i < s.length()) {

            // Case 1: characters match or '?'
            if (j < p.length() &&
                    (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            }

            // Case 2: '*' found
            else if (j < p.length() && p.charAt(j) == '*') {
                star = j;        // remember position of '*'
                match = i;       // remember position in s
                j++;             // move pattern pointer
            }

            // Case 3: mismatch but we saw a '*' before
            else if (star != -1) {
                j = star + 1;    // retry after '*'
                match++;         // let '*' consume one more char
                i = match;
            }

            // Case 4: mismatch and no '*'
            else {
                return false;
            }
        }

        // skip remaining '*' in pattern
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }

}
