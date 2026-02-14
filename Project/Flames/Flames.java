package com.Project.Flames;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Flames {
    HashMap<Character,Integer>name1=new HashMap<>();
    HashMap<Character,Integer>name2=new HashMap<>();
    HashMap<String,String>flames=new HashMap<>();

    public Flames(){
        flames.put("F","Friends");
        flames.put("L","Lover");
        flames.put("A","Attraction");
        flames.put("M","Marriage");
        flames.put("E","Enemy");
        flames.put("S","Sister");
    }

    public String makeFlames(String name,String naam) {
        name=name.replaceAll("\\s","");
        naam=naam.replaceAll("\\s","");
        setUp1(name);
        setUp2(naam);

        String v=(name.length()>naam.length())? naam.toLowerCase():name.toLowerCase();
        for (int i = 0; i <v.length(); i++) {
            char ch=v.charAt(i);
            if (name1.containsKey(ch)&&name2.containsKey(ch)){
                name1.put(ch, name1.get(ch)-1);
                name2.put(ch, name2.get(ch)-1);
                if (name1.get(ch)==0){
                    name1.remove(ch);
                } else if (name2.get(ch)==0) {
                    name2.remove(ch);
                }
            }
        }

        int length = getAllWords(name1) + getAllWords(name2);
        StringBuilder builder = new StringBuilder("FLAMES");
        int index = 0;
        while (builder.length() > 1) {
            index = (index + length) % builder.length();
            builder.deleteCharAt(index);
        }
        name1.clear();
        name2.clear();
        return flames.getOrDefault(builder.toString(), "Unknown");
    }

    private int getAllWords(HashMap<Character, Integer> name1) {
        int l=0;
        for (Map.Entry<Character,Integer>entry:name1.entrySet()){
            l+=entry.getValue();
        }
     return l;
    }

    private void setUp1(String name){
        for (char ch:name.toCharArray()){
            ch=Character.toLowerCase(ch);
            if (name1.containsKey(ch)){
                name1.put(ch, name1.get(ch)+1);
            }else {
                name1.put(ch,1);
            }
        }
    }
    private void setUp2(String name){
        for (char ch:name.toCharArray()){
            ch=Character.toLowerCase(ch);
            if (name2.containsKey(ch)){
                name2.put(ch, name2.get(ch)+1);
            }else {
                name2.put(ch,1);
            }
        }
    }

    public static void main(String[] args) {
        Flames flames1=new Flames();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the first name");
        String name=in.nextLine();
        System.out.println("Enter the Second name");
        String naam=in.nextLine();
        System.out.println(flames1.makeFlames(name,naam));
    }
}
