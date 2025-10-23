package com.Leetcode;

import com.OOPs.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null){
            return result;
        }
        TreeNode t=root;
        queue.offer(t);
        while (!queue.isEmpty()){
            int level=queue.size();
            List<Integer>list=new ArrayList<>();

            for (int i = 0; i <level; i++) {
                t=(queue.isEmpty())?null:queue.remove();
                assert t != null;
                if (t.left!=null){
                    queue.add(t.left);
                }
                if (t.right!=null){
                    queue.add(t.right);
                }
                list.add(t.val);
            }
            result.add(new ArrayList<>(list));
//            list.clear();
        }


        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        TreeNode t=new TreeNode(1);
        System.out.println(levelOrder(t));
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

  }
