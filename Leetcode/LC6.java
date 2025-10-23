package com.Leetcode;

public class LC6 {
    public static String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        int cycleLen = 2 * (numRows - 1);

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += cycleLen) {
                builder.append(s.charAt(j));

                // middle rows need an extra character in between
                int secondJ = j + cycleLen - 2 * i;
                if (i > 0 && i < numRows - 1 && secondJ < s.length()) {
                    builder.append(s.charAt(secondJ));
                }
            }
        }

        return builder.toString();
    }


    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
}
