package com.Leetcode;

import java.util.HexFormat;
import java.util.List;

public class LC148 {
    public static ListNode sortList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode re=mergeSortForLinkList(head);
        return re;
    }

    private static ListNode mergeSortForLinkList(ListNode head) {
        if (head.next==null){
            return head;
        }
        int mid=mid(head);
        ListNode te=head;
        for (int i = 0; i <mid; i++) {
            te=te.next;
        }
        ListNode right=te.next;
        te.next=null;
        ListNode left=head;
        left=mergeSortForLinkList(left);
        right=mergeSortForLinkList(right);
        return LC21.mergeTwoLists(left,right);
    }
    public static int mid(ListNode head){
        int count=0;
        ListNode s=head;
        ListNode f=head;
        while (s!=null){
            s=s.next;
            count++;
        }
        return (count-1)/2;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(5,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(1)))));
        ListNode t=sortList(listNode);
        t.display(t);
    }

}
