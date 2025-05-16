package com.company;

import java.util.Scanner;

public class SquareRootUsingBin {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.printf("%.2f",sqrtOfusr(in.nextInt()));
//        System.out.println(6.324555206298829*6.324555206298829);
    }
    public static double sqrtOfusr(int n){
        int start=0;
        int end=n;
        int m=-1;
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
