package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC237 {
    public static void deleteNode(ListNode node) {
        /*ListNode listNode=node.next;
        List<Integer> list=new ArrayList<>();
        while (listNode!=null){
            list.add(listNode.val);
            listNode=listNode.next;
        }
        listNode=node;
        ListNode prev=null;
        int i=0;
        while (listNode.next!=null){
            if (i<list.size()) {
                listNode.val = list.get(i);
            }
            prev=listNode;
            listNode=listNode.next;
            i++;
        }
        if (prev!=null){
            prev.next=null;
        }*/
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(5,new ListNode(1,new ListNode(9)));
        ListNode head=new ListNode(4,node);
        deleteNode(node);
        System.out.println(head);
    }
}
