package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC86 {
    public ListNode partition(ListNode head, int x) {
        if (head==null){
            return null;
        }
        List<Integer>less=new ArrayList<>();
        List<Integer>moreAndEqual=new ArrayList<>();
        ListNode h=head;
        while (h!=null){
            if (h.val<x){
                less.add(h.val);
            }else {
                moreAndEqual.add(h.val);
            }
            h=h.next;
        }
        less.addAll(moreAndEqual);
        return partitionHelper(less);
    }

    private ListNode partitionHelper(List<Integer> less) {
        if (less.isEmpty())
        {
            return null;
        }
        ListNode head=new ListNode(less.getFirst());
        ListNode node=head;
        for (int i = 1; i <less.size(); i++) {
            node.next=new ListNode(less.get(i));
            node=node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(36+28+3);
    }
}
