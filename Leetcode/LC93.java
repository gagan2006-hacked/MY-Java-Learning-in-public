package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC93 {


    public static List<String> restoreIpAddresses(String s) {
        return helper(s, 0, "", 0);
    }

    private static List<String> helper(String s, int index, String current, int dots) {
        List<String> result = new ArrayList<>();

        // Base case: if we used 3 dots, last part remains
        if (dots == 3) {
            String lastPart = s.substring(index);
            if (isValid(lastPart)) {
                result.add(current + lastPart);
            }
            return result;
        }
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);
            if (isValid(part)) {
                result.addAll(helper(s, index + len, current + part + ".", dots + 1));
            }
        }

        return result;
    }

    private static boolean isValid(String part) {
        if (part.length() == 0 || part.length() > 3) return false;
        if (part.charAt(0) == '0' && part.length() > 1) return false;
        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("101023"));
    }
}
