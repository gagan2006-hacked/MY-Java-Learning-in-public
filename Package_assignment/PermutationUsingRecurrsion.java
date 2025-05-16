package com.Package_assignment;

public class PermutationUsingRecurrsion {
    public static void main(String[] args) {
        String og ="abc";
//        System.out.println(og.substring(0,1));
        combinationOfGivenString("",og);
    }
    static void combinationOfGivenString(String value ,String og){
        if (og.isEmpty()){
            System.out.print(value+" ");
            return;
        }
        for (int i = 0; i <=value.length() ; i++) {
            String fp=value.substring(0,i);
            char ch=og.charAt(0);
            String bp=value.substring(i);
            combinationOfGivenString(fp+ch+bp,og.substring(1));
        }
    }
}
