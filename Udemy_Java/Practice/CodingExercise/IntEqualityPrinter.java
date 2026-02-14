package com.Udemy_Java.Practice.CodingExercise;

public class IntEqualityPrinter {
    // write code here
    public static void printEqual(int x,int y,int z){
        int min=Math.min(x,y);min=Math.min(min,z);
        if (min<0){
            System.out.println("Invalid Value");
        } else if (x == y && x == z) {
            System.out.println("All numbers are equal");
        }else if (x==y || x==z ||y==z){
            System.out.println("Neither all are equal or different");
        }else {
            System.out.println("All numbers are different");
        }
    }

        public static void main(String[] args) {
            printEqual(1, 1, 1);

            printEqual(1, 1, 2);

            printEqual(-1, -1, -1);

            printEqual(1, 2, 3);
    }
}