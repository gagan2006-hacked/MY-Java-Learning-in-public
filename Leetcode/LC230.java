package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC230 {
   /* public int kthSmallest(TreeNode root, int k) {
        if (root==null){
            return 0;
        }
        List<Integer>result=new ArrayList<>(kthSmallestHelper(root,k));
        if (k-1>=result.size()){
            return -1;
        }
        return result.get(k-1);
    }

    private List<Integer> kthSmallestHelper(TreeNode node, int k) {
        List<Integer>result=new ArrayList<>();
        if (node==null){
            return result;
        }
        result.addAll(kthSmallestHelper(node.left,k));
        result.add(node.val);
        result.addAll(kthSmallestHelper(node.right,k));
        return result;
    }*/
    int point=0;
   public int kthSmallest(TreeNode root, int k) {
      kthSmallestHelper(root,k,0);
      return point;
   }

    private TreeNode kthSmallestHelper(TreeNode node, int k, int p) {
       if (node==null){
           return node;
       }
       TreeNode left=kthSmallestHelper(node.left,k,p);
       if (left!=null){
           return left;
       }
       point++;
       if (point==k){
           return node;
       }
       return kthSmallestHelper(node.right,k,p);
    }
}
