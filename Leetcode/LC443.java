package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC443 {
     class Capsule {
       char val;
        int count;

        public Capsule(char val, int count) {
            this.val = val;
            this.count = count;
        }

        public char getVal() {
            return val;
        }

        public void setVal(char val) {
            this.val = val;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }
        public String toString(){
            StringBuilder b=new StringBuilder();
            b.append(this.getVal()).append("--").append(getCount());
            return b.toString();
        }

     }
    public int compress(char[] chars) {
        List<Capsule>list=new ArrayList<>();
        char c=chars[0];
        list.add(new Capsule(c,1));
        int ind=0;
        for (int i = 1; i < chars.length; i++) {
            if (c==chars[i]){
               Capsule cap=list.get(ind);
               cap.setCount(cap.getCount()+1);
            }else {
                c=chars[i];
                Capsule capsule=new Capsule(c,1);
                ind++;
                list.add(capsule);
            }
        }
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i <list.size(); i++) {
            builder.append(list.get(i).getVal());
            if (list.get(i).getCount() > 1) {
                builder.append(list.get(i).getCount());
            }
        }


        for (int i = 0; i <builder.length(); i++) {
            chars[i]=builder.charAt(i);
        }

        return builder.length();
    }

    public static void main(String[] args) {
         LC443 lc443=new LC443();
        System.out.println(lc443.compress(new char[]{'a','a','b','b','c','c','c'}));
    }
}
