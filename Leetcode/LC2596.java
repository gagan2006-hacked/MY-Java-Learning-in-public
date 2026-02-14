package com.Leetcode;

public class LC2596 {
    public boolean checkValidGrid(int[][] grid) {
        validateIt(grid,0,0);
        return checkIt(grid);
    }

    private boolean checkIt(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[i].length; j++) {
                if (grid[i][j]!=0)return false;
            }
        }
        return true;
    }

    private void validateIt(int[][] grid,int row,int col) {
        if (grid.length<=row||col>=grid.length)return;
        int n=grid.length;
        grid[row][col]=0;
        if (row>=2){
            if (col>0&&grid[row-2][col-1]!=0){
                validateIt(grid,row-2,col-1);
            }
            else {
                if (grid[row-2][col+1]!=0) validateIt(grid,row-2,col+1);
            }
        }
        if (row < n - 2) {
            if (col>0 &&(grid[row+2][col-1]!=0)){
                validateIt(grid,row+2,col-1);
            } else {
                if (grid[row+2][col+1]!=0)validateIt(grid,row+2,col+1);
            }
        }
        if (col >=2) {
            if (row>0&&(grid[row-1][col+2]!=0)){
                validateIt(grid,row-1,col+2);
            } else {
                if (grid[row+1][col+2]!=0)validateIt(grid,row+1,col+2);
            }
        }
        if (col<n-2) {
            if (row>0&&(grid[row-1][col+2]!=0)){
                validateIt(grid,row-1,col+2);
            } else {
                if (grid[row+1][col+2]!=0)validateIt(grid,row+1,col+2);
            }
        }
    }

    public static void main(String[] args) {
        LC2596 lc2596=new LC2596();
        System.out.println(lc2596.checkValidGrid(new int[][]{{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}}));
    }
}
