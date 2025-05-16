package com.company;

import java.util.Arrays;

public class Cyclic_sort {
    public static void swap(int a,int b,int arr[]){
        try{int temp = arr[a];
       arr[a]=arr[b];
        arr[b]=temp;}
        catch (Exception e){

        }
    }

    public static void sort_c(int []arr,int n){
        int start=0;
        for (start=0;start<=n-1;start++){
            if ((arr[start])== start ){
                continue;
            }else {
                swap(start,(arr[start]),arr);
            }
            System.out.println( findmiss(arr,n)+" is the missing elements");



        }


    }
    private static int  findmiss(int arr[],int n ){
        int ele=n;
        for (int i=0;i<=n-1;i++){
            if (arr[i]==i){
                continue;
            }else {
                ele=i;
               break;
            }
        }
        return ele;
    }
    public static void main(String[] args) {
 int []arr={0,1,2,5,4};
        System.out.println(Arrays.toString(arr));
        sort_c(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }
}
