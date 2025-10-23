package com.MOCK;

public class Mock1 {
    // question 1
    public static boolean checkRecord(String s) {
        int a=0;
        for (int i = 0; i <s.length(); i++) {
            if (s.charAt(i)=='A'){
                a++;
            }
            if (a>=2){
                return false;
            }
        }
        return !s.contains("LLL");
    }

    public static void main(String[] args) {
        System.out.println(checkRecord("PPLLPL"));
    }
}
