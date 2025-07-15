package com.Leetcode;

import java.util.List;

public class LC2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1,l2,"");
    }
    public static ListNode addTwoNumbersHelper(ListNode l1, ListNode l2,String val) {
        String values="";
        int l1Len=lenOfTheLinkList(l1);
        int l2Len=lenOfTheLinkList(l2);
        return sumOfEqual(l1,l2,l1Len,l2Len);
    }
    public static ListNode sumOfEqual(ListNode l1,ListNode l2,int len1,int len2){
        int carry=0;
            ListNode t=l1;
            ListNode t1=l2;
            ListNode re;
            if (len1>len2){
                re=l1;
            }else{
                re=l2;
            }
            ListNode r=re;
            ListNode listNode=re;
            while (t != null && t1!= null){
                int val=t.val+t1.val+carry;
                carry=val/10;
                val=val%10;
                re.val=val;
                t=t.next;
                t1=t1.next;
                listNode=re;
                re=re.next;
            }
            while (t!=null){
                int val=t.val+carry;
                carry=val/10;
                val=val%10;
                re.val=val;
                t=t.next;
                listNode=re;
                re=re.next;
            }
            while (t1!=null){
                int val=t1.val+carry;
                carry=val/10;
                val=val%10;
                re.val=val;
                t1=t1.next;
                listNode=re;
                re=re.next;
            }
            if (carry!=0){
                ListNode node=new ListNode(carry);
                listNode.next=node;
            }
            return r;
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
        ListNode listNode=makingListNode("37");
        ListNode listNode1=makingListNode("92");
        ListNode r=addTwoNumbers(listNode,listNode1);
        r.display(r);
    }
    public static ListNode makingListNode(String value){
        ListNode result=new ListNode(value.charAt(0)-'0');
        ListNode listNode=result;
        for (int i = 1; i <value.length(); i++) {
            ListNode node=new ListNode(value.charAt(i)-'0') ;
            listNode.next=node;
            listNode=listNode.next;
        }
        return result;
    }
}
