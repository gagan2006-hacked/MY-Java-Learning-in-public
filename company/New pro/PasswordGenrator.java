package com.company;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenrator {
    public static String passwordGen(){
        String password="";
        int i=1;
        Scanner in=new Scanner(System.in);
        Random random=new Random();
        int len=random.nextInt(10,16);
        return passwordGenHelp(password,i,len);
    }

    private static String passwordGenHelp(String password, int i, int len) {
        if (i==len) {
            return password;
        }
        Random random=new Random();
        int sam=random.nextInt(1,25);
        char a= (char) ('a'+sam);
        password=passwordGenHelp(password+a,i+1,len);
        return password;
    }
    public static String getHashOfPassword(String password){
        password=""+password.hashCode();
        return password;
    }

    public static void main(String[] args) {
//        System.out.println(passwordGen());
        System.out.println(getHashOfPassword("gagan v"));
    }
}
