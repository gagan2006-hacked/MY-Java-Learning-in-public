package com.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LC869 {
    public boolean reorderedPowerOf2(int n) {
        String s=""+n;
        return getAllPowersOf2_OfSizeN(s.length(),s);
    }

    private boolean getAllPowersOf2_OfSizeN(int length,String s) {
        HashMap<Integer,Integer>mapS=new HashMap<>();
        boolean flag=false;
        for (char ch:s.toCharArray()){
            int num=ch-'0';
            mapS.put(num,mapS.getOrDefault(num,0)+1);
        }
        List<String>list=powerOf2N(length);
        for (String string:list){
            HashMap<Integer,Integer>mapTheNumber=new HashMap<>();
            for (char ch:string.toCharArray()){
                int num=ch-'0';
                mapTheNumber.put(num,mapTheNumber.getOrDefault(num,0)+1);
            }
            for (char ch:string.toCharArray()){
                int num=ch-'0';
                if (mapS.containsKey(num)){
                    if (Objects.equals(mapS.get(num), mapTheNumber.get(num))){
                        flag=true;
                    }
                    else {
                        flag=false;
                        break;
                    }
                }else {
                    flag=false;
                    break;
                }
            }
            if (flag){
                return true;
            }
        }
        return false;
    }
    private List<String> powerOf2N(int length){
        List<String>list=new ArrayList<>();
        StringBuilder builder=new StringBuilder();
        int l=1;
        int num=1;
        while (l<=length){
            if (l==length){
                builder.setLength(0);
                builder.append(num);
                list.add(builder.toString());
            }
            num*=2;
            builder.setLength(0);
            builder.append(num);
            l=builder.length();
        }
        return list;
    }

    public static void main(String[] args) {
        LC869 lc869=new LC869();
        System.out.println(lc869.reorderedPowerOf2(821));
    }
}
