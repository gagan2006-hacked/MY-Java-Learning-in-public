package com.Leetcode;

import java.util.Arrays;

import static com.company.Dissper_elle.swap;

public class LC80 {
    /*public static int removeDuplicates(int[] arr) {
        if (arr.length<3){
            return arr.length;
        }
        int count=0;
        int i=-1;
        boolean g=false;
        for (int j = 2; j <arr.length ; j++) {
            if (arr[j]==arr[j-2]){
                if (g){
                    continue;
                }
                i=j;
                g=true;
                count=i;
            }
            else {
                if (i!=-1){
                 count=setIt(arr,i,j);
                 g=false;
                 i=-1;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return count;
    }*/

   /* private static int setIt(int[] arr, int i, int j) {
        while (i< arr.length && j<arr.length){
            arr[i]=arr[j];
            i++;
            j++;
        }
        return i;
    }*/

    public static void main(String[] args) {
        int []arr=new int[]{0,1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
//        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] arr) {
        int ind;
        int k= arr.length;
        int i=2;
        while (i<arr.length-2){
            
        }
        return k;
    }
}
