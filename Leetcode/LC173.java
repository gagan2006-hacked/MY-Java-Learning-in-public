package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC173 {
    List<Integer>data;
    int pointer=0;
    public LC173(TreeNode root) {
        data=inorder(root);
    }

    private List<Integer> inorder(TreeNode node) {
        if (node==null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        if (node.left!=null){
            list.addAll(inorder(node.left));
        }
        list.add(node.val);
        if (node.right!=null) {
            list.addAll(inorder(node.right));
        }
        return list;
    }
    public String toString(){
        return data.toString();
    }
    public int next() {
        if (pointer<data.size()){
            int i=pointer;
            pointer++;
            return data.get(i);
        }
        return -1;
    }

    public boolean hasNext() {
        return pointer<data.size();
    }

}
