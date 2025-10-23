package com.Leetcode;

import java.util.Map;
import java.util.Stack;

public class LC32 {
    public static int longestValidParentheses(String s) {
        if (s.length()<=1){
            return 0;
        }
        Stack<Character>stack=new Stack<>();
        int val=0;
        StringBuffer buffer=new StringBuffer();
        for (int i = 0; i <s.length(); i++) {
            char c=s.charAt(i);
            if (c==')'){
                if (stack.isEmpty()){
                    stack.push(c);
                    continue;
                }
                char top=stack.peek();
                if (top=='('){
                    buffer.append(top).append(")");
                    stack.pop();
                    val= Math.max(val,buffer.length());
                }else {
                    buffer.delete(0,buffer.length());
                }

            }else {
                stack.push(c);
            }
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }
}
