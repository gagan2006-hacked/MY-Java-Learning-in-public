package com.Leetcode;

import java.util.*;

public class LC653 {
    /*public static boolean findTarget(TreeNode root, int k) {
        if (root!=null &&root.left==null&&root.right==null){
            return root.val==k;
        }
        List<Integer> list = new ArrayList<>(getValue(root));
        System.out.println(list);
        HashSet<Integer>set=new HashSet<>();
        for (Integer i:list){
            int minTarget=k-i;
            if (set.contains(minTarget)){
                return true;
            }
            set.add(i);
        }
        return false;
    }

    private static List<Integer> getValue(TreeNode node) {
        if (node.left==null&&node.right==null){
            List<Integer>r=new ArrayList<>();
            r.add(node.val);
            return r;
        }
        List<Integer> list = new ArrayList<>();
        if (node.left!=null) {
             list.addAll(getValue(node.left));
        }
        list.add(node.val);
        if (node.right!=null) {
            list.addAll(getValue(node.right));
        }
        return list;
    }*/
    private static HashSet<Integer>set=new HashSet<>();
    public static boolean findTarget(TreeNode node, int k) {
        if (node==null){
            return false;
        }
        int target=k-node.val;
        if (set.contains(target)){
            return true;
        }else {
            set.add(node.val);
        }
        return findTarget(node.left,k) ||findTarget(node.right,k);
    }
    public static List<Integer> getValue(TreeNode node) {
        if (node.left == null && node.right == null) {
            List<Integer> r = new ArrayList<>();
            r.add(node.val);
            return r;
        }
        List<Integer> list = new ArrayList<>();
        if (node.left != null) {
            list.addAll(getValue(node.left));
        }
        list.add(node.val);
        if (node.right != null) {
            list.addAll(getValue(node.right));
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findTarget(new TreeNode(1),2));
    }
}
