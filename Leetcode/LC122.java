package com.Leetcode;

public class LC122 {
    public  static int maxProfit(int[] prices) {
        int totalProfit=0;
//        int prevProfit=0;
        int buyPrice=10000000;
        int sellPrice=0;
        boolean bought=false;
//        boolean flag=false;
        for (int i =0; i <prices.length-1; i++) {
            if (bought && ((prices[i]>prices[i+1]))){
                sellPrice=prices[i];
                totalProfit+=sellPrice-buyPrice;
                buyPrice=10000000;
                bought=false;
            }else if (prices[i]<prices[i+1]){
                buyPrice=Math.min(buyPrice,prices[i]);
                bought=true;
            }
        }
        if (bought){
            totalProfit+=(prices[prices.length-1]-buyPrice);
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int []a=new int[]{7,6,4,3,1};
        System.out.println(maxProfit(a));
    }


}
