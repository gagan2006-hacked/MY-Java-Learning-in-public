package com.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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
        int []arr=new int[]{1,1,1,2,2,3};
        LC80 lc80=new LC80();
        System.out.println(lc80.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
//        System.out.println(removeDuplicates(arr));
    }

    public  int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 2; // Start from the third element
        for (int i = 2; i < nums.length; i++) {
            // Check if the current element is different from the element two positions before
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, index)));
        return index;
    }
    /*public int removeDuplicates(int[] arr) {
        if (arr.length<=2){
            return arr.length;
        }
        int ind=-1;
        int i=0;
        int j=1;
        int count=1;
        int len=arr.length;
        while (j< len){
            if (arr[j]==arr[i]){
                if (ind==-1&&count>=2){
                    ind=j;
                }
                count++;
            }else if (arr[j]>arr[i]){
                if (ind!=-1){
                    int dd=ind;
                    int n=j;
                    while (n<len){
                        int t=arr[n];
                        arr[n]=arr[ind];
                        arr[ind]=t;
                        ind++;
                        n++;
                    }
                    len=Math.min(len,ind);
                    ind=-1;
                    i=dd-1;
                    j=dd;
                }
                count=1;
            }
            i++;
            j++;
        }
        if (ind!=-1){
            len=Math.min(len,ind);
        }
        System.out.println(Arrays.toString(arr));
        return len;
    }*/

}
