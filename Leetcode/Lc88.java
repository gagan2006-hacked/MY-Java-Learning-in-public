package Leetcod;

import java.util.Arrays;

public class Lc88 {
    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},3,new int[]{1,2,3},3);
    }
    public static void merge(int[] arr1, int m, int[] arr2, int n) {

            int i = m - 1;
            int j = n - 1;
            int k = m + n - 1;
            while (i >= 0 && j >= 0) {
                if (arr1[i] > arr2[j]) {
                    arr1[k--] = arr1[i--];
                } else {
                    arr1[k--] = arr2[j--];
                }
            }

            while (j >= 0) {
                arr1[k--] = arr2[j--];
            }


        System.out.println(Arrays.toString(arr1));
    }
}
