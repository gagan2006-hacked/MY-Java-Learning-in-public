package com.Leetcode;

import java.util.*;

public class LC993 {
    /*public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null){
            return false;
        }
        TreeNode t=root;
        queue.offer(t);
        while (!queue.isEmpty()){
            int level=queue.size();
            HashSet<Integer>list=new HashSet<>();

            for (int i = 0; i <level; i++) {
                t=(queue.isEmpty())?null:queue.remove();
                assert t != null;
                if (t.left!=null){
                    queue.add(t.left);
                }
                if (t.right!=null){
                    queue.add(t.right);
                }

                if (t.left!=null&&t.right!=null){
                    if ((t.left.val==x||t.left.val==y)&&(t.right.val==x||t.right.val==y)){
                        return false;
                    }
                }
                list.add(t.val);
            }
            if (list.contains(x)&&list.contains(y)){
                return true;
            }
//            list.clear();
        }


        return false;
    }*/



// ChatGpt
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return false;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < level; i++) {
                TreeNode t = queue.remove();

                // Check if children are x and y with same parent
                if (t.left != null && t.right != null) {
                    if ((t.left.val == x && t.right.val == y) || (t.left.val == y && t.right.val == x)) {
                        return false;
                    }
                }

                if (t.left != null) {
                    queue.add(t.left);
                    if (t.left.val == x) foundX = true;
                    if (t.left.val == y) foundY = true;
                }

                if (t.right != null) {
                    queue.add(t.right);
                    if (t.right.val == x) foundX = true;
                    if (t.right.val == y) foundY = true;
                }
            }

            if (foundX && foundY) return true;
            if (foundX || foundY) return false;
        }

        return false;
    }

}
