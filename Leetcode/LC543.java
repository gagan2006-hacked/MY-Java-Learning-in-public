package com.Leetcode;

public class LC543 {
    int d=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return d-1;
    }

    private int  height(TreeNode node) {
        if (node==null){
            return 0;
        }

        int l=height(node.left);
        int r=height(node.right);
        int dia=l+r+1;
        d=Math.max(d,dia);

        return Math.max(l,r)+1;
    }

}
