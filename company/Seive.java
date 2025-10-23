package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Seive {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
        if (n<=0)return;
        boolean []pr=new boolean[n+1];
//        System.out.println(seive(in.nextInt(),pr));
        seive(n,pr);

    }
    static void seive (int n,boolean[]prime){
        for (int i = 2; i<=(int)Math.sqrt(n) ; i++) {
            if (!prime[i]){
                for (int j = i*2; j <=n ; j+=i) {
                    prime[j]=true;
                }
            }
        }
        for (int i = 2; i <=n ; i++) {
            if (!prime[i]){
                System.out.print(i+" ");
            }

        }

    }
}
