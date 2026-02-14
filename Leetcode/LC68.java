package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        if (words.length<=1){
            List<String>list=new ArrayList<>();
            list.add(words[0]);
            return list;
        }
         StringBuilder builder=new StringBuilder();
         String even="   ";
         String odd="  ";
         List<String>list=new ArrayList<>();
         for (String s:words){
             if (builder.length()+s.length()>=maxWidth){
                 builder.deleteCharAt(builder.length()-1);
                 list.add(builder.toString());
                 builder.setLength(0);
                 builder.append(s);
             }else {
                 builder.append(s);
             }
             builder.append(" ");
         }
         if (!builder.isEmpty()){
             builder.deleteCharAt(builder.length()-1);
             list.add(builder.toString());
         }
         return fullJustifyHelper(list,even,odd,maxWidth);
    }

    private static List<String> fullJustifyHelper(List<String> list, String even, String odd,int max) {
        if (list.isEmpty()){
            return new ArrayList<>();
        }
        for (int i = 0; i <list.size(); i++) {
            String s=list.get(i);
            if (s.length()==max){
                continue;
            }else {
                int n=max-s.length();
                if (n==1){
                    s=s.replace(" ",odd);
                    list.set(i,s);
                } else if (n % 2 == 0) {
                    int j=n/2;
                    while (j!=0){
                        s=s.replaceFirst(" ",even);
                        j--;
                    }
                    System.out.println(s.length());
                    list.set(i,s);
                }else {
                    int j=n/2;
                    while (j!=0){
                        s=s.replaceFirst(" ",even);
                        j--;
                    }
                    s=s.replace(" ",odd);
                    System.out.println(s.length());

                    list.set(i,s);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16));
    }
    /*if (builder.length()+s.length()>maxWidth){
                 if (builder.length()==maxWidth){
                     list.add(builder.toString());
                     builder.setLength(0);
                     continue;
                 }
                 int n=maxWidth-builder.length();
                 if (n==1){
                     String string=builder.toString().replace(" ",odd);
                     builder.setLength(0);
                     builder.append(string);
                 } else if (n % 2 == 0) {

                 }
             }else {

             }*/
}
