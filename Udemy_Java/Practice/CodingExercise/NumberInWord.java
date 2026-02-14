package com.Udemy_Java.Practice.CodingExercise;

import java.util.HashMap;

public class NumberInWord {
    // write code here
   /* public void printNumberInWord(int num){
        HashMap<Integer,String>map=new HashMap<>();
        setup(map);
        if (map.containsKey(num)){
            System.out.println(map.get(num));
        }
        else {
            System.out.println("OTHER");
        }
    }*/
/*
    private void setup(HashMap<Integer, String> map) {
        if (!map.isEmpty())return;
        map.put(0,"ZERO");
        map.put(1,"ONE");
        map.put(2,"TWO");
        map.put(3,"THREE");
        map.put(4,"FOUR");
        map.put(5,"FIVE");
        map.put(6,"SIX");
        map.put(7,"SEVEN");
        map.put(8,"EIGHT");
        map.put(9,"NINE");
    }*/

    public static void printNumberInWord(int num) {

        switch (num) {
            case 0:
                System.out.println("ZERO");
                break;
            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            case 4:
                System.out.println("FOUR");
                break;
            case 5:
                System.out.println("FIVE");
                break;
            case 6:
                System.out.println("SIX");
                break;
            case 7:
                System.out.println("SEVEN");
                break;
            case 8:
                System.out.println("EIGHT");
                break;
            case 9:
                System.out.println("NINE");
                break;
            default:
                System.out.println("OTHER");
                break;
        }
    }
}