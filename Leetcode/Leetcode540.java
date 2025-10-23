package com.Leetcode;

public class Leetcode540 {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,5,5}));
    }
    public static int singleNonDuplicate(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            // Ensure mid is even for correct pairing
            if (mid % 2 == 1) mid--;

            if (arr[mid] == arr[mid + 1]) {
                // Unique is in the right half
                low = mid + 2;
            } else {
                // Unique is in the left half or at mid
                high = mid;
            }
        }

        return arr[low];
    }

    /*
    public static int singleNonDuplicate(int[] arr) {
        return iterate(arr,0,arr.length-1);
    }
    public static int iterate(int []arr,int s,int e){
        while (s<=e){
            if (s==e){
                return arr[s];
            }
            if ((arr[s]==arr[s+1])&&arr[e]==arr[e-1]){
                s=s+2;
                e=e-2;
            }else if (s!=0&&(arr[s]==arr[s-1])&&(arr[s]<arr[s+1])&& arr[e]==arr[e-1]){
                s=s+1;
                e=e+2;
            } else if((arr[s]!=arr[s+1]) && arr[e]==arr[e-1]) {
                e=e-2;
            } else if ((arr[s]==arr[s+1])&&arr[e]!=arr[e-1]) {
                s=s+2;
            }
        }
        return arr[s];
    }*/
}
