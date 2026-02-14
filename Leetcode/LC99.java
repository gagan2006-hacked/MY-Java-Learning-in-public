package com.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LC99 {
    public static void recoverTree(TreeNode root) {
        TreeNode node=root;
        List<TreeNode> list=inorder(node);
        List<Integer>integerList=list.stream().map(TreeNode->TreeNode.val).toList();
        List<Integer>myList=new ArrayList<>(integerList);
        Collections.sort(myList);
        int f=-1;
        int s=-1;
        for (int i = 0; i <integerList.size(); i++) {
            if (!Objects.equals(integerList.get(i), myList.get(i))){
                if (f==-1){
                    f=i;
                } else if (s == -1) {
                    s=i;
                }
            }
        }
        if (f!=-1&&s!=-1){
            int t=list.get(s).val;
            list.get(s).val=list.get(f).val;
            list.get(f).val=t;
        }
    }

    private static List<TreeNode> inorder(TreeNode node) {
        List<TreeNode>list=new ArrayList<>();
        if (node==null)return list;
        list.addAll(inorder(node.left));
        list.add(node);
        list.addAll(inorder(node.right));
        return list;
    }

    public static void main(String[] args) {
//        TreeNode node=new TreeNode(4,new TreeNode(9),new TreeNode(6,new TreeNode(5),new TreeNode(2)));
//        TreeNode node=new TreeNode(1,new TreeNode(3,null,new TreeNode(2)),null);
        TreeNode node=new TreeNode(3,new TreeNode(1),new TreeNode(4,new TreeNode(2),null));
        recoverTree(node);
        System.out.println(node);
    }
}