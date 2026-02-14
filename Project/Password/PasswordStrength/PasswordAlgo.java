package com.Project.Password.PasswordStrength;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordAlgo {
    public String getRanSalt(){
        Random r= new Random();
        int l=r.nextInt(2,15);
        StringBuilder b=new StringBuilder();
        char c=(int)0;
        for (int i = 0; i <l; i++) {
            int n=r.nextInt(1,255);
            if (Character.isAlphabetic((char)(c+n))){
                b.append((char)(c+n));
            }
        }
        return b.toString();
    }

    public String getPasswordStrength(String s){
        if (s.isBlank()||s.length()<=8){
            return "VERY WEAK";
        }
        int st=1;
        if (s.matches(".*[a-z].*")){
            st++;
        }
        if (s.matches(".*[A-Z].*")){
            st++;
        }
        if (s.matches(".*\\d.*")) {
            st++;
        }
        if (s.matches(".*[!@#$%^&*()-+].*")){
            st++;
        }
        switch (st){
            case 5:return "VERY STRONG";
            case 4:return "STRONG";
            case 3, 2:return "MEDIUM";
            default:return "WEAK";
        }
    }

    public List<String> getSuggestion(String s){
        String salt=getRanSalt();
        String salt1=getRanSalt();
        return getSuggestionHelper(s,salt,salt1);
    }

    private List<String> getSuggestionHelper(String s, String salt1,String salt2) {
        if (s.isBlank()){
            List<String>list=new ArrayList<>();
            list.add(salt1.length()+salt1.substring(0,salt1.length()/2)+salt1.length()+salt1.substring(salt1.length()/2));
        }
        List<String >list=new ArrayList<>();
        Random r=new Random();
        for (int i = 0; i <s.length(); i++) {
            String f=s.substring(0,i);
            String b=s.substring(i);
           int l=r.nextInt(0,2);
           if (l==0){
               list.add(f+salt1+b);
           }else {
               list.add(f+salt2+b);
           }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new PasswordAlgo().getSuggestion("Gagan@2006vishwa"));
    }
}
