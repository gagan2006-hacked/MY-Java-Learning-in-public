package com.Contests;

import java.nio.charset.IllegalCharsetNameException;
import java.sql.ClientInfoStatus;
import java.util.*;

public class LCBC166 {
    public static String majorityFrequencyGroup(String s) {
        HashMap<Integer, List<Character>>hashMap=new HashMap<>();
        HashMap<Character,Integer>hashMap1=new HashMap<>();
        for (int i = 0; i <s.length(); i++) {
            if (hashMap1.containsKey(s.charAt(i))){
                hashMap1.put(s.charAt(i),hashMap1.get(s.charAt(i))+1);
            }else {
                hashMap1.put(s.charAt(i),1);
            }
        }
        HashSet<Character> set=new HashSet<>(hashMap1.keySet());
        int max=0;
        int f=0;
        for (Character ch:set){
            int feq=hashMap1.get(ch);
            if (hashMap.containsKey(feq)){
                hashMap.get(feq).add(ch);
            }else {
                List<Character>list=new ArrayList<>();
                list.add(ch);
                hashMap.put(feq,new ArrayList<>(list));
            }
        }
        HashSet<Integer>integers=new HashSet<>(hashMap.keySet());
        for (Integer i:integers){
            if (f<i&&max<=hashMap.get(i).size()){
                max=hashMap.get(i).size();
                f=i;
            }
        }
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i <hashMap.get(f).size(); i++) {
            builder.append(hashMap.get(f).get(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(majorityFrequencyGroup("pfpfgi"));
    }
}
