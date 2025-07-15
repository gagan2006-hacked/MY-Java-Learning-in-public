package com.Leetcode;

public class LC209 {

    public static void main(String[] args) {
        int []arr=new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,arr));
    }
    public static int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int total=Integer.MAX_VALUE;
        int len=total;
        int sum=0;
        int s=0;
        int end=0;
        while (s<=end&&end<n){
            if (sum+arr[end]>target){
                len=Math.min(end-s,len);
                sum=sum-arr[s];
                s++;
            }
            if (sum+arr[end]<=target){
                sum+=arr[end];
                end++;
            }
        }
        if (sum<target){
            len=0;
        }
        return len;
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
