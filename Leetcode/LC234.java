package com.Leetcode;

public class LC234 {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(2,new ListNode(1)))));
        System.out.println(isPalindrome(listNode));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null){
            return true;
        }
        int len=lenOfList(head);
        int mid=len/2;
        int mid1=mid;
        head= LC92.reverseBetween(head,mid+1,len);
        ListNode m=head;
        ListNode t=head;
        while (m!=null &&mid1!=0){
            m=m.next;
            mid1--;
        }
        mid1=mid;
        while (t!=null && m!=null &&mid1!=0){
            if (t.val!=m.val){
                return false;
            }
            t=t.next;
            m=m.next;
            mid1--;
        }
        return true;
    }
    public static int lenOfList(ListNode head){
        if (head==null){
            return 0;
        }
        ListNode t=head;
        int len=0;
        while (t!=null){
            len++;
            t=t.next;
        }
        return len;
    }

}
