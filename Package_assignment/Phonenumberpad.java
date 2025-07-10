package com.Package_assignment;

import java.util.ArrayList;
import java.util.List;

class Phonenumberpad {
    public List<String> letterCombinations(String digits) {
        StringBuilder value= new StringBuilder();
        List<String> list=new ArrayList<>();
        solution(value,digits,digits.length(),list);
        return list;
    }
    public static void main(String[] args) {
        String num="89";
        Phonenumberpad phonenumberpad=new Phonenumberpad();
        System.out.println(phonenumberpad.letterCombinations(num));
//        solution(va,num,num.length());
    }
    public static void solution(StringBuilder value,String num,int n,List<String> result){
        if (n==0){
            if (value.isEmpty()) {
                return;
            }
            result.add(value.toString());
            return;
        }
        char A='a';
        int start=(num.charAt(0)-'2')*3;
        int end=start+3;
        int numberInFirst=num.charAt(0)-'0';
        if (numberInFirst==7){
            end+=1;
        }
        else if (numberInFirst>7){
            start+=1;
            end=(numberInFirst>8)?end+2:end+1;
        }
        for (int i = start; i < end; i++) {
            char toAdd=(char)(A+i);
            value.append(toAdd);
            solution(value,num.substring(1),n-1,result);
            value.deleteCharAt(value.length()-1);
        }
    }
}