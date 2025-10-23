package com.Leetcode;

public class LC1768 {
    public String mergeAlternately(String word1, String word2) {
        char[]chars1=word1.toCharArray();
        char[]chars2=word2.toCharArray();
        int i=0;
        int j=0;
        StringBuffer buffer=new StringBuffer();
        boolean first=true;
        while (i<chars1.length&&j<chars2.length){
            if (first){
                buffer.append(chars1[i]);
                i++;
                first=false;
            }else {
                buffer.append(chars2[j]);
                j++;
                first=true;
            }
        }
        while (i<chars1.length){
            buffer.append(chars1[i]);
            i++;
        }
        while (j<chars2.length){
            buffer.append(chars2[j]);
            j++;
        }
        return buffer.toString();
    }
}
