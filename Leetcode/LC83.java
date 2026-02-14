package com.Leetcode;

public class LC83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t=head;
        ListNode t1=head.next;
        while (t1!=null){
            if (t.val==t1.val){
                t.next=t1.next;
                t1=t1.next;
                continue;
            }
            t=t.next;
            t1=t1.next;
        }
        return head;
    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public void display(ListNode h){
        if (h==null){
            System.out.println("");
            return;
        }
        while (h!=null){
            System.out.print(h.val+" -> ");
            h=h.next;
        }
        System.out.print("null");
    }
    public String toString(){
        StringBuilder builder=new StringBuilder();
        ListNode node=this;
        while (node!=null){
            builder.append(node.val).append("->");
            node=node.next;
        }
        builder.append("null");
        return builder.toString();
    }
}
