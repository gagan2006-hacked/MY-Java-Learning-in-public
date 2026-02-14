package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC530 {
    public static int getMinimumDifference(TreeNode root) {
        List<Integer>list=getNumberS(root);
        int min=Integer.MAX_VALUE;
        for (Integer i:list) {
            for (Integer j:list){
                if (i!=j) {
                    int n = i - j;
                    if (n < 1) n *= -1;
                    min = Math.min(min, n);
                }
            }
        }
        return min;
    }

    private static List<Integer> getNumberS(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        if (root==null)return list;
        list.addAll(getNumberS(root.left));
        list.add(root.val);
        list.addAll(getNumberS(root.right));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumDifference(new TreeNode(543)));
    }
}
