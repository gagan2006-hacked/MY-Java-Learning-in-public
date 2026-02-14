package com.Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC117 {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        Node t=root;
        Queue<Node>queue=new ArrayDeque<>();
        queue.offer(t);

        while (!queue.isEmpty()){
            int length=queue.size();
            List<Node>list=new ArrayList<>(queue);
            Node n=list.getFirst();
            for (int i = 1; i <length; i++) {
                n.next=list.get(i);
                n=n.next;
            }
            for (int i = 0; i <length; i++) {
                t=(queue.isEmpty())?null:queue.remove();
                assert t != null;
                if (t.left!=null){
                    queue.add(t.left);
                }
                if (t.right!=null){
                    queue.add(t.right);
                }
            }
        }
        return root;
    }
}
