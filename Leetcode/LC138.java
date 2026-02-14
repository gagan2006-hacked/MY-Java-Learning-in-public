package com.Leetcode;

import java.util.HashMap;
import java.util.List;

public class LC138 {
    public static LinkNode copyRandomList(LinkNode head) {
        if (head==null){
            return head;
        }
        HashMap<LinkNode,LinkNode>map=new HashMap<>();
        LinkNode h=head;
        while (h!=null){
            if (!map.containsKey(h)){
                LinkNode node=new LinkNode(h.val);
                map.put(h,node);
            }
            h=h.next;
        }
        h=head;
        LinkNode node=map.getOrDefault(h,null);
        while (h!=null){
            LinkNode n=map.getOrDefault(h,null);
            LinkNode ne=map.getOrDefault(h.next,null);
            LinkNode ra=map.getOrDefault(h.random,null);
            if (n!=null){
                n.next=ne;
                n.random=ra;
            }
            h=h.next;
        }
        return node;
    }

    public static void main(String[] args) {
        // Create sample linked list: [[7,null],[13,0],[11,4],[10,2],[1,0]]
        LinkNode n1 = new LinkNode(7);
        LinkNode n2 = new LinkNode(13);
        LinkNode n3 = new LinkNode(11);
        LinkNode n4 = new LinkNode(10);
        LinkNode n5 = new LinkNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        // Call your function
        LinkNode copiedHead = copyRandomList(n1);

        // Print both lists to verify
        LinkNode orig = n1, copy = copiedHead;
        System.out.println("Original\tCopied");
        while (orig != null) {
            System.out.print("Val: " + orig.val + ", Rand: ");
            System.out.print(orig.random != null ? orig.random.val : "null");
            System.out.print("\t\t");
            System.out.print("Val: " + copy.val + ", Rand: ");
            System.out.println(copy.random != null ? copy.random.val : "null");
            orig = orig.next;
            copy = copy.next;
        }
    }

}

class LinkNode {
    int val;
    LinkNode next;
    LinkNode random;

    public LinkNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkNode current = this;
        while (current != null) {
            sb.append("[val=").append(current.val);
            if (current.random != null) {
                sb.append(", random=").append(current.random.val);
            } else {
                sb.append(", random=null");
            }
            sb.append("] -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
