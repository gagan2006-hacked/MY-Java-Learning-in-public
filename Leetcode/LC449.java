package com.Leetcode;

public class LC449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder=new StringBuilder();
        builder.append(helper(root));
        return builder.toString();
    }

    private StringBuilder helper(TreeNode root) {
        if (root==null){
            return new StringBuilder();
        }
        StringBuilder builder=new StringBuilder();
        builder.append(root.val).append(",");
        builder.append(helper(root.left));
        builder.append(helper(root.right));
        return builder;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isBlank()||data.isEmpty()){
            return null;
        }
        String []a=data.split(",");
        int []arr=new int[a.length];
        for (int i = 0; i <a.length; i++) {
            arr[i]=Integer.parseInt(a[i]);
        }
        return bstFromPreorder(arr);
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }
    // basic
    private void insert(TreeNode root, int val) {
        TreeNode node = root;
        while (true) {
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
    }
}
