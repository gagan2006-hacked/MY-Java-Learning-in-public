package com.Leetcode;

public class LeetCode69 {
    public static void main(String[] args) {
        System.out.println(sqrtOfusr(9));
    }
    public static double sqrtOfusr(int n){
        long start=0;
        long end=n;
        long m=-1;
        while (start<=end){
            m=(start+end)/2;
            if (m*m==n){
                return m;
            }
            if (m*m>n){
                end=m-1;
            }else if (m*m<n){
                start=m+1;
            }
        }

        double root=end;double per=0.1;
        for (int i = 0; i <5; i++) {
            while (root*root<n){
                root+=per;
            }
            if (root*root>n){
                per/=4;
                root-=per;

            }
        }
        return root;

    }
}
