package com.Leetcode;

import java.util.Arrays;

public class LC167 {
   /* public static int[] twoSum(int[] numbers, int target) {
        int toFind;
        int s=0;
        while (s<numbers.length-1){
            int j=s+1;
            toFind=target-numbers[s];
            while (j< numbers.length){
                if (numbers[j]==toFind){
                    return new int[]{s,j};
                }
                j++;
            }
            s++;
        }
        return new int[]{-1,-1};
    }
     Brute force;
    */
   public static int[] twoSum(int[] numbers, int target) {
       int toFind;
       int s=0;
       int end=numbers.length-1;
       while (s<end){
           int sum=numbers[s]+numbers[end];
           if (sum==target){
               return new int[]{s+1,end+1};
           }
           if (sum>target){
               end--;
           }
           else {
               s++;
           }
       }
       return new int[]{-1,-1};
   }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));

    }
}
