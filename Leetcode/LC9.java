package com.Leetcode;

public class LC9 {
    /*public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int n=x;
        while (n!=0){
            int digit=(int)Math.log10(n);
            int last=n%10;
            int first=n/(int)(Math.pow(10,digit));
            if (last!=first){
                return false;
            }
            n=n-(first*(int)(Math.pow(10,digit)));
            n=n/10;
        }
        return true;
    }*/

//     4 milli sec solution 
    public static boolean isPalindrome(int x) {
        int orginal=x;
        int reverse=0;
        if(x<0) return false;
        while(x!=0){
            int digit = x % 10;
            reverse = reverse*10+digit;
            x=x/10;
        }
        return orginal == reverse;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1000021));
    }
}
