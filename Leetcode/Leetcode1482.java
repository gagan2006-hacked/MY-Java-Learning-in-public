package com.Leetcode;

import java.util.Arrays;

class  Leetcode1482{
   /* public int minDays(int[] bloomDay, int m, int k) {
        return toIterate(bloomDay,k,m);
    }
     public static int toIterate(int[] arr, int k,int m) {
        int min = arr[0], sum = 0;
        for (int num : arr) {
            min = Math.min(min, num);
            sum =Math.max(sum,num);
        }
        return isPossiable(arr,min,sum,m,k);
    }

     private static int isPossiable(int[] arr, int min, int max,int m,int k) {
        boolean []ar=new boolean[arr.length];
        int trueCount=0;
        int ans=-1;
        boolean b=false;
        if (ar.length>=(m*k)){
        while (min<=max){
            int mid=(max+min)/2;
            if ((min==mid)&&mid==max){
                return mid;
            }
            for (int i=0;i<arr.length;i++){
                if (arr[i]<=mid){
                    ar[i]=true;
                    trueCount+=1;
                }else {
                    ar[i]=false;
                }
            }

            if (trueCount>=(k*m)){
                if(isDone(ar,m,k,trueCount)){
                    ans=mid;
                    max=mid;
                    b=true;
                }else {
                    b=false;
                }
                trueCount=0;
            }else {
                b=false;
            }
            if ((!b)&&trueCount<(k*m)){
                min=mid+1;
                trueCount=0;
            }
        }}
        return ans;
    }

    private static boolean isDone(boolean[] ar, int m, int k,int count) {
        if (k==1){
            if (count==m*k){
                return true;
            }
        }
        int bouquet=0;
        int adjCount=0;
        int i=0;
        while (bouquet<m){
            if (i==ar.length){
                return false;
            }
           while ((i<ar.length)&&adjCount<k){
               if (ar[i]){
                   adjCount+=1;
               }else {
                   if (adjCount!=0){
                       adjCount-=1;
                   }
               }
               i++;
           }

            if (adjCount==k){
                bouquet+=1;
                adjCount=0;
            }

        }
        return bouquet==m;
    }*/

    public static int toIterate(int []arr,int m,int k){
        int min=1000000000;
        int max=-222222222;
        if ((long)m*k>arr.length){
//            System.out.println();
            return -1;
        }
        for (int ele:arr){
            min=Math.min(min,ele);
            max=Math.max(max,ele);
        }
        return toIterateHelper(arr,m,k,min,max);
    }

    private static int toIterateHelper(int[] arr, int m, int k, int s, int e) {
        int count=0;
        boolean []board=new boolean[arr.length];
        int mid=0;
        while (s<e){
            mid=(s+e)/2;
            count=0;
            for (int i=0;i<arr.length;i++){
                if (arr[i]<=mid){
                    board[i]=true;
                    count+=1;
                }else {
                    board[i]=false;
                }
            }
            if (isPossiable(board,m,k,count)){
                e=mid;
            } else {
                s=mid+1;
            }
//            System.out.println(mid);
        }
//        System.out.println(s);
        return s;
    }

    private static boolean isPossiable(boolean[] board, int m, int k, int count) {
        if (count<(m*k)){
            return false;
        }
        int i=0;
        int bought=0;
        int flower=0;
        while (bought<m){
            if (i==board.length){
                return false;
            }
            while (i<board.length){
                if (flower==k){
                    flower=0;
                    if (bought==m){
                        return true;
                    }
                    bought++;
                }
                if (board[i]){
                    flower++;
                }else {
                    flower=0;
                }
                i++;
            }if (flower==k){
                flower=0;
                if (bought==m){
                    return true;
                }
                bought++;
            }
        }
        return bought==m;
    }

    public static void main(String[] args) {
        int []arr=new int[]{70545,40667,26392,42712,39599,8012,27194,71384,58079,2123,66655,48459,92802,16345,43374,15924,5480,48766,38512,44416,50530,14405,42803,4953,44480,31455,12440,72556,3593,74130,59278,72043,9508,66855,74237,46991,53829,61978,8137,47408,18152,3439,20331,28085,43180,36650,6053,62782,91043,32640,62145,79424,32256,89353,96289,85104,91235,80088,96025,59996,99511,24387,36850,21709,21253,45745,46148,80258,9365,27085,11183,38053,44747,24038,91223,32454,58318,77940,20208,98572,842,31307,90663,46331,8786,32234,24599,30552,78551,67424,19443,45};
//        toIterate(arr,4,2);
        System.out.println(toIterate(arr,89945, 32127));
    }
}