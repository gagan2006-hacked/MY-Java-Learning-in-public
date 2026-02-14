package com.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC3784 {
//    basic
    public long minCost(String s, int[] cost) {
        long min=Long.MAX_VALUE;
        HashMap<Character,Helper>map=new HashMap<>();

//        n
        for (int i = 0; i <s.length(); i++) {
            char ch=s.charAt(i);
            if (map.containsKey(ch)){
                Helper helper=map.get(ch);
                helper.increaseCountBy1();
                helper.addIndex(i);
            }else {
                Helper h=new Helper(1);
                h.addIndex(i);
                map.put(ch,h);
            }
        }
        List<Helper>helpers=new ArrayList<>(map.values());
        long totalAns=0l;
//        n
        for (Helper h:helpers){
         h.findCost(cost);
         totalAns+=h.getCost();
        }
        for (int i = 0; i <helpers.size(); i++) {
            long cos=(totalAns-helpers.get(i).getCost());
            min=Math.min(cos,min);
        }

        return (min==Long.MAX_VALUE)?0:min;
    }
    class Helper{
        private int count;
        private List<Integer>index=new ArrayList<>();
        private long cost;

        public Helper(int count) {
            this.count = count;
        }

        public void addIndex(int index){
            this.index.add(index);
        }
        public void increaseCountBy1(){
            count++;
        }

        public  void findCost(int []costs){
            for (Integer i:index){
                cost+=costs[i];
            }
        }

        public int getCount() {
            return count;
        }

        public List<Integer> getIndex() {
            return index;
        }

        public long getCost() {
            return cost;
        }

        @Override
        public String toString() {
            return "{" +
                    "cost=" + cost +
                    '}';
        }
    }

    public static void main(String[] args) {
        LC3784 lc3784=new LC3784();
        System.out.println(lc3784.minCost("aaaq",new int[]{620973973,772442621,842992318,277245496}));
    }
}
