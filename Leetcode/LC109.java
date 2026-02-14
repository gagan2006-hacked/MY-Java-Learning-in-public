package com.Leetcode;

import com.MOCK.TreeNode;
import com.OOPs.AVLTree;

public class LC109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null){
            return null;
        }
        AVLTree tree=new AVLTree();
        ListNode node=head;
        while (node!=null){
            tree.insert(node.val);
            node=node.next;
        }
        return tree.getAll();
    }
}
