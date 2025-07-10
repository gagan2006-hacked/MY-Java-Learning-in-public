package com.Leetcode;

public class LC121 {
    /*public static int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int toBuy=0;
        int toSell=prices.length-1;
        int profit=0;
        while(toBuy<toSell){
            int newProfit=prices[toSell]-prices[toBuy];
            if (newProfit <0){
                toBuy++;
            }else {
                profit=Math.max(profit,newProfit);
                if (prices[toBuy]>prices[toBuy+1]){
                    toBuy++;
                    continue;
                }
                if (prices[toSell]<prices[toSell-1]){
                    toSell--;
                    continue;
                }
            }
            toSell--;

        }
        return profit;
    }*/
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }



    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
