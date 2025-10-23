package com.Leetcode;

public class LC134 {
    /*public static int canCompleteCircuit(int[] gas, int[] cost) {
        int index=-1;
        int gasTank=0;
        for (int i = 0; i < gas.length; i++) {
            if (gasTank+gas[i]>=cost[i]){
                gasTank=gasTank+gas[i];
                int j=i;
                index=i;
                while (gasTank>=cost[j]){
                    gasTank=gasTank-cost[j];
                    j++;
                    j=j%gas.length;
                    if (index==j){
                        return index;
                    }
                    gasTank+=gas[j];
                }
                index=-1;
            }

        }
       return index;
    } O(N^2)

    */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            // If we can't reach the next station from current start
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return totalGas >= totalCost ? start : -1;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
    }
}
