package com.FamCompany;

public class Knapsack {
    static int[] values = {300, 200, 400, 500};
    static int[] weights = {2, 1, 5, 3};
    static int max=0;
    public static int knapsack_BackTracking(int capacity, int n) {
        if (n<=0||capacity<=0)return 0;
        max=0;
        knapsack_BackTrackingHelper(capacity,n,0,0,0);
        return max;
    }

    private static int knapsack_BackTrackingHelper(int capacity, int n, int i,int totalValue,int totalWeight) {
        if (i>=n||totalWeight==capacity){
           max=Math.max(max,totalValue);
           return totalValue;
        }
        int value=values[i];
        int weight=weights[i];
        if (totalWeight+weight<=capacity) {
            totalValue += value;
            totalWeight += weight;
            knapsack_BackTrackingHelper(capacity, n, i + 1, totalValue, totalWeight);
            totalValue -= value;
            totalWeight -= weight;
        }
        return knapsack_BackTrackingHelper(capacity,n,i+1,totalValue,totalWeight);
    }

    public static void main(String[] args) {
        int n = values.length;
        int capacity = 10;
        System.out.println("\nMaximum value in Knapsack = " + knapsack_BackTracking(capacity, n));
    }
}
