package com.Leetcode;

import java.util.List;

public class LC19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null){
            return head;
        }
        if (head.next==null && n==1){
            return null;
        }
        ListNode r=head;
        int length=listNodeLength(r);
        ListNode prev=null;
        ListNode curr=head;
        int i=length-n;
        while (i>0){
            if (curr!=null){
                prev=curr;
                curr=curr.next;
                i--;
            }
        }
        if (prev==null){
            return curr.next;
        }else {
            prev.next=curr.next;
        }
        return head;
    }
    public static int listNodeLength(ListNode head){
        if (head==null){
            return 0;
        }
        int c=0;
        ListNode node=head;
        while (node!=null){
            node=node.next;
            c++;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(removeNthFromEnd(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),2));
    }
}
