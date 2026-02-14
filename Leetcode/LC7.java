package com.Leetcode;

public class LC7 {
    private static int max=Integer.MAX_VALUE;
    private static int min=Integer.MIN_VALUE;
    public static int reverse(int x) {
        long n=x;
        boolean flag=false;
        if (x<0){
            n=n*(-1);
            flag=true;
        }
        if (x>=0&&x<10){
            return x;
        }
        StringBuilder b=new StringBuilder(""+n);
        b.reverse();
        long lon=Long.parseLong(b.toString());
        int val=0;
        if (max<lon){
            return 0;
        }else {
            val=(int) lon;
        }
        if (flag){
            val*=-1;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
