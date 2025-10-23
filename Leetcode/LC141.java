package com.Leetcode;

public class LC141 {
    public static boolean hasCycle(ListNode head) {
        if (head==null || head.next==null){
            return false;
        }
        ListNode s=head.next;
        ListNode f=head.next.next;
        if(f==null){
            return false;
        }
        while (f!=null && f.next!=null){
            if (s == f){
                return true;
            }

            s=s.next;
            f=f.next.next;
        }
        return false;
    }


    public static int lengthOfTheCycle(ListNode head) {
        if (head==null || head.next==null){
            return 0;
        }
        ListNode s=head.next;
        ListNode f=head.next.next;
        int count=0;
        boolean flag=false;
        while (f!=null && f.next!=null){
            if (s == f){
                count=1;
                flag=true;
                s=s.next;
                break;
            }

            s=s.next;
            f=f.next.next;
        }
        while (flag && s!=f){
            count+=1;
            s=s.next;
        }

        return count;
    }
    public static void main(String[] args) {
        ListNode tail=new ListNode(-4);
        ListNode head=new ListNode(3,new ListNode(2,new ListNode(0,tail)));
        tail.next=head;
        System.out.println(lengthOfTheCycle(head));
    }

}
