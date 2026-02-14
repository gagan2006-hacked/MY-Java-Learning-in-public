package com.Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
public class LC146 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2,1);
        lRUCache.put(1,1);
        lRUCache.put(2,3);
        lRUCache.put(4,1);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
    }
}


class LRUCache {
   private LinkedList<Capsule> linkedList;
    private HashSet<Integer> set;
    private int size = 0;

    public LRUCache(int capacity) {
        size = capacity;
        linkedList = new LinkedList<>();
        set = new HashSet<>();
    }

    public int get(int key) {
        for (Capsule c : linkedList) {
            if (key == c.getCount()) {
                linkedList.remove(c);
                linkedList.addLast(c);
                return c.getValue();
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        for (Capsule c : linkedList) {
            if (key == c.getCount()) {
                c.setValue(value);
                linkedList.remove(c);
                linkedList.addLast(c);
                return;
            }
        }
        if (linkedList.size() == size) {
           Capsule capsule=linkedList.removeFirst();
           set.remove(capsule.getCount());
        }

        linkedList.addLast(new Capsule(key,value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
