package com.Project;

import java.util.Scanner;
// BASE model
public class MorseCodeLearnHelper {
    public static void main(String[] args) {
        MorseCodeTranslate translate=new MorseCodeTranslate();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter your name Sir ");
        String s=in.next();
        in.nextLine();
        int correct=0;
        while (true){
            System.out.println("Hello "+s+" Sir ");
            System.out.println("What would you like to learn ");
            System.out.println("1. AlphaBets");
            System.out.println("2. Numbers");
            String opinon=in.nextLine();
            if (opinon.contains("1")||opinon.contains("alphaBets")){
                char c='a';
                for (int i = 0; i <26; i++) {
                    c+= (char) i;
                    System.out.println("enter the morse code for "+c);
                    String input=in.nextLine();
                    String ans=translate.encoder(""+c);
                    if (input.equals(ans)){
                     correct++;
                    }
                }
                System.out.println("total correct ans is "+correct+" worng is "+(26-correct));
                correct=0;
            } else if (opinon.contains("2") || opinon.contains("numbers")) {
                for (int i = 0; i<=9; i++) {
                    System.out.println("enter the morse code for "+i);
                    String input=in.nextLine();
                    String ans=translate.encoder(""+i);
                    if (input.equals(ans)){
                        correct++;
                    }
                }
                System.out.println("total correct ans is "+correct+" worng is "+(10-correct));
                correct=0;
            }else {
                break;
            }
        }
    }
}
