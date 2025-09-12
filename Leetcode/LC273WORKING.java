package com.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
public class LC273WORKING {
    HashMap<Integer,String> words=new HashMap<>();
    HashSet<Integer> exp=new HashSet<>();
    public String numberToWords(int num) {
        setUp();
        if (num==0){
            return " zero ";
        }
        StringBuilder b=new StringBuilder();
        StringBuilder it=new StringBuilder(""+num);

        int n=num;
        while (!it.isEmpty()){
            int pow=it.length()-1;
            int ch=it.charAt(0)-'0';
            if (ch==0){
                it.deleteCharAt(0);
                continue;
            }
            if (exp.contains(pow)){
                int nch=it.charAt(1)-'0';
                if (ch==1){
                    if (nch==0){
                        b.append(words.get((int)Math.pow(10,pow)));
                    }else {
                        b.append(words.get(ch*10+nch));
                        if (pow-1>1) {
                            b.append(words.get((int) Math.pow(10, pow - 1)));
                        }
                    }
                }
                else {
                    b.append(words.get(ch*10));
                    if (nch!=0){
                        b.append(words.get(nch));
                    }
                    if (pow-1>1) {
                        b.append(words.get((int) Math.pow(10, pow - 1)));
                    }
                }
                it.deleteCharAt(0);
                it.deleteCharAt(0);
            }
            else {
                b.append(words.get(ch));
                if (pow>0){
                    b.append(words.get((int)Math.pow(10,pow)));
                }
                it.deleteCharAt(0);
            }
        }
        return b.toString().trim();
    }
    private void setUp(){
        words.put(1,"One ");
        words.put(2,"Two ");
        words.put(3,"Three ");
        words.put(4,"Four ");
        words.put(5,"Five ");
        words.put(6,"Six ");
        words.put(7,"Seven ");
        words.put(8,"Eight ");
        words.put(9,"Nine ");
        words.put(0,"Zero ");
        words.put(11,"Eleven ");
        words.put(12,"Twelve ");
        words.put(13,"Thirteen ");
        words.put(14,"Fourteen ");
        words.put(15,"Fifteen ");
        words.put(16,"Sixteen ");
        words.put(17,"Seventeen ");
        words.put(18,"Eighteen ");
        words.put(19,"Nineteen ");
        words.put(20,"Twenty ");
        words.put(30,"Thirty ");
        words.put(40,"Forty ");
        words.put(50,"Fifty ");
        words.put(60,"Sixty ");
        words.put(70,"Seventy ");
        words.put(80,"Eighty ");
        words.put(90,"Ninty ");
        words.put(100,"Hundred ");
        words.put(1000,"Thousand ");
        words.put(10000,"Ten Thousand ");
        words.put(100000,"Hundred Thousand ");
        words.put(1000000,"Million ");
        words.put(10000000,"Ten Million ");
        words.put(100000000,"Hundred Million ");
        words.put(1000000000,"Billion ");

        exp.add(1);
        exp.add(7);
        exp.add(4);
        exp.add(10);
    }

    public static void main(String[] args) {
        LC273WORKING l=new LC273WORKING();
        System.out.println(l.numberToWords(123));
    }
}
