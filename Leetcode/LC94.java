package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        List<Integer> list=new ArrayList<>(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }
}
