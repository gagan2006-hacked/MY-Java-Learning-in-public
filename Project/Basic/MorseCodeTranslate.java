package com.Project.Basic;

import java.util.HashMap;

public class MorseCodeTranslate {
    HashMap<String,Character> morseMap=new HashMap<>();
    HashMap<Character,String> letterMap=new HashMap<>();
    public MorseCodeTranslate(){
        setAlgo();
    }

// ===============================
// International Morse Code Chart
// ===============================

// Letters
// A: ●-        B: -●●●    C: -●-●    D: -●●
// E: ●         F: ●●-●    G: --●     H: ●●●●
// I: ●●        J: ●---    K: -●-     L: ●-●●
// M: --        N: -●      O: ---     P: ●--●
// Q: --●-      R: ●-●     S: ●●●     T: -
// U: ●●-       V: ●●●-    W: ●--     X: -●●-
// Y: -●--      Z: --●●

// Numbers
// 1: ●----     2: ●●---   3: ●●●--   4: ●●●●-   5: ●●●●●
// 6: -●●●●     7: --●●●   8: ---●●   9: ----●   0: -----

// ===============================
// Time Units
// ===============================
// Dot duration: 1 unit
// Dash duration: 3 units
// Space between parts of the same letter: 1 unit
// Space between letters: 3 units
// Space between words: 7 units
// ===============================

    public void setAlgo(){
        // Letters
        morseMap.put(".-", 'A');
        letterMap.put('A',".-");

        morseMap.put("-...", 'B');
        letterMap.put('B',"-...");

        morseMap.put("-.-.", 'C');
        letterMap.put('C',"-.-.");

        morseMap.put("-..", 'D');
        letterMap.put('D',"-..");

        morseMap.put(".", 'E');
        letterMap.put('E',".");

        morseMap.put("..-.", 'F');
        letterMap.put('F',"..-.");

        morseMap.put("--.", 'G');
        letterMap.put('G',"--.");

        morseMap.put("....", 'H');
        letterMap.put('H',"....");

        morseMap.put("..", 'I');
        letterMap.put('I',"..");

        morseMap.put(".---", 'J');
        letterMap.put('J',".---");

        morseMap.put("-.-", 'K');
        letterMap.put('K',"-.-");

        morseMap.put(".-..", 'L');
        letterMap.put('L',".-..");

        morseMap.put("--", 'M');
        letterMap.put('M',"--");

        morseMap.put("-.", 'N');
        letterMap.put('N',"-.");

        morseMap.put("---", 'O');
        letterMap.put('O',"---");

        morseMap.put(".--.", 'P');
        letterMap.put('P',".--.");

        morseMap.put("--.-", 'Q');
        letterMap.put('Q',"--.-");

        morseMap.put(".-.", 'R');
        letterMap.put('R',".-.");

        morseMap.put("...", 'S');
        letterMap.put('S',"...");

        morseMap.put("-", 'T');
        letterMap.put('T',"-");

        morseMap.put("..-", 'U');
        letterMap.put('U',"..-");

        morseMap.put("...-", 'V');
        letterMap.put('V',"...-");

        morseMap.put(".--", 'W');
        letterMap.put('W',".--");

        morseMap.put("-..-", 'X');
        letterMap.put('X',"-..-");

        morseMap.put("-.--", 'Y');
        letterMap.put('Y',"-.--");

        morseMap.put("--..", 'Z');
        letterMap.put('Z',"--..");


        // Numbers
        morseMap.put(".----", '1');
        letterMap.put('1',".----");

        morseMap.put("..---", '2');
        letterMap.put('2',"..---");

        morseMap.put("...--", '3');
        letterMap.put('3',"...--");

        morseMap.put("....-", '4');
        letterMap.put('4',"....-");

        morseMap.put(".....", '5');
        letterMap.put('5',".....");

        morseMap.put("-....", '6');
        letterMap.put('6',"-....");

        morseMap.put("--...", '7');
        letterMap.put('7',"--...");

        morseMap.put("---..", '8');
        letterMap.put('8',"---..");

        morseMap.put("----.", '9');
        letterMap.put('9',"----.");

        morseMap.put("-----", '0');
        letterMap.put('0',"-----");

    }

    public String decoder(String morseData){
        if (morseData.isBlank()){
            return "";
        }
        StringBuffer b=new StringBuffer();

        String[]words=morseData.trim().split(" {3}|/");
        for (String word:words){
            String[]let=word.trim().split(" ");
            for (String lett:let){
                if (morseMap.containsKey(lett)){
                    b.append(morseMap.getOrDefault(lett, '?'));
                }else {
                    return "Illegal Symbol or rules are not followed";
                }
            }
            b.append(" ");
        }
        return b.toString().trim();
    }
    public String encoder(String sentence){
        if (sentence.isBlank()){
            return "";
        }
        StringBuffer b=new StringBuffer();
        String[]word=sentence.toUpperCase().trim().split(" ");
        for (String w:word){
            for (char ch:w.toCharArray()){
                if (letterMap.containsKey(ch)){
                    b.append(letterMap.get(ch));
                }else {
                    return "Illegal Symbol or rules are not followed";
                }
                b.append(" ");
            }
            b.append("   ");
        }
        return b.toString().trim();
    }

}
