package com.Leetcode;

import java.util.Arrays;

public class LC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==1){
            return new TreeNode(preorder[0]);
        }
        int root=preorder[0];
        int index=0;
        for (int i = 0; i <inorder.length; i++) {
            if (inorder[i]==root){
                index=i;
            }
        }
        TreeNode node=new TreeNode(root);
        node.left=buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        node.right=buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return node;
    }
}
