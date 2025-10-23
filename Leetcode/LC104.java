package com.Leetcode;

public class LC104 {
    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root);
    }

    private int maxDepthHelper(TreeNode node) {
        if (node==null){
            return 0;
        }
        return Math.max(maxDepthHelper(node.left),maxDepthHelper(node.right))+1;
    }
}
