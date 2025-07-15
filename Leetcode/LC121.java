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
        if (prices.length==1){
            return 0;
        }
        int min=prices[0];
        int max=-1;
        int profit =0;
//        boolean flag=false;
        for (int i = 1; i <prices.length; i++) {
            if (max<prices[i]){
                max=prices[i];
                if (profit< max-min) {
                    profit = max - min;
                }
            }
            if (min>prices[i]){
                min=prices[i];
                max=-1;
            }
        }
        if (profit>0){
            return profit;
        }
        return 0;
    }



    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{3,2,6,5,0,3}));
    }
}
