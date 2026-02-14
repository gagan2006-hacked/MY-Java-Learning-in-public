package com.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class LC380 {

}

class RandomizedSet {
    TreeSet<Integer>set;
    public RandomizedSet() {
        set=new TreeSet<>();
    }

    public boolean insert(int val) {
        boolean b=set.contains(val);
        if (!b){
            set.add(val);
        }
        return !b;
    }

    public boolean remove(int val) {
        boolean b=set.contains(val);
        if (b){
            set.remove(val);
        }
        return b;
    }

    public int getRandom() {
        List<Integer>list=new ArrayList<>(set);
        Random random=new Random();
        return list.get(random.nextInt(0,list.size()));
    }
}
