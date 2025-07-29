package com.Leetcode;

import java.util.*;

public class LC103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Deque<TreeNode> queue=new ArrayDeque<>();
        if (root==null){
            return result;
        }
        TreeNode t=root;
        queue.offer(t);
        boolean rev=false;
        while (!queue.isEmpty()){
            int level=queue.size();
            List<Integer>list=new ArrayList<>();
            for (int i = 0; i <level; i++) {
                if (!rev) {
                    t=queue.pollFirst();
                    if (t.left != null) {
                        queue.offerLast(t.left);
                    }
                    if (t.right != null) {
                        queue.offerLast(t.right);
                    }

                }
                else {
                    t=queue.pollLast();
                    if (t.right != null) {
                        queue.offerFirst(t.right);
                    }
                    if (t.left != null) {
                        queue.offerFirst(t.left);
                    }
                }
                list.add(t.val);
            }
            result.add(new ArrayList<>(list));
            rev=!rev;
//            list.clear();
        }


        return result;
    }
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        TreeNode t=new TreeNode(1);
        System.out.println(zigzagLevelOrder(treeNode));
    }
}

