package com.OOPs;

public class Node {
      int val;
      Node next;
      private Node Head;
      private Node tail;

     public Node(){
         this.val=-999999999;

     }
     public Node(int val){
         this.val=val;
     }
     public Node(Node node){
         this.next=node;
     }
     public void append(int val){
         if (Head==null){
             Node node=new Node(val);
             Head=node;
             tail=node;
             return;
         }
         Node node=new Node(val);
         tail.next=node;
         tail=node;
     }
     @Override
     public String toString(){
         if (Head == null) {
             return "[]";
         }
         Node temp=this.Head;
         String out="[";
         while (temp!=null){
             out+=temp.val+"->";
             temp=temp.next;
         }
         out=out+null+"]";
         return out;
     }
     public boolean isEmpty(){
         Node t=this;
         if (Head==null){
             return true;
         }
         return false;
     }
     public void insertRe(int val,int ind){
         if (this.isEmpty()){
             Node v=new Node(val);
             Head=v;
             tail=v;
             return;
         }
         if (ind==0){
             Node v=new Node(val);
             v.next=Head;
             Head=v;
             return;
         }
         Node t=this.Head;
         insertReHelp(val,ind,0,t);
     }

    private void insertReHelp(int val, int ind, int i, Node t) {
         if (i==ind-1){
             Node va=new Node(val);
             va.next=t;
             t.next=va;
             return;
         }
         insertReHelp(val,ind,i+1,t.next);
    }

    public void addAll(int []arr){
         if (Head==null){
             Node h=new Node(arr[0]);
             Head=h;
             tail=h;
             for (int i = 1; i < arr.length; i++) {
                 Node node=new Node(arr[i]);
                 tail.next=node;
                 tail=node;
             }
             return;
         }
         for (int i = 0; i < arr.length; i++) {
             Node node=new Node(arr[i]);
             tail.next=node;
             tail=node;
         }
     }
     public void add(int val,int index){
         if (Head==null){
             Node v=new Node(val);
             Head=v;
             tail=v;
             return;
         }
         Node v=new Node(val);
         Node t=Head;
         for (int i = 0; i <index; i++) {
             t= Head.next;
         }
         v.next=t.next;
         t.next=v;
     }
    public static void main(String[] args) {
        Node l=new Node();
        l.append(0);
        l.addAll(new int[]{1,3,4,5,6,7,8});
        l.add(2,2);
        l.insertRe(99,0);
        System.out.println(l);
    }
}

/*
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    }
}*/
