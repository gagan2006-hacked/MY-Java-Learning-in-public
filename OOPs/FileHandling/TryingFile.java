package com.OOPs.FileHandling;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryingFile {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(bufferedReader.readLine());

//        System.out.println(System.in.read());

    }
}
