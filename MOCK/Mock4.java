package com.MOCK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Mock4 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer>list=inorder(root);
        TreeNode node=new TreeNode(list.get(0));
        TreeNode n=node;
        for (int i = 1; i <list.size(); i++) {
            n.right= new TreeNode(list.get(i));
            n=n.right;
        }
        return node;
    }
    private List<Integer> inorder(TreeNode node){
        List<Integer>list=new ArrayList<>();
        if (node==null)return list;
        list.addAll(inorder(node.left));
        list.add(node.val);
        list.addAll(inorder(node.right));
        return list;
    }

    public static int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min end day
        int day = 1, i = 0, res = 0;
        int n = events.length;

        while (i < n || !pq.isEmpty()) {

            if (pq.isEmpty() && i < n) {
                day = events[i][0];
            }

            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                res++;
                day++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(maxEvents(new
                int[][]{{1,2},{2,3},{3,4},{1,2}}));
//        {1,2},{2,3},{3,4},{1,2}
    }
}