package com.Leetcode;

import java.util.TreeMap;
import java.util.TreeSet;

public class LC2276 {
    public static void main(String[] args) {
        CountIntervals countIntervals=new CountIntervals();
        countIntervals.add(2, 3);  // add [2, 3] to the set of intervals.
        countIntervals.add(7, 10); // add [7, 10] to the set of intervals.
        System.out.println(countIntervals.count());
        countIntervals.add(5, 8);  // add [5, 8] to the set of intervals.
        countIntervals.count();

    }
}
class CountIntervals {
    private TreeMap<Integer, Integer> map;
    private int total;

    public CountIntervals() {
        map = new TreeMap<>();
        total = 0;
    }

    public void add(int left, int right) {
        // Find overlapping intervals
        Integer start = map.floorKey(right);
        while (start != null && map.get(start) >= left) {
            int existingRight = map.get(start);
            total -= (existingRight - start + 1);
            map.remove(start);
            left = Math.min(left, start);
            right = Math.max(right, existingRight);
            start = map.floorKey(right);
        }
        map.put(left, right);
        total += (right - left + 1);
    }

    public int count() {
        return total;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */