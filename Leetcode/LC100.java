package com.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null){
            return true;
        }
        if (p==null || q==null){
            return false;
        }
        Queue<TreeNode>pList=new LinkedList<>();
        Queue<TreeNode>qList=new LinkedList<>();
        pList.offer(p);
        qList.offer(q);
        while (!pList.isEmpty() && !qList.isEmpty()){
            TreeNode pt=pList.poll();
            TreeNode qt=qList.poll();
            if (pt!=null && qt!=null) {
                if (pt.val == qt.val) {
                    pList.add(pt.left);
                    pList.add(pt.right);
                    qList.add(qt.left);
                    qList.add(qt.right);
                }else {
                    return false;
                }
            } else if (pt==null&&qt==null){
                continue;
            }else {
                return false;
            }
        }
        if (pList.isEmpty() && !qList.isEmpty()){
            return false;
        } else if (!pList.isEmpty()) {
            return false;
        }
        return true;
    }
}
