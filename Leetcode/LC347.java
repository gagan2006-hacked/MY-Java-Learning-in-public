package com.Leetcode;

import java.util.*;

public class LC347 {
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length<k){
            return new int[]{};
        }
        HashMap<Integer,Capsule>map=new HashMap<>();
        for (int ele:nums){
            if (map.containsKey(ele)){
               Capsule c=map.get(ele);
               c.setValue(c.getValue()+1);
            }else {
                map.put(ele,new Capsule(ele,1));
            }
        }
        List<Capsule>capsules=new ArrayList<>(map.values());
        Collections.sort(capsules);
        int arr[]=new int[k];
        for (int i = 0; i <k; i++) {
            arr[i]=capsules.get(i).getCount();
        }
        return arr;
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{1,1,2,2,3,3,3},2);
    }
}


class Capsule implements Comparable<Capsule>{
    int count;
    int value;
    public Capsule(){

    }

    public Capsule(int val, int count) {
        this.count = val;
        this.value = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public String toString(){
        StringBuilder b=new StringBuilder();
        b.append("Count = "+count+" Value ="+value);
        return b.toString();
    }
    @Override
    public int compareTo(Capsule o) {
        return o.getValue()-this.getValue();
    }

}
