package com.Leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2197 {
    public static List<Integer> replaceNonCoprimes(int[] arr) {
        if(arr.length<=1){
            List<Integer> list=new ArrayList<>();
            list.add(arr[0]);
            return list;
        }
        List<Integer>list= new ArrayList<>(Arrays.stream(arr).boxed().toList());
        int s=0;
        while(s<list.size()-1){
            int gcd=gcd(list.get(s),list.get(s+1));
            if (gcd!=1){
                int a=list.remove(s);
                int b=list.remove(s);
                long lcm = ((long) a * b) / gcd;
                list.add(s, (int) lcm);

            }else {
                s++;
            }
        }
        return list;
    }
    public static int gcd(int a,int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(replaceNonCoprimes(new int[]{31,97561,97561,97561,97561,97561,97561,97561,97561}));
    }

   /* public static List<Integer> replaceNonCoprimes(int[] arr) {
        List<Integer> stack = new ArrayList<>();
        for (int num : arr) {
            stack.add(num);
            while (stack.size() > 1) {
                int a = stack.get(stack.size() - 2);
                int b = stack.get(stack.size() - 1);
                int g = gcd(a, b);
                if (g == 1) break;
                long lcm = ((long) a * b) / g;
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.add((int) lcm);
            }
        }
        return stack;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }*/

}
