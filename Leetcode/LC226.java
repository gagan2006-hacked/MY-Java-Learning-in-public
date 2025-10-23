package com.Leetcode;

public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode t=root;
        return invertTreeHelper(t);
    }

    private TreeNode invertTreeHelper(TreeNode node) {
        if (node==null){
            return node;
        }
        TreeNode left=invertTree(node.left);
        TreeNode  right=invertTree(node.right);

        node.right=left;
        node.left=right;
        return node;
    }
    /* Brute force
    * public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode t=root;
        return invertTreeHelper(t);
    }

    private TreeNode invertTreeHelper(TreeNode node) {
        if (node.left==null&&node.right==null){
            return node;
        }
        TreeNode left=node.left;
        TreeNode right=node.right;
        if (node.left!=null){
            left=invertTree(node.left);
        }
        if (node.right!=null){
            right=invertTree(node.right);
        }
        node.right=left;
        node.left=right;
        return node;
    }
    * */

}
