package com.Leetcode;

public class LC25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head==null|| head.next==null){
            return head;
        }

        int h=1;
        int t=1;
        int len=lenOfTheLinkList(head);
        if (k>len){
            return head;
        }
        while (t<len){
            while (t-h!=k-1){
                t++;
            }
            if (t-h==k-1 && t<len) {
                head = LC92.reverseBetween(head, h, t);
                h=t+1;
            }
        }
        return head;
    }
    public static ListNode reverseKAlternateGroup(ListNode head, int k) {
        if (head==null|| head.next==null){
            return head;
        }

        int h=1;
        int t=1;
        int len=lenOfTheLinkList(head);
        if (k>len){
            return head;
        }
        boolean flag=false;
        while (t<len){
            while (t-h!=k-1){
                t++;
            }
            if (flag){
                flag=false;
                h=t+1;
                continue;
            }
            if (t-h==k-1 && t<len) {
                head = LC92.reverseBetween(head, h, t);
                h=t+1;
                flag=true;
            }
        }
        return head;
    }


    private static int lenOfTheLinkList(ListNode head) {
        if (head==null){
            return 0;
        }
        ListNode t=head;
        int len=0;
        while (t!=null){
            t=t.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6,new ListNode(7,new ListNode(8))))))));
        listNode=reverseKGroup(listNode,2);
        listNode.display(listNode);

    }


}
