package com.Leetcode;

public class LC98 {
    public boolean isValidBST(TreeNode root) {
        TreeNode t=root;
        return isValidBSTHelper(t);
    }

    private boolean isValidBSTHelper(TreeNode node) {
        if (node==null){
            return true;
        }
        if (node.left!=null && node.right!=null) {
            if (node.left.val > node.val || node.right.val < node.val) {
                return false;
            }
        }

        return isValidBSTHelper(node.left)&&isValidBSTHelper(node.right);
    }
}
