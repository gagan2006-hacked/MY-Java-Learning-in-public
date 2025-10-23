package com.Leetcode;

public class LC744 {
    public static char nextGreatestLetter(char[] letters,char target) {
        if (target=='z'){
            return letters[0];
        }
        long s=0;
        long e=letters.length-1;
        while (s<=e){
            long mid=(s+e)/2;
            if (letters[(int)mid]>target){
                e=mid-1;
            }else {
                s=mid+1;
            }
        }
        if (s>letters.length-1){
            return letters[0];
        }
        return letters[(int)s];
    }

    public static void main(String[] args) {
        char []arr=new char[]{'c','f','g'};
        System.out.println(nextGreatestLetter(arr,'g'));
    }

}
