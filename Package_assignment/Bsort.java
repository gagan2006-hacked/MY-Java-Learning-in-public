package com.Package_assignment;

import java.util.Arrays;

import static com.company.Dissper_elle.swap;

public class Bsort {
    public static void main(String[] args) {
        int []arr=new int[]{9,8,7,6,6,5,4,3,3,2,1,-2,1-2,3};
        bsort(arr,arr.length,1);
        System.out.println(Arrays.toString(arr));
        ISort.iSort(arr,1);
        System.out.println(Arrays.toString(arr));

    }
    public static void bsort(int []arr,int n,int j){
        if ( j>=n)return;
        if (n<=1)return;
        if (arr[j-1]>arr[j]){
            swap(j,j-1,arr);
            bsort(arr,n,j+1);
        }
        bsort(arr,n-1,1);
    }
    public static void bSort(int[] arr, int n) {
        // Base case: If array size is 1, it is already sorted
        if (n == 1) return;

        // Pass through the array and push the largest element to the end
        for (int j = 1; j < n; j++) {
            if (arr[j - 1] > arr[j]) {
                swap( j - 1, j,arr);
            }
        }

        // Recursive call for the next pass with a reduced size
        bSort(arr, n - 1);
    }


}
