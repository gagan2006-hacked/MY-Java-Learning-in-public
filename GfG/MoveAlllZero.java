package com.GfG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.Dissper_elle.swap;

public class MoveAlllZero {
    public static void main(String[] args) {
        move1(new int[]{0 ,0, 0, 3, 1, 4});
    }


    //brute force
    public static void move(int[]arr){
        List<Integer>list=new ArrayList<>();
        int []result=new int[arr.length];
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=0){
                list.add(i);
            }
        }int i=0;
        while(!list.isEmpty()){
            if (i<arr.length) {
                result[i] = arr[list.get(0)];
                i++;
            }
            list.removeFirst();
        }
        System.out.println(Arrays.toString(result));
    }

    public static void move1(int []arr){
        int np=-1;
        int zp=-2;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]!=0){
                np=i;
            }
            if ((np>zp)&&arr[i]==0){
                zp=i;
            }
            if ((np>=0)&&((zp>=0)&&(np>zp)&&arr[np]!=0)){
                swap(np,zp,arr);
                i=zp;
                np=zp+1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    void pushZerosToEnd(int[] arr) {
        int nonZeroIndex = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[nonZeroIndex++] = arr[i];
            }
        }

        // Fill the rest of the array with zeros
        while (nonZeroIndex < arr.length) {
            arr[nonZeroIndex++] = 0;
        }
    }
}
