package com.company;

import java.util.ArrayList;

public class Recurrsion {
    public static void main(String[] args){
//        System.out.println(facOfN(5));
//        System.out.println(fiboOfN(5));
//        System.out.println(sumOfDigits(12345,0));
/*
        String name = "gagan v";
        System.out.println(reverseAString(name));
*/
//        System.out.println(powerOfN(2,3));
//        System.out.println(palindrome("radar"));
//        patternPrinting(5);
//        System.out.println(countStepstoReducetoZero(14));
//        System.out.println(stringLengReturn("Hello world"));
//        patternPrinting(3);
        ArrayList<String>list=new ArrayList<>(allSubsetOfString1("","abc",new ArrayList<>()));
        System.out.println(list);
    }

//    less optimaized algorithim bigO(1.623 power n)
    public static int fiboOfN(int n){
        if (n<2)return n;
        return fiboOfN(n-1)+ fiboOfN(n-2);
    }

    public static long facOfN(long n){
        if (n<2)return 1;
        return n*facOfN(n-1);
    }
    public static long sumOfDigits(long n,long sum){
        int dig=(int)Math.log10(n)+1;
       sum += n%10;
         if (dig==1)return sum;
        return sumOfDigits(n/10,sum);

    }

    public static long sumOfDigitsSimple(long n,long sum){
        sum+=n%10;
        if (n==0)return sum;
        return sumOfDigitsSimple(n/10,sum);

    }
    public static String reverseAString(String og){
        int i=og.length()-1;
        String re="";
        return reverseAStringHelper(og,re,i);
    }
    public static String reverseAStringHelper(String og,String reverse,int i){
         reverse+=og.charAt(i);
        if (i==0)return reverse;
        return reverseAStringHelper(og,reverse,i-1);
    }
//    BigO(p)complexity
    public static long powerOfN(int n ,int p){
        if (p==0)return 1L;
        return n*powerOfN(n,p-1);
    }

    public static boolean palindrome(String og){
        return og.equalsIgnoreCase(reverseAString(og));
    }
//    input n =3 output = 32123
    public static void patternPrinting(int n){
      int i=2*n-1;
      patternPrintingHelper(i,n);
    }
    public static void patternPrintingHelper(int n,int i){
        if (i==0)return;
        System.out.print(i +" ");
        patternPrintingHelper(n,i-1);
        if (n==(2*i)-1) return;
        System.out.print(i+1+" ");
    }
    public static int countStepstoReducetoZero(int n){
        int count =0;
        return countStepstoReducetoZeroHelper(n,count);
    }

    private static int countStepstoReducetoZeroHelper(int n, int count) {
        if (n==0)return count;
        if ((n&1)==0){
           return countStepstoReducetoZeroHelper(n/2,count+1);
        }else {
            return countStepstoReducetoZeroHelper(n-1,count+1);
        }
    }
    public static int stringLengReturn(String og){
        int i=0;
        StringBuilder o=new StringBuilder(og);
        return stringLengReturnHelper(o,i);
    }

    private static int stringLengReturnHelper(StringBuilder og, int i){
        if (og.isEmpty())return i;
        return stringLengReturnHelper(og.deleteCharAt(0),i+1);
    }
    public static void allSubsetOfString(String value, String og){
        if (og.isEmpty()) {
            System.out.print(value+" ");
            return;
        }
        allSubsetOfString(value+og.charAt(0),og.substring(1));
        allSubsetOfString(value,og.substring(1));
    }
    public static ArrayList<String> allSubsetOfString1(String value, String og,ArrayList list){
        if (og.isEmpty()) {
            list.add(value);
            return list;
        }
        allSubsetOfString1(value+og.charAt(0),og.substring(1),list);
        allSubsetOfString1(value,og.substring(1),list);
        allSubsetOfString1(value+(og.charAt(0)+0),og.substring(1),list);
        return list;
    }


}
