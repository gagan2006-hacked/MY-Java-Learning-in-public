package com.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            result.add(0,list);
//            list.clear();
        }


        return result;
    }

}
