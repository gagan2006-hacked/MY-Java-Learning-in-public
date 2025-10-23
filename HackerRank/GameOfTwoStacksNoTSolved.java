package com.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class GameOfTwoStacksNoTSolved {
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        int count = 0, sum = 0, i = 0, j = 0;

        // Take as many as possible from stack a
        while (i < a.size() && sum + a.get(i) <= maxSum) {
            sum += a.get(i);
            i++;
        }

        count = i;

        // Try taking from stack b and remove from a if needed
        while (j < b.size() && i >= 0) {
            sum += b.get(j);
            j++;
            while (sum > maxSum && i > 0) {
                i--;
                sum -= a.get(i);
            }
            if (sum <= maxSum) {
                count = Math.max(count, i + j);
            }
        }

        return count;
    }


    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();
        for (int i = 1; i <6; i++) {
            list.add(i);
        }
        List<Integer>list1=new ArrayList<>();
        for (int i = 6; i < 10; i++) {
            list1.add(i);
        }
        System.out.println(twoStacks(10,list,list1));
    }

}
