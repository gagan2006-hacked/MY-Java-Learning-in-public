package com.Leetcode;

import java.util.Stack;

public class LC224 {
    public static int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int num = 0;
        int n = s.length();
        int sign = 1;
        nums.push(0); // Handle leading '-'

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+' || ch == '-') {
                nums.push(sign * num);
                num = 0;
                sign = (ch == '+') ? 1 : -1;
            } else if (ch == '(') {
                nums.push(sign);
                ops.push('(');
                sign = 1;
            } else if (ch == ')') {
                nums.push(sign * num);
                num = 0;
                int sum = 0;
                while (!ops.isEmpty() && ops.peek() != '(') {
                    sum += nums.pop();
                    ops.pop();
                }
                if (!ops.isEmpty() && ops.peek() == '(') {
                    ops.pop();
                    sum *= nums.pop(); // multiply with sign before '('
                }
                nums.push(sum);
            }
        }

        nums.push(sign * num);

        int result = 0;
        while (!nums.isEmpty()) {
            result += nums.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("5+(899*32+4893)*23/432")); // Output: 6
    }
}

//
