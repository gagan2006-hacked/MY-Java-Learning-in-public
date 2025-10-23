package com.Package_assignment;

import com.company.Assignments;

import java.util.Arrays;
import java.util.Comparator;

import static com.company.Dissper_elle.swap;

public class ISort {
    public static void main(String[] args) {
        int []arr=new int[]{9,9,8,8,7,6,5,4,3,2};

        iSort(arr,1);
        System.out.println(Arrays.toString(arr));
    }
    public static void iSort(int[]arr,int point){
        if(point==0)return;
        if (point==arr.length){
            return;
        }
        if (arr[point-1]>arr[point]){
            swap(point,point-1,arr);
            iSort(arr,point-1);
        }
        iSort(arr,point+1);
    }


}
