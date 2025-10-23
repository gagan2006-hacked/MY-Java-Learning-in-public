package com.Contests;

public class MaxKTO {
    public static int sortPermutation(int[] arr) {
        int i=0;
        int k=0;
        int swaps=0;
        boolean first=true;
        while (i<arr.length&&swaps<1){
            if (arr[i]!=i &&(first||(arr[i]&arr[arr[i]])==k)){
                k=Math.max(arr[i]&arr[arr[i]],k);
                swap(arr,i,arr[i]);
                swaps++;
                first=false;
            }
            i++;
        }
        return k;
    }

    private static void swap(int []arr,int i,int j) {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    public static void main(String[] args) {
        System.out.println(sortPermutation(new int[]{0,2,3,1}));
    }
}
