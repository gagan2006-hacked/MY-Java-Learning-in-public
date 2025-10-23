package com.Leetcode;

import static com.Leetcode.LC234.lenOfList;

public class LC143 {
    public static void reorderList(ListNode head) {
        if (head==null || head.next==null){
            return;
        }
        int len=lenOfList(head);
        int mid=len/2;
        int mid1=mid;
        head= LC92.reverseBetween(head,mid+1,len);
        ListNode m=head;
        ListNode t=head;
        while (m!=null &&mid1!=1){
            m=m.next;
            mid1--;
        }
        mid1=mid;
        ListNode mtemp=m.next;
        m.next=null;
        m=mtemp;
        while (t!=null && m!=null && mid1!=0){
            ListNode temp=t.next;
            t.next=m;
            t=temp;
            ListNode temp2=m.next;
            if (t!=null) {
                m.next = t;
                m = temp2;
            }
            mid1--;

        }
    }
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        reorderList(listNode);
        listNode.display(listNode);

    }

}
