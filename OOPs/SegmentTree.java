package com.OOPs;

public class SegmentTree {
    class MyNode {
        int data;
        int startInterval;
        int endInterval;
        MyNode left;
        MyNode right;

        public MyNode(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private MyNode root;

    public SegmentTree(int[] arr) {
        root = build(arr, 0, arr.length - 1);
    }

    private MyNode build(int[] arr, int s, int e) {
        if (s == e) {
            MyNode node = new MyNode(s, e);
            node.data = arr[s];
            return node;
        }

        int mid = (s + e) / 2;
        MyNode node = new MyNode(s, e);
        node.left = build(arr, s, mid);
        node.right = build(arr, mid + 1, e);
        node.data = node.left.data * node.right.data;
        return node;
    }

    public int getDataOfInterval(int s, int e) {
        return getDataOfInterval(root, s, e);
    }

    private int getDataOfInterval(MyNode node, int s, int e) {
        if (node == null || s > e) return 1;

        // Complete overlap
        if (node.startInterval >= s && node.endInterval <= e)
            return node.data;

        // No overlap
        if (node.endInterval < s || node.startInterval > e)
            return 1;

        // Partial overlap
        return getDataOfInterval(node.left, s, e) * getDataOfInterval(node.right, s, e);
    }
}