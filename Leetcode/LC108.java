package com.Leetcode;

public class LC108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==1){
            return new TreeNode(nums[0]);
        }
        return sortedArrayToBSTHelper(nums,0,nums.length-1);
    }

    private static TreeNode sortedArrayToBSTHelper(int[] nums, int s, int e) {
        if (s>e){
            return null;
        }
        int m=(s+e)/2;
        TreeNode pNode=new TreeNode(nums[m]);
        pNode.left=sortedArrayToBSTHelper(nums,s,m-1);
        pNode.right=sortedArrayToBSTHelper(nums,m+1,e);
        return pNode;
    }
/*
    public static void display(TreeNode node){
        TreeNode treeNode=node;
        print(treeNode);
    }
    private static void print(TreeNode node){
        if (node==null){
            return;
        }
        print(node.right);
        System.out.println(node.val);
        print(node.left);
        s
    }
*/

    public static void main(String[] args) {
        TreeNode treeNode=sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println("heel");
    }
}
