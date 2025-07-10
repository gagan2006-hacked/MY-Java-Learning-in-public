package com.Leetcode;

import java.util.List;

public class LC206 {
    public static ListNode reverseList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode t= reverseListHelper(head.next,head,new ListNode());
        head.next=null;
        return t;
    }

    private static ListNode reverseListHelper(ListNode head,ListNode node,ListNode n){
        if (head.next==null) {
            head.next=node;
            return head;
        }
        n=reverseListHelper(head.next,node.next,n);
        head.next=node;
//        node.next=null;
        return n;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1,new ListNode(2));
        listNode=reverseList(listNode);
        listNode.display(listNode);
    }

}
