package com.Leetcode;

public class LC142 {
    public static ListNode detectCycle(ListNode head) {
        int len=LC141.lengthOfTheCycle(head);
        if (len==0){
            return null;
        }
        ListNode t=head;
        ListNode s=head;
        while (len>0){
            s=s.next;
            len--;
        }
        while (t!=s){
            t=t.next;
            s=s.next;
        }
        return s;
    }
    public static void main(String[] args) {
        ListNode tail=new ListNode(1,new ListNode(2));
        ListNode t=detectCycle(tail);
    }

}
