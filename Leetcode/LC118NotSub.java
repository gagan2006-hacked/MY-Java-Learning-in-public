package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC118NotSub {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>prev=new ArrayList<>();
        prev.add(1);
        result.add(new ArrayList<>(prev));
        prev.clear();
        if (numRows==1){
            return result;
        }
        prev.add(1);
        prev.add(1);
        result.add(new ArrayList<>(prev));
        if (numRows==2){
            return result;
        }
        int ind=2;
        while (ind<numRows){
            List<Integer>level=new ArrayList<>();
            prev=result.get(ind-1);
            level.addFirst(1);
            for (int i =1; i<ind ; i++) {
                level.add(prev.get(i-1) + prev.get(i));
            }
            level.addLast(1);
            result.add(new ArrayList<>(level));
            ind++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
