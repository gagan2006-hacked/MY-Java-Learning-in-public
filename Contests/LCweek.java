package com.Contests;

import java.util.Arrays;

public class LCweek {

        public static long maxProfit(int[] prices, int[] strategy, int k) {
            long max = Long.MIN_VALUE;
            long profit=getprofit(prices,strategy);
            int []ogstat= Arrays.copyOf(strategy,strategy.length);
            int changeTo0=k/2;
            int changeTo1=k/2;
            for (int i =0; i <prices.length-1; i++) {
                if (prices[i]>prices[i+1]){
                    if (changeTo0!=0){
                        strategy[i]=0;
                        changeTo0--;
                    }
                }else if (changeTo0==0&&changeTo1!=0){
                    strategy[i]=1;
                    changeTo1--;
                }
                if (changeTo0==0&&changeTo1==0){
                    profit=Math.max(profit,getprofit(prices,strategy));
                    strategy=Arrays.copyOf(ogstat,ogstat.length);
                    changeTo0=k/2;
                    changeTo1=k/2;
                }
            }
            return profit;
        }

        private static long getprofit(int[] prices, int[] strategy) {
            long profit=0;
            for (int i = 0; i <prices.length; i++) {
                profit+=((long) prices[i] *strategy[i]);
            }
            return profit;
        }


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{5,8},new int[]{-1,-1},2));
    }
}
