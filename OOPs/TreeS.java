package com.OOPs;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TreeS {
    public static void main(String[] args) {
        TreeSet<String >strings=new TreeSet<>();
        strings.add("sa");
        strings.add("ka");
        strings.add("da");
        print(strings,'s','k','c','s');
    }
    public static void print(TreeSet<String> ts,char a,char b,char c,char d){
        System.out.println(ts.headSet(a+""));
        System.out.println(ts.tailSet(b+""));
        System.out.println(ts.subSet(c+"",d+""));
    }
}
