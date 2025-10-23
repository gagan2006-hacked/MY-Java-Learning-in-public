package com.Leetcode;

public class LC24 {
//    [1,2,3,4]
//    [2,1,4,3]
    public static ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode first=head;
        ListNode sec=head.next;
        while (sec!=null){
         int f=first.val;
         int s= sec.val;
         first.val=s;
         sec.val=f;
         if (sec.next!=null&&first.next!=null){
             sec=sec.next.next;
             first=first.next.next;
         }else {
             break;
         }
        }
        return head;
    }

    public static void main(String[] args) {
        swapPairs(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4)))));
    }
}
