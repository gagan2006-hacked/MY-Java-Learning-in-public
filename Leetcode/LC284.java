package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LC284 implements Iterator<Integer> {
    Integer []arr;
    int i=0;
    public LC284(Iterator<Integer> iterator) {
        List<Integer>list=new ArrayList<>();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        arr=list.toArray(new Integer[0]);
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return arr[i];
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int j=i;
        i++;
        return arr[j];
    }

    @Override
    public boolean hasNext() {
        return i< arr.length;
    }
}
