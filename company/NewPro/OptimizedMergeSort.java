package com.company;

import java.util.Arrays;

public class OptimizedMergeSort {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int left, int right) {
        // Base case: If the array contains a single element, it's already sorted
        if (left >= right) {
            return;
        }

        // Find the middle index
        int mid = left + (right - left) / 2;

        // Recursively sort the left and right halves
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        // Merge the sorted halves
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        // Temporary arrays to hold the two halves
        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        // Merge the temporary arrays into the original array
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Add remaining elements from the left half
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        // Add remaining elements from the right half
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }
}
