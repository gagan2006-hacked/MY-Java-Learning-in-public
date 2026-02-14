package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC3217 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer>set=new HashSet<>();
        for (int i = 0; i <nums.length; i++) {
            set.add(nums[i]);
        }
        while (head!=null && set.contains(head.val)){
            head=head.next;
        }
        if (head==null){
            return head;
        }
        ListNode nHead=head;

        ListNode prev=null;
        ListNode node=head;
        while (node!=null){
            if (set.contains(node.val)){
                prev.next=node.next;
                node=node.next;
                continue;
            }
            prev=node;
            node=node.next;
        }

        return nHead;
    }
}
