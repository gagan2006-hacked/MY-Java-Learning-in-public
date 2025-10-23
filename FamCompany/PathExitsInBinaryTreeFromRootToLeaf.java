package com.FamCompany;

public class PathExitsInBinaryTreeFromRootToLeaf {
    public static boolean pathExist(int []arr,TreeNode root){
        if (root==null){
            return false;
        }
        return pathExistHelper(arr,root,0);
    }

    private static boolean pathExistHelper(int[] arr, TreeNode node, int i) {
        if (node.right==null&& node.left==null){
            return node.val==arr[i];
        }
        if (arr[i]==node.val){
            return pathExistHelper(arr,node.left,i+1) || pathExistHelper(arr,node.right,i+1);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(3,new TreeNode(5),new TreeNode(9,new TreeNode(10,new TreeNode(16)),new TreeNode(12,new TreeNode(8))));
        System.out.println(pathExist(new int[]{3,9,12,8},treeNode));
    }


}
/*class TreeNode {
    int val;
    com.Leetcode.TreeNode left;
    com.Leetcode.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, com.Leetcode.TreeNode left, com.Leetcode.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }*/


