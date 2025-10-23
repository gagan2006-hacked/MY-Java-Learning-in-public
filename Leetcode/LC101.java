package com.Leetcode;
import java.util.LinkedList;
import java.util.Queue;

public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null){
            return false;
        }
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
                TreeNode leftNode=queue.remove();
                TreeNode rightNode=queue.remove();
//                if both things are null skip that
            if (leftNode == null && rightNode == null) {
                continue;
            }
//              if we have reached this it mean any one of not null or both are not null by checking any one of them is null or not we can say it is mirror or mot
//              let say both are not null we have check conditon of are the equal or not so != condn is applied
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
//            adding the order the make mirror node togather to check again
            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }
        return true;
    }
}
