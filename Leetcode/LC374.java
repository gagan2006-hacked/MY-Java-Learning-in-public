package com.Leetcode;

public class LC374 {
    public static int guessNumber(int n) {
        int s=0;
        int e=n;
        while (s<=e){
            int mid=(s+e)/2;
            if (guess(mid)==0){
                return mid;
            }
            if (guess(mid)==1){
                s=mid+1;
            }else {
                e=mid-1;
            }
        }
        return -1;
    }
   private static int guess=194004;
    public static int guess(int num){
        if (num<guess){
            return 1;
        }
        else if (num>guess){
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(Integer.MAX_VALUE));

    }
}
