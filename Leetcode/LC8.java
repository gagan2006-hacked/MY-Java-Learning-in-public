package com.Leetcode;

import javax.sound.midi.MidiFileFormat;

public class LC8 {
    /*public static int myAtoi(String s) {
        StringBuilder zeros=new StringBuilder();
        StringBuilder number=new StringBuilder();
        char sign='0';
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (c==' '&& (number.isEmpty() && zeros.isEmpty())&&sign=='0'){
                continue;
            }
            if (Character.isDigit(c)){
                if (number.isEmpty()&&c=='0'){
                    zeros.append(0);
                }
                else {
                    number.append(c);
                }
            } else if (c == '-' || c == '+') {
                if (number.isEmpty()&& zeros.isEmpty()&&(sign=='0')){
                    sign=c;
                }
                else {
                    break;
                }
            }else {
                break;
            }
        }
        if (number.isEmpty()){
            return 0;
        }
        try{
            int i=Integer.parseInt(sign+number.toString());
            return i;
        } catch (NumberFormatException numberFormatException) {
            if (sign=='-')return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
    }*/
    public static int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        long result = 0;

        // 1. Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Handle optional sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

            // 4. Handle overflow
            if (sign == 1 && result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && -result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-9101010"));
        System.out.println(Integer.parseInt("+0082"));
    }
}
