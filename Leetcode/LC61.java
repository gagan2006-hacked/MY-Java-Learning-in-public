package com.Leetcode;

public class LC61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null|| head.next==null){
            return head;
        }
        int len=lenOfTheLinkList(head);
        k=k%(len);

        if (k!=0){
            k=(len-k);
            int mid=k;
            head=reverseBetween(head,1,mid);
            head=reverseBetween(head,mid+1,len);
            head=reverseBetween(head,1,len);
        }
        return head;
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
        ListNode listNode=new ListNode(0,new ListNode(1,new ListNode(2)));
        listNode=rotateRight(listNode,3);
        listNode.display(listNode);

    }

}
