package com.Leetcode;

import com.sun.source.tree.Tree;

import java.util.*;

public class LC987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>result=new ArrayList<>();
        if (root==null){
            return result;
        }
        HashMap<Integer,List<Integer>>db=new HashMap<>();
        Queue<Pair> bfs = new ArrayDeque<>();
        bfs.offer(new Pair(root, 0));
        int col=0;
        int min=0;
        int max=0;
        while (!bfs.isEmpty()){
            Pair remove = bfs.poll();
            TreeNode t = remove.node;
            col = remove.col;
            if (t!=null){
                if (!db.containsKey(col)){
                    db.put(col,new ArrayList<>());
                }
                db.get(col).add(t.val);
                min=Math.min(min,col);
                max=Math.max(max,col);
                bfs.add(new Pair(t.left, col - 1));
                bfs.add(new Pair(t.right, col + 1));
            }
        }
        for (int i = min; i <=max; i++) {
            result.add(db.get(i));
        }
        return result;
   }
}
class Pair {
    TreeNode node;
    int col;

    Pair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}

