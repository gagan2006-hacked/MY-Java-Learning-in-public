package com.Contests;

import java.util.HashMap;
import java.util.TreeMap;

public class LCBITCON {
    public static int getLeastFrequentDigit(int n) {
        StringBuilder b=new StringBuilder(""+n);
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i <b.length(); i++) {
            if (map.containsKey(b.charAt(i))){
                map.put(b.charAt(i), map.get(b.charAt(i))+1);
            }else {
                map.put(b.charAt(i),1);
            }
        }
        int num=Integer.MAX_VALUE;
        int number=1;
        for (int i = 0; i <b.length(); i++) {
            if (num > map.get(b.charAt(i) )){
                number=b.charAt(i)-'0';
                num=map.get(b.charAt(i));
            } else if (num==map.get(b.charAt(i))) {
                if (number>(b.charAt(i)-'0')){
                    number=b.charAt(i)-'0';
                }
            }
        }
        return number;
    }
    public int score(String[] cards, char x) {
        return 0;

    }

    public static void main(String[] args) {
//        System.out.println(getLeastFrequentDigit(723344511));
    }

}
