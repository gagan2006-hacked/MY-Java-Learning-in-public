package com.Leetcode;

public class LC643 {
    public static double findMaxAverage(int[] arr, int k) {
        int s=0;
        int e=s+(k-1);
        double maxAvg=Double.NEGATIVE_INFINITY;
        if (e>=arr.length){
            return 0;
        }
        double sum=sumOF(arr,s,e);
        double avg=sum/k;
        while (e<arr.length){
            maxAvg=Math.max(maxAvg,avg);
            e++;
            if (e< arr.length) {
                sum = sum - arr[s] + arr[e];
                s++;
                avg=sum/k;
            }
        }
        return maxAvg;
    }

    private static double sumOF(int[] arr, int s, int e) {
        double sum=0;
        while (s<=e){
            sum+=arr[s];
            s++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
}
