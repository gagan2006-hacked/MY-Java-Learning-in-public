package com.GfG;

import java.util.Arrays;

import static com.company.Dissper_elle.swap;

public class ReverseArray {
    public static void main(String[] args) {
        System.out.println(reverse(new int[]{10,9,8,7,6,5,4,3,2,1}));
    }
    public static boolean reverse(int []arr){
        int j=arr.length-1;
        for (int i = 0; i <(arr.length/2) ; i++) {
            swap(i,j,arr);
            j--;
        }
        System.out.println(Arrays.toString(arr));
        return true;
    }

}
