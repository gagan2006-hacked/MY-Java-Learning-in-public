package com.Leetcode;

import java.util.Stack;

public class LC394 {
    public  String decodeString(String s) {
        return decodeStringHelper(s);
    }
     int start=0;
//    "3[a]2[bc]"

    private  String decodeStringHelper(String s) {
        if (start==s.length()){
            return "";
        }
        int pre=0;
        int i=start;
        Stack<Character> stack=new Stack<>();
//    "3[a]2[bc]"
        StringBuilder string=new StringBuilder();
        StringBuilder main=new StringBuilder();
        while (i<s.length()){
            char c=s.charAt(i);
            if (Character.isDigit(c)){
                if (stack.isEmpty()){
                    pre = pre * 10 + (c - '0');
                }else {
                    string.append(decodeStringHelper(s));
                    i=start;
                    continue;
                }
            }
            else if (c=='[') {
                if (!string.isEmpty()){
                    main.append(string);
                    string.setLength(0);
                }
                stack.push(s.charAt(i));
            }
            else if (c==']') {
                if (stack.isEmpty()){
                    return main.append(string).toString();
                }else {
                    if (stack.peek()=='['){
                        stack.pop();
                        makeTheSt(pre,main,string.toString());
                        string.setLength(0);
                        pre=0;
                    }
                }
            }
            else {
                string.append(c);
            }
            i++;
            start++;
        }
        if (!string.isEmpty()){
            main.append(string);
        }
        return main.toString();
    }

    private  void makeTheSt(int pre,StringBuilder main, String string) {
        if (string.isBlank()){
            return;
        }
        main.append(string.repeat(pre));
    }

    public static void main(String[] args) {
        System.out.println(new LC394().decodeString("10[leetcode]"));
    }
}
