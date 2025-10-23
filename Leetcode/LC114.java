package com.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC114 {
    public static void flatten(TreeNode root) {
        TreeNode t=root;
        flattenHelper(t);
    }

    private static void flattenHelper(TreeNode node) {
        if (node==null){
            return;
        }
        TreeNode current=node;
        while (current!=null){
            if (current.left!=null){
                TreeNode t=current.left;
                while (t.right!=null){
                    t=t.right;
                }
                t.right=current.right;
                current.right=current.left;
                current.left=null;
            }
            current=current.right;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,new TreeNode(6),new TreeNode(7)));
        TreeNode t=new TreeNode(1);
        flatten(treeNode);
    }
}
