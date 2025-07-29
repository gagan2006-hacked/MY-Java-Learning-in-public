package com.Leetcode;

public class LC754NOTSUBMIT {
    public static int reachNumber(int target) {
        int start=0;
        int steps=1;
        int totalSteps=steps;
        while (start!=target){
            long sum=start+steps;
            totalSteps=steps;
            if (sum<=target){
                start+=steps;
            } else if (sum > target) {
                start -= steps;
            }
            steps++;
        }
        return totalSteps;
    }

    public static void main(String[] args) {
        System.out.println(reachNumber(2));
        int sum=0;
        for (int i = 1; i<10; i++) {
            sum+=i;
            System.out.println(sum);
        }
    }
}
