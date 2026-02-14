package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC43 {
    public static String multiply(String num1, String num2) {
        char []numOne=num1.toCharArray();
        char []numTwo=num2.toCharArray();
        List<String>list=multiplyTheChar(numOne,numTwo);
        return addAllTheNumbers(list);
    }

    private static String addAllTheNumbers(List<String> list) {
        if (list.isEmpty())return "";
        if (list.size()==1) return list.get(0);
        StringBuilder builder=new StringBuilder(list.removeFirst());
        int carry=0;
        int count=1;
        while (!list.isEmpty()){
            char[] num1=builder.toString().toCharArray();
            char[] num2= (list.removeFirst() + "0".repeat(count)).toCharArray();count++;builder.setLength(0);
            for (int i = num2.length-1; i>-1; i--) {
                int val= num2.length- num1.length;
                if (i-val<0){
                    int s=num2[i]-'0'+carry;
                    carry=0;
                    builder.insert(0,s);
                    continue;
                }
                int n2=num2[i]-'0';
                int n1=num1[i-val]-'0';
                int sum=n1+n2+carry;
                carry=(sum>9)?((sum-sum%10)/10):0;
                if (i==0){
                    carry=0;
                }else {
                    sum=(carry>0)? sum%10:sum;
                }
                builder.insert(0,sum);
            }
        }
        return builder.toString();
    }

    private static List<String> multiplyTheChar(char[] numOne, char[] numTwo) {
        if (numTwo.length<1)return new ArrayList<>();
        if (numOne.length==1||numTwo.length==1){
            if (numOne[0]-'0'==0||numTwo[0]-'0'==0)
            {
                List<String>list=new ArrayList<>();
                list.add("0");
                return list;
            }
        }
        List<String>list=new ArrayList<>();
        StringBuilder b=new StringBuilder();
        int carry=0;
        for (int i =numTwo.length-1 ; i >-1; i--) {
            int ele1=numTwo[i]-'0';
            for (int j = numOne.length-1; j>-1; j--) {
                int ele2=numOne[j]-'0';
                int pro=ele1*ele2+carry;
                carry=(pro>9)?((pro-pro%10)/10):0;
                if (j==0){
                    carry=0;
                }else {
                    pro=(carry>0)?pro%10:pro;
                }
                b.insert(0,pro);
            }
            list.add(b.toString());b.setLength(0);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(multiply("3",38+""));
//        992 , 496 , 868
    }
}
