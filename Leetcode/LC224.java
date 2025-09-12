package com.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC224 {
    public static int calculate(String s) {
        s=s.replaceAll("\\s","");
        StringBuilder post=new StringBuilder(postfix(s));
//        System.out.println(post);
        List<Integer> list=new ArrayList<>();
        boolean flag=false;
        for (char ch:post.toString().toCharArray()){
            if (ch=='+'||ch=='-'){
                if (list.size()>=2){
                    int sec=list.removeLast();
                    int f=list.removeLast();

                    if (ch=='+'){
                        list.addLast(f+sec);
                    }else {
                        sec=sec*-1;
                        list.addLast(f+sec);
                    }
                    flag=true;
                }
            }else {
             list.addLast(ch-'0');
            }
        }
        if (!flag){
            return Integer.parseInt(post.toString());
        }
        return list.getFirst();
    }
    private static String postfix(String s){
        Stack<Character> stack=new Stack<>();
        StringBuilder builder=new StringBuilder();
        for (char ch:s.toCharArray()){
            if (ch=='('||ch==')'){
                continue;
            }
            if (ch=='+'||ch=='-'){
                if (stack.isEmpty()){
                    stack.push(ch);
                }else {
                    builder.append(stack.pop());
                    stack.push(ch);
                }
            }else {
                builder.append(ch);
            }
        }
        if (!stack.isEmpty()){
            while (!stack.isEmpty()){
                builder.append(stack.pop());
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(calculate("2-1 +2"));
    }
}
