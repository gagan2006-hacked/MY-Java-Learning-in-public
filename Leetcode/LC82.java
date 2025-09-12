package com.Leetcode;

import javax.print.attribute.HashAttributeSet;
import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC82 {
   /* public ListNode deleteDuplicates(ListNode head) {
        if (head==null&&head.next==null){
            return head;
        }
        ListNode t=head;
        ListNode p=head.next;
        ListNode node=new ListNode(0);
        node.next=head;
        while (p!=null){
            if (t.val==p.val ||(p.next!=null&& p.val==p.next.val)){
                int val=p.val;
                p=p.next;
                while (p!=null&& p.val!=val){
                    p=p.next;
                }
                t.next=p;
            }
            t=t.next;
            p=p.next;
        }
        return node;
    }*/
   public static ListNode deleteDuplicates(ListNode head) {
       if (head==null||head.next==null){
           return head;
       }
       HashSet<Integer>set=new HashSet<>();
       String s="";
       while (head!=null){
           int val=head.val;
           if (set.contains(val)){
               s+=val;
           }
           else {
               set.add(val);
           }
           head=head.next;
       }
       for (char c:s.toCharArray()){
           set.remove(c-'0');
       }
       int []arr=set.stream().mapToInt(Integer::intValue).toArray();
       Arrays.sort(arr);
       return nodeFormation(arr,0);
   }

    private static ListNode nodeFormation(int []arr,int i) {
       if (i== arr.length){
           return null;
       }
       ListNode node=new ListNode(arr[i]);
       node.next=nodeFormation(arr,i+1);
       return node;
    }

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4)))))));
    }

}
