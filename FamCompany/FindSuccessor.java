package com.FamCompany;
import java.util.LinkedList;
import java.util.Queue;
/* Google Interview Question */
public class FindSuccessor {
    public static TreeNode findSuccessor(TreeNode root,int val){
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode result=null;
        if (root==null){
            return result;
        }
        TreeNode t=root;
        queue.offer(t);
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                t = (queue.isEmpty()) ? null : queue.remove();
                assert t != null;
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
                if (t.val==val){
                    result=queue.poll();
                    return result;
                }
            }
        }
        return result;
    }




}






class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val,TreeNode left) {
        this.val = val;
        this.left=left;
    }
    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
