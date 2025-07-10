package com.Leetcode;

public class LC876 {
    public static void main(String[] args) {
        ListNode tail=new ListNode(-4);
        ListNode head=new ListNode(3,new ListNode(2,new ListNode(0,tail)));
        ListNode out =middleNode(head);
    }
    public static ListNode middleNode(ListNode head) {
        ListNode s=head;
        ListNode f=head;
        while (f!=null && f.next!=null){
            s=s.next;
            f=f.next;
        }
        return s;
    }
}
