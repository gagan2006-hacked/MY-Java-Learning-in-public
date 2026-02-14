package com.Leetcode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LC341 implements Iterator<Integer> {
    LinkedList<Integer>list;
    public LC341(List<NestedInteger> nestedList) {
        list=new LinkedList<>();
        list.addAll(getList(nestedList));
    }

    public LinkedList<Integer> getList(List<NestedInteger> nestedList){
        LinkedList<Integer> linkedList=new LinkedList<>();
        for(NestedInteger n:nestedList){
            if (n.isInteger()){
                linkedList.add(n.getInteger());
            }else {
                linkedList.addAll(getList(n.getList()));
            }
        }
        return linkedList;
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public Integer next() {
        return list.removeFirst();
    }
}


interface NestedInteger {

public boolean isInteger();

public Integer getInteger();

public List<NestedInteger> getList();
}
