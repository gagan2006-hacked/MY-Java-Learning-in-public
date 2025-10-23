package com.Leetcode;

public class LC1518 {
    public static int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles<numExchange){
            return numBottles;
        }
        int tn=0;
        int waterBottle=numBottles;
        int emptyBottle=0;
        while (waterBottle+emptyBottle>=numExchange){
            tn+=waterBottle;
            int temp=(waterBottle+emptyBottle)/numExchange;
            emptyBottle=(waterBottle+emptyBottle)-temp*numExchange;
            waterBottle=temp;
        }
        if (waterBottle!=0){
            tn+=waterBottle;
        }
        return tn;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9,3));
    }
}
