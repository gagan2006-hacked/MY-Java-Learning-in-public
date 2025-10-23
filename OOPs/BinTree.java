package com.OOPs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinTree {
    private static class Node{
        public int val;
        public Node left;
        public Node right;
        public int height;
        Node(int val){
            this.val=val;
        }
    }
    private Node root;
    public int height(Node node){
        return (node==null)?-1:node.height;
    }
    public void insert(int val){
        if (root==null){
            Node node=new Node(val);
            root=node;
            return;
        }
        Node node=root;
        root=insert(val,node);
    }
    private Node insert(int val,Node node){
        if (node==null){
            node=new Node(val);
            return node;
        }
        if (node.val>=val){
            node.left=insert(val,node.left);
        } else {
            node.right=insert(val,node.right);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }
    public void display(){
        Node r=root;
        print(r,0);
    }
    private void print(Node node,int level){
        if (node==null){
            return;
        }
        if (node.right!=null){
            print(node.right,level+1);
            for (int i = 0; i <level; i++) {
                System.out.print("\t\t");
            }
            System.out.println("\t["+node.right.val+"]");
        }
        if (level==0){
            System.out.println("["+node.val+"]");
        }
        if (node.left!=null){
            for (int i = 0; i <level; i++) {
                System.out.print("\t\t");
            }
            System.out.println("\t["+node.left.val+"]");
            print(node.left,level+1);

        }
    }
    public void bFS(){
         bFSHelper(root);
    }
    private void bFSHelper(Node node){
        Queue<Node> level=new ArrayDeque<>();
        if (node==null){
            return;
        }
        Node t=node;
        do {
            System.out.println(t.val);
            if (t.left!=null){
               level.add(t.left);
            }
            if (t.right!=null){
                level.add(t.right);
            }
            t=(level.isEmpty())?null:level.remove();
        }while (t!=null);
    }

    /* Chat gpt display
    public void display() {
        print(root, 0);
    }

    private void print(Node node, int level) {
        if (node == null) return;

        print(node.right, level + 1); // right subtree first

        for (int i = 0; i < level; i++) {
            System.out.print("\t\t"); // indent based on depth
        }
        System.out.println("[" + node.val + "]");

        print(node.left, level + 1); // then left subtree
    }*/




    public static void main(String[] args) {
        BinTree binTree=new BinTree();
        binTree.insert(10);
        binTree.insert(5);
        binTree.insert(15);
        binTree.insert(8);
        binTree.insert(4);
        binTree.insert(11);
        binTree.insert(17);
        binTree.insert(18);
        binTree.insert(13);
        binTree.insert(1);
        binTree.insert(2);
        binTree.display();

        binTree.bFS();
    }
}
