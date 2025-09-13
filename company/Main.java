package com.company;

import com.Project.MorseCodeTranslate;

import java.math.BigInteger;
import java.util.Locale;
import java.util.Random;
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
       /* long n=64;
        BigInteger big=new BigInteger(""+n);
        int bit=big.bitLength();
        int count=0;
        *//*System.out.println(Integer.toBinaryString((int) n));
        System.out.println(Integer.toBinaryString((int) (n>>1)));*//*
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
        System.out.println(count==1);*/
        /*MorseCodeTranslate translate=new MorseCodeTranslate();
        System.out.println("Welcome to morse code Decoder and Encoder");
        Scanner in=new Scanner(System.in);
        char ch='y';
        while (ch=='y'){
            System.out.println("To convert morse to english type ( MTE ) ");
            System.out.println("To convert english to morse type ( ETM ) ");
            String type=in.next().toUpperCase();
            in.nextLine();
            if (type.equals("MTE")){
                System.out.println("Enter the morse using  rules ");
                String w=in.nextLine();
                System.out.println(translate.decoder(w));
            } else if (type.equals("ETM")) {
                System.out.println("enter a line or word  , use no Special character ");
                String w=in.nextLine();
                System.out.println(translate.encoder(w));
            }else {
                System.out.println("enter the correct Conversion ");
            }
            System.out.println("Do you want to continue (y/n)");
            ch=in.next().toLowerCase().charAt(0);
            in.nextLine();
        }*/
        int r=new Random().nextInt(0,2);
        System.out.println(r);
    }
}