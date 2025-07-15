package com.Leetcode;

public class LC1351 {
    public static int countNegatives(int[][] grid) {
       int num=0;
        for (int i = 0; i < grid.length; i++) {
            num+=bSearch(grid,i);
        }
        return num;
    }
    public static int bSearch(int [][]arr,int row){
        int s=0;
        int e=arr[row].length-1;
        int noNeg=0;
        int mid=0;
        int pos=e+1;
        while (s<=e) {
            mid = (s + e)/2;
            if (arr[row][mid]<0){
                pos=mid;
                e=mid-1;
            }else {
                s=mid+1;
            }
        }
        return arr[row].length-pos;
    }
    public static void main(String[] args) {
        int [][]arr=new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(arr));
    }
}
