package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenarateParaentheisi {
    public static List<String> genpara(int n) {
        StringBuilder value = new StringBuilder();
        List<String> list=new ArrayList<>();
        genparaHelper(value, n, 0, 0,list);
        return list;
    }

    private static void genparaHelper(StringBuilder value, int n, int openValue, int closeValue,List<String> result) {
        if (value.length() == 2 * n) {
            result.add(value.toString());
            return;
        }
        if (openValue < n) {
            value.append("(");
            genparaHelper(value, n, openValue + 1, closeValue,result);
            value.deleteCharAt(value.length() - 1);
        }
        if (closeValue < openValue) {
            value.append(")");
            genparaHelper(value, n, openValue, closeValue + 1,result);
            value.deleteCharAt(value.length() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(genpara(3));
    }
}

