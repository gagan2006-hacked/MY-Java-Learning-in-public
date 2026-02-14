package com.Udemy_Java.Practice;

public class MethodsPractice {
    static void  displayHighScore(String name ,int pos){
        if (pos!=0){
            System.out.println(name+" managed to get into position "+pos+" on the High Score list ");
        }
    }
    static int calculateHighScore(int score){
        int i=0;
        if (score>=1000){
            i=1;
        } else if (score >= 500) {
            i=2;
        } else if (score>=100) {
            i=3;
        }else {
            i=4;
        }
        return i;
    }

    public static void main(String[] args) {
        displayHighScore("Luffy",calculateHighScore(10020));
        displayHighScore("Zoro",calculateHighScore(789));
    }
}
