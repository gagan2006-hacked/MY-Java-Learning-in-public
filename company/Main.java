package com.company;

import java.math.BigInteger;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        /*CusHashSet<Integer>set=new CusHashSet<>(10);
        set.insert(11);
        set.insert(144);
        set.insert(12);
        set.insert(111);
        set.insert(21);
        set.insert(1);
        System.out.println(set);*/
        long n=64;
        BigInteger big=new BigInteger(""+n);
        int bit=big.bitLength();
        int count=0;
        /*System.out.println(Integer.toBinaryString((int) n));
        System.out.println(Integer.toBinaryString((int) (n>>1)));*/
        while (bit!=0){
            if ((n&1)==1){
                count++;
            }
            if (count>1){
                break;
            }
            n=n>>1;
            bit--;
        }
        System.out.println(count==1);
    }
}