package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dissper_elle {
    public static void swap(int a,int b,int arr[]){
        try{int temp = arr[a];
            arr[a]=arr[b];
            arr[b]=temp;}
        catch (Exception e){

        }
    }

    public static void sort_c(int []arr,int n){
        int i=0; List<Integer> mis =new ArrayList<>();

        while (i< arr.length){
            int correct= arr[i] -1;
            if (arr[i]!= arr[correct]){
                 swap(correct,i,arr);
            }else {
                i++;
            }



        }
        mis=findmiss(arr,n);
        System.out.println(mis);

    }


    private static List<Integer> findmiss(int arr[],int n){
        List<Integer> lis =new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=(i+1)){
                lis.add(arr[i]);
                lis.add(i+1);
            }
        }
        return lis;
    }

    public static void main(String[] args) {
        int []arr={1,2,2,4};
        System.out.println(Arrays.toString(arr));
        sort_c(arr, arr.length);
       System.out.println(Arrays.toString(arr));

    }
}
