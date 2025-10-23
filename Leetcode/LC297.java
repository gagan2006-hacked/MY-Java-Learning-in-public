package com.Leetcode;

import java.util.*;

public class LC297 {
    public static String serialize(TreeNode root) {
        TreeNode treeNode=root;
        return serializeHelper(treeNode);
    }

    private static String serializeHelper(TreeNode treeNode) {
        if (treeNode==null){
            return "n";
        }
        String list=treeNode.val+",";
        list+=serializeHelper(treeNode.left)+",";
        list+=serializeHelper(treeNode.right);
        return list;
    }
    public TreeNode deserialize(String data) {
        List<String>list=new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(list);
    }

    private TreeNode deserializeHelper(List<String> list) {
        if (list.isEmpty()){
            return null;
        }
        String ch=list.removeFirst();
        if (ch.equals("n")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(ch));
        node.left=deserializeHelper(list);
        node.right=deserializeHelper(list);
        return node;
    }

    public static void main(String[] args) {
    TreeNode treeNode=new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
    TreeNode t=new TreeNode(1);
    System.out.println(serialize(treeNode));
}
}
