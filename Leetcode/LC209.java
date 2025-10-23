package com.Leetcode;

public class LC209 {

    public static void main(String[] args) {
        int []arr=new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,arr));
    }
    public static int minSubArrayLen(int target, int[] arr) {
        if (arr.length==1){
            return (arr[0]==target)? arr.length:0;
        }
        int length=0;
        int s=0;
        int e=0;
        int sum=arr[s];
        while (e<arr.length){
            if (sum>=target){
                length=Math.min(length,(e-s+1));
                sum=sum-arr[s];
                s++;
//                length=Math.min(length,(e-s+1));
            }else {
                e++;
                if (e<arr.length) {
                    sum += arr[e];
                }
            }
        }
        return length;
    }

    // Binary search to find the largest index where prefixSum[i] <= required
    /*public static int binarySearch(int[] arr, int target, int end) {
        int s = 0;
        int e = end - 1;
        int ans = -1;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] <= target) {
                ans = mid;       // Valid candidate, try to go right
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }*/

}
