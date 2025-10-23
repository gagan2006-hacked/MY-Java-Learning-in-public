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
        int []arr=new int[]{0,0,1,1,1,1,2,3,3};
        LC80 lc80=new LC80();
        System.out.println(lc80.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
//        System.out.println(removeDuplicates(arr));
    }
    public  int removeDuplicates(int[] arr) {
        int index=-1;
        int ind=-1;
        int k=0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]==arr[i-2]&&index==-1){
                index=i;
            }else if (index!=-1){
                ind=i;
                boolean f=false;
                while (ind<arr.length&&arr[ind]!=arr[ind-2]){
                    arr[index]=arr[ind];
                    ind++;
                    index++;
                    f=true;
                }
                if (f){
                    k=Math.max(k,index);
                    index=-1;
                }
            }
        }
        return k;
    }


}
