package com.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC13 {
    /*HashMap<String,Integer>map=new HashMap<>();
    public int romanToInt(String s) {
        if (map.isEmpty()) {
            setUp();
        }
        int roman=0;
        int i=0;
        while (i<s.length()){
            char ch=s.charAt(i);
            if (ch=='I'){
                if (i<s.length()-1&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')){
                    roman+= map.get(""+ch+s.charAt(i+1));
                    i=i+2;
                    continue;
                }
                roman+=map.get(""+ch);
            } else if (ch=='V'){
                if (i<s.length()-1&&(s.charAt(i+1)=='I')){
                    roman+= map.get(""+ch+s.charAt(i+1));
                    i=i+2;
                    continue;
                }
                roman+=map.get(""+ch);
            } else if (ch=='X') {
                if (i<s.length()-1&&(s.charAt(i+1)=='I'||s.charAt(i+1)=='L'||s.charAt(i+1)=='C')){
                    roman+= map.get(""+ch+s.charAt(i+1));
                    i=i+2;
                    continue;
                }
                roman+=map.get(""+ch);
            } else if (ch=='L') {
                if (i<s.length()-1&&(s.charAt(i+1)=='X')){
                    roman+= map.get(""+ch+s.charAt(i+1));
                    i=i+2;
                    continue;
                }
                roman+=map.get(""+ch);
            } else if (ch == 'C') {
                if (i<s.length()-1&&(s.charAt(i+1)=='X'||s.charAt(i+1)=='D'||s.charAt(i+1)=='M')){
                    roman+= map.get(""+ch+s.charAt(i+1));
                    i=i+2;
                    continue;
                }
                roman+=map.get(""+ch);
            } else if (ch == 'D') {
                if (i<s.length()-1&&(s.charAt(i+1)=='C')){
                    roman+= map.get(""+ch+s.charAt(i+1));
                    i=i+2;
                    continue;
                }
                roman+=map.get(""+ch);
            }else {
                roman+=map.get(""+ch);
            }
            i++;
        }
        return roman;
    }
*//*
* IF I Check next is V OR X
* IF V check next is I
* IF X check next is I or L or C
* IF L check next is X
* IF C check next is X or D or M
* IF D check next is C
* *//*

    *//*
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
*//*
    private void setUp() {
        map.put("I",1);

        map.put("IV",4);

        map.put("V",5);

        map.put("VI",6);

        map.put("IX",9);

        map.put("X",10);

        map.put("XI",11);

        map.put("XL",40);

        map.put("L",50);

        map.put("LX",60);

        map.put("XC",90);

        map.put("C",100);

        map.put("CX",110);

        map.put("CD",400);

        map.put("D",500);

        map.put("DC",600);

        map.put("CM",900);

        map.put("M",1000);
    }*/

    private static final Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            int nexxt=0;
            if (i < s.length() - 1){
            nexxt=map.get(s.charAt(i + 1));
            }
            if ( curr <nexxt) {
                total -= curr;  // Subtractive case
            } else {
                total += curr;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        LC13 lc13=new LC13();
        System.out.println(lc13.romanToInt("MDCCCLXXXIV"));
    }
}
