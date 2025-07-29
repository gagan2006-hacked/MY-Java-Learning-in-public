package com.Leetcode;

public class LC112 {

    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (node==null&& targetSum==0){
            return false;
        }
        return hasPathSumHelper(node,targetSum,0);
    }

    private boolean hasPathSumHelper(TreeNode node, int targetSum, int sum) {
        if (node == null) {
            return false;
        }
        sum+= node.val;
        if (node.right==null && node.left==null){
            return sum==targetSum;
        }
        return hasPathSumHelper(node.left,targetSum,sum) || hasPathSumHelper(node.right,targetSum,sum);
    }
}
