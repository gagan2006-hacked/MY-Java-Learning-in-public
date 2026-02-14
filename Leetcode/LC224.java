package com.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC224 {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1; // 1 means '+', -1 means '-'
        s=s.replaceAll("\\s","");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                // Push the current result and sign onto the stack
                stack.push(result);
                stack.push(sign);
                // Reset for the new sub-expression
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop(); // Pop the sign before '('
                result += stack.pop(); // Pop the result before '('
            }
        }

        // Add the last number
        result += sign * num;

        return result;
    }


   /* public static int calculate(String s) {
        s=s.replaceAll("\\s","");
        StringBuilder post=new StringBuilder(postfix(s));
//        System.out.println(post);
        List<Integer> list=new ArrayList<>();
        String []arr=post.toString().split("\\|");
        return 0;
    }
    private static String postfix(String s){
        Stack<Character> stack=new Stack<>();
        StringBuilder builder=new StringBuilder();
        for (char ch:s.toCharArray()){
            if (ch=='('||ch==')'){
                continue;
            }
            if (ch=='+'||ch=='-'){
                builder.append("|");
                if (stack.isEmpty()){
                    stack.push(ch);
                }else {
                    builder.append("|");
                    builder.append(stack.pop());
                    stack.push(ch);
                }
            }else {
                builder.append(ch);
            }
        }
        if (!stack.isEmpty()){
            while (!stack.isEmpty()){
                builder.append("|");
                builder.append(stack.pop());
            }
        }
        return builder.toString();
    }*/

    public static void main(String[] args) {
        System.out.println(calculate(" (1 + (2 - (3 + (4 - (5 + 6)))) + 7) ")); // Output: 6
    }
}
//
