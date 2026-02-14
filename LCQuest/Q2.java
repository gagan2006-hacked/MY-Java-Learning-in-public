package com.LCQuest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q2 {
    public static List<String> buildArray(int[] target, int n) {
        Stack<Integer>stack=new Stack<>();
        List<String>list=new ArrayList<>();
        int i=1;
        int index=0;
        while (index<target.length){
            if (target[index]==i){
                stack.push(i);
                list.add("Push");
                i++;
            }else {
                int diff=target[index]-i;
                while (diff!=0){
                    list.add("Push");
                    list.add("Pop");
                    diff--;
                    i++;
                }
                continue;
            }
            index++;
        }
        return list;
    }


    public static void main(String[] args) {
//        System.out.println(buildArray(new int[]{1,3},3));
//        System.out.println(isNumber("-20"));
    }
    public int evalRPN(String[] tokens) {
        StringBuilder b=new StringBuilder();
        for (String t:tokens){
            b.append(t).append(" ");
        }
        return evaluatePostfix(b.toString());
    }

    public static int evaluatePostfix(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // Skip spaces
            if (ch == ' ') continue;

            // If it's a number (including multi-digit and negative)
            if (Character.isDigit(ch) ||
                    (ch == '-' && i + 1 < n && Character.isDigit(s.charAt(i + 1)))) {

                int sign = 1;

                if (ch == '-') {
                    sign = -1;
                    i++;
                }

                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }

                i--; // step back because for loop increases i
                st.push(num * sign);
            }

            else { // Operator
                int b = st.pop();
                int a = st.pop();

                switch (ch) {
                    case '+': st.push(a + b); break;
                    case '-': st.push(a - b); break;
                    case '*': st.push(a * b); break;
                    case '/': st.push(a / b); break;
                }
            }
        }
        return st.pop();
    }


    /*
    public static int calculate(String s) {
        s=s.replaceAll("\\s","");
//        System.out.println(post);
        List<Integer> list=new ArrayList<>();
        boolean flag=false;
        for (char ch:s.toCharArray()){
            if (ch=='+'||ch=='-'||ch=='*'||ch=='/'){
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
            return Integer.parseInt(s);
        }
        return list.getFirst();
    }*/



}
