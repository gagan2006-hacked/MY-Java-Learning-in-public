package com.Leetcode;

import java.util.Stack;

public class LC20 {
    public boolean isValid(String s) {
        if (s.isBlank()){
            return true;
        }
        Stack<Character>stack=new Stack<>();
        for(char c:s.toCharArray()){
            if (c=='('||c=='['||c=='{'){
                stack.push(c);
            }else {
                if (c==')'){
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek()=='('){
                        stack.pop();
                    }else {
                         return false;
                    }
                } else if (c==']') {
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek()=='['){
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }else if (c=='}'){
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek()=='{'){
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
