package com.Leetcode;

public class LC124 {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return max;
    }

    private int maxPathSumHelper(TreeNode node) {
        if (node==null){
            return 0;
        }
        int l=maxPathSumHelper(node.left);
        int r=maxPathSumHelper(node.right);
        l=Math.max(0,l);
        r=Math.max(0,r);

        int path=l+r+node.val;
        max=Math.max(path,max);

        return Math.max(l,r)+node.val;
    }

}
