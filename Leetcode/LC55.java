package com.Leetcode;

public class LC55 {
    public static boolean canJump(int[] arr) {
        int i=0;
        int indexSum=0;
        return canJumpHelper(i,arr);
    }

    private static boolean canJumpHelper(int i, int[] arr) {
        if (i>=arr.length-1){
            return true;
        }
        if (i!=0&&arr[i]==0){
            return false;
        }
        for (int j =i+arr[i];j>i;j--) {
            if (canJumpHelper(j,arr)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
}
