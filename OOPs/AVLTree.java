package com.OOPs;
import com.MOCK.TreeNode;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class AVLTree {
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
        return rotate(node);
    }
    private Node rotate(Node node){
        if (height(node.left)-height(node.right)>1){
            if (height(node.left.left)-height(node.left.right)>0){
                return rightRotate(node);
            }
            if (height(node.left.left)-height(node.left.right)<0){
                 node.left=leftRotate(node.left);
                 return rightRotate(node);
            }
        }
        if (height(node.left)-height(node.right)<-1) {
            if (height(node.right.right)-height(node.right.left)>0){
                return leftRotate(node);
            }
            if (height(node.right.right)-height(node.right.left)<0){
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node leftRotate(Node c) {
        Node p=c.right;
        Node t=p.left;

        c.right=t;
        p.left=c;

        p.height = Math.max(height(p.left), height(p.right) )+1;
        c.height = Math.max(height(c.left), height(c.right) )+1;
        return p;
    }

    private Node rightRotate(Node p) {
        Node c=p.left;
        Node t=c.right;

        p.left=t;
        c.right=p;

        p.height = Math.max(height(p.left), height(p.right) )+1;
        c.height = Math.max(height(c.left), height(c.right) )+1;
        return c;
    }

    public void display(){
       Node r=root;
        print(r,0);
    }
    private void print(Node node, int level){
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

    public TreeNode getAll(){
        Node node=root;
        return getAllHelper(node);
    }

    private TreeNode getAllHelper(Node node) {
        if (node==null){
            return null;
        }
        TreeNode r=new TreeNode(node.val);
        r.left=getAllHelper(node.left);
        r.right=getAllHelper(node.right);
        return r;
    }

    public static void main(String[] args) {
        AVLTree binTree=new AVLTree();
        for (int i =1; i <10; i++) {
            binTree.insert(i);
        }
        binTree.display();
    }
}
