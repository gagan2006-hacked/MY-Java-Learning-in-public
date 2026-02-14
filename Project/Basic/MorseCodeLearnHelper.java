package com.Project.Basic;

import java.util.Scanner;
// BASE model
public class MorseCodeLearnHelper {
    private final MorseCodeTranslate translate=new MorseCodeTranslate();
    Scanner in=new Scanner(System.in);

    public static void main(String[] args) {

    }

    public void learnMode(){
        System.out.println("Enter your name (Sir / Mam) ");
        String s=in.next();
        in.nextLine();
        while (true) {
            System.out.println("Hello " + s);
            System.out.println("What would you like to learn ");
            System.out.println("1. AlphaBets");
            System.out.println("2. Numbers");
            String opinon = in.nextLine();
            if (opinon.contains("1") || opinon.contains("alphaBets")) {
                char c = 'a';
                for (int i = 0; i < 26; i++) {
                    c += (char) i;
                    System.out.println(" Morse For "+c+" is ");
                    String ans = translate.encoder("" + c);
                }
            } else if (opinon.contains("2") || opinon.contains("numbers")) {
                for (int i = 0; i <= 9; i++) {
                    System.out.println("enter the morse code for " + i);
                    String input = in.nextLine();
                    String ans = translate.encoder("" + i);
                }
            } else {
                break;
            }
        }
    }
    public void quizMode(){
        System.out.println("Enter your name (Sir / Mam) ");
        String s=in.next();
        in.nextLine();
        int correct=0;
        while (true) {
            System.out.println("Hello " + s + " Sir ");
            System.out.println("What would you like to quiz For");
            System.out.println("1. AlphaBets");
            System.out.println("2. Numbers");
            String opinon = in.nextLine();
            if (opinon.contains("1") || opinon.contains("alphaBets")) {
                char c = 'a';
                for (int i = 0; i < 26; i++) {
                    c += (char) i;
                    System.out.println("enter the morse code for " + c);
                    String input = in.nextLine();
                    String ans = translate.encoder("" + c);
                    if (input.equals(ans)) {
                        correct++;
                    }
                }
                System.out.println("total correct ans is " + correct + " worng is " + (26 - correct));
                correct = 0;
            } else if (opinon.contains("2") || opinon.contains("numbers")) {
                for (int i = 0; i <= 9; i++) {
                    System.out.println("enter the morse code for " + i);
                    String input = in.nextLine();
                    String ans = translate.encoder("" + i);
                    if (input.equals(ans)) {
                        correct++;
                    }
                }
                System.out.println("total correct ans is " + correct + " worng is " + (10 - correct));
                correct = 0;
            } else {
                break;
            }
        }
    }
}
