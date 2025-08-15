package com.Contests;

import java.util.Arrays;

public class FlipMatirx {
    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int row=x+(k-1);
        int col=y+(k-1);
        if (row>grid.length&&col>grid[x].length){
            return new int[][]{{-1,-1}};
        }
        while (x<row){
            for (int i = y; i <y+k; i++) {
                int t=grid[x][i];
                grid[x][i]=grid[row][i];
                grid[row][i]=t;
            }
            x++;
            row--;
        }

        return grid;
    }

    public static void main(String[] args) {
//        [9,10,11,12],[13,14,15,16]]©leetcode
//        [[3,4,2,3],[2,3,4,2]]
        /*int[][]a=new int[][]{{3,4,2,3},{2,3,4,2}};
        for (int []r:reverseSubmatrix(a,0,2,2)){
            System.out.println(Arrays.toString(r));
        }*/
        System.out.println(3&1);
    }
}
