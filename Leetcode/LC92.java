package com.Leetcode;

public class LC92 {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1,new ListNode(2));
        listNode=reverseBetween(listNode,1,3);
        listNode.display(listNode);

    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode present=head;
        ListNode prev=null;
        for (int i = 0; present!=null &&i <left-1; i++) {
            prev=present;
            present=present.next;
        }

        ListNode next=(present!=null)?present.next:null;
        ListNode last=prev;
        ListNode tail=present;
        for (int i = 0; present!=null &&  i <(right-left)+1; i++) {
            present.next=prev;
            prev=present;
            present=next;
            if (next!=null){
                next=next.next;
            }
        }
        if (last!=null){
            last.next=prev;
        }
        else {
            head=prev;
        }
        tail.next=present;
        return head;
    }
    public static ListNode reverseBetweenDSA(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // reverse between left and right
        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }

}
