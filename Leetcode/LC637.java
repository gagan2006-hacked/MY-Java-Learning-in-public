package com.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null){
            return result;
        }
        TreeNode t=root;
        queue.offer(t);
        while (!queue.isEmpty()){
            int level=queue.size();
            double avg=0;
            for (int i = 0; i <level; i++) {
                t=(queue.isEmpty())?null:queue.remove();
                assert t != null;
                if (t.left!=null){
                    queue.add(t.left);
                }
                if (t.right!=null){
                    queue.add(t.right);
                }
                avg+=t.val;
            }
            avg/=level;
            result.add(avg);
//            list.clear();
        }


        return result;
    }

}
