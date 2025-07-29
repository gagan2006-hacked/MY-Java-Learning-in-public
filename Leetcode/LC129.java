package com.Leetcode;

public class LC129 {
    public static int sumNumbers(TreeNode root) {
        if (root.left==null && root.right==null){
            return root.val;
        }
        return sumNumbersHelper(root,"");
    }

    private static int sumNumbersHelper(TreeNode node, String s) {
        if (node.left==null&&node.right==null){
            return Integer.parseInt(s+node.val);
        }
        int left=0;
        int right=0;
        if (node.left!=null) {
            left = sumNumbersHelper(node.left, s + node.val);
        }
        if (node.right!=null){
             right=sumNumbersHelper(node.right,s+node.val);

        }
        return left+right;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(sumNumbers(node));
    }
}
