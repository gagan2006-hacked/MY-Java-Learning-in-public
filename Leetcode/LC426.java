package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC426 {
//    Premium question
    public static DL createDL(TreeNode root){
        List<Integer> list=new ArrayList<>(LC653.getValue(root));
        if (list.isEmpty()){
            return null;
        }
        DL node=new DL(list.getFirst());
        DL t=node;
        int i=0;
        int j=i+1;
        while (j<list.size()){
            DL dl=new DL(list.get(j));
            t.next=dl;
            dl.prev=t;
            t=t.next;
            i++;
            j++;
        }
        return node;
    }

    public static void main(String[] args) {
        DL dl=createDL(new TreeNode(8,new TreeNode(3,new TreeNode(1),new TreeNode(6)),new TreeNode(10,new TreeNode(9),new TreeNode(14))));
        System.out.println(dl);
    }
}
class DL
{
    int val;
    DL prev;
    DL next;

    public DL(int val) {
        this.val = val;
    }

    public DL(int val,DL prev, DL next) {
        this.val=val;
        this.prev = prev;
        this.next = next;
    }
    public DL(DL next){
        this.next=next;
    }
    public String toString(){
        StringBuffer s=new StringBuffer();
        DL t=this;
        while (t!=null){
            s.append(t.val).append("->");
            t=t.next;
        }
        s.append("null");
        return s.toString();
    }
}