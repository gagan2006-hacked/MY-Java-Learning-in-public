package com.OOPs;

public class SegTree {
    public static class Tode{
        int val;
        int startRange;
        int endRange;
        Tode left;
        Tode right;

        public Tode(int val){
            this.val=val;
        }
        public Tode(int startRange,int endRange){
            this.startRange=startRange;
            this.endRange=endRange;
        }
    }
    private Tode root;
    public SegTree(){

    }

    public void insert(int []arr){
        this.root=constructTree(arr,0,arr.length-1);
    }

    private Tode constructTree(int[] arr, int start, int end) {
        if (start==end){
            Tode tode=new Tode(start,end);
            tode.val=arr[start];
            return tode;
        }
        Tode list=new Tode(start,end);
        int mid=start+(end-start)/2;

        list.left=constructTree(arr,start,mid);
        list.right=constructTree(arr,mid+1,end);
        list.val=list.left.val+list.right.val;
        return list;
    }
}
