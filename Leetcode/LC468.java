package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LC468 {
    public static String validIPAddress(String queryIP) {
       int v4=0,v6=0;
        for (char c:queryIP.toCharArray()){
            if (c=='.'){
                v4++;
            } else if (c==':') {
                v6++;
            }
        }
        if (v4==3&&v6==0){
            return checkIPv4(queryIP);
        } else if (v6==7 && v4==0) {
            return checkIPv6(queryIP);
        }
        return "Neither";
    }

    private static String checkIPv6(String queryIP) {
        String[] arr = queryIP.split(":");
        if (arr.length != 8) return "Neither";

        for (String seg : arr) {
            if (seg.length() == 0 || seg.length() > 4) return "Neither";

            for (char ch : seg.toCharArray()) {
                if (!Character.isDigit(ch) &&
                        !(ch >= 'a' && ch <= 'f') &&
                        !(ch >= 'A' && ch <= 'F')) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }


    private static String checkIPv4(String queryIP) {
        String[] arr = queryIP.split("\\.");
        if (arr.length != 4) return "Neither";

        for (String seg : arr) {
            if (seg.isEmpty()) return "Neither";

            if (seg.length() > 1 && seg.charAt(0) == '0') {
                return "Neither";
            }

            for (char ch : seg.toCharArray()) {
                if (!Character.isDigit(ch)) return "Neither";
            }

            int num = Integer.parseInt(seg);
            if (num < 0 || num > 255) return "Neither";
        }
        return "IPv4";
    }


    public static void main(String[] args) {
        System.out.println(validIPAddress("12..33.4"));
//        System.out.println(;
    }
}
