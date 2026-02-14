package com.OOPs.FileHandling;

import java.io.*;
import java.util.Arrays;

public class DemoForIO {
    public static void main(String[] args) {
        /*try {
            int c= System.in.read()-'0';
            System.out.println(c);
        } catch (IOException e) {

        }*/
//        System.out.println(System.err.checkError());
        File file=new File("D:\\Progr\\src\\com\\OOPs\\FileHandling\\data.txt");
        if (file.exists())
            System.out.println(file.delete());

        /* *//* try {
//            System.out.println(file.createNewFile());
            FileInputStream fileInputStream=new FileInputStream(file);
            System.out.println(fileInputStream.read());
//            System.out.println((int)'3');
//            System.out.println((int)'8');
           *//**//* FileOutputStream o=new FileOutputStream(file);
            for (int i = 0; i <26; i++) {
                o.write(97+i);
                o.write(44);
            };*//**//*
        } catch (IOException e) {

        }*//*
//        System.out.println(System.getProperty("user.dir"));

//        file reader,
        *//*try {
            FileReader reader=new FileReader(file);
            System.out.println( reader.read());
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }*//*
        *//*try (FileWriter writer = new FileWriter(file)) {
            writer.append("hi i am Gagan v , i will be the cybersecurity god");
        } catch (IOException e) {
            e.printStackTrace();
        }*//*

        try {
            *//*BufferedReader b=new BufferedReader(new FileReader(file));
            while (b.ready()) {
                System.out.println(b.readLine());
            }
            b.reset();*//*
            BufferedWriter w=new BufferedWriter(new FileWriter(file,true));
//            w.write("\ni will never give up on my goal");
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
