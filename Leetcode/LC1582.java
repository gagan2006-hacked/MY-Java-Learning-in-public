package com.Leetcode;

public class LC1582 {
    public static int numSpecial(int[][] mat) {
        int c=0;
        for (int i = 0; i <mat.length; i++) {
            for (int j = 0; j <mat[i].length; j++) {
                if (mat[i][j]==1&&isSpecial(mat,i,j)){
                    c++;
                }
            }
        }
        return c;
    }

    private static boolean isSpecial(int[][] mat, int row, int col) {
        boolean rowWise;
        boolean colWise;
        int c=0;
        for (int co = 0; co <mat[row].length; co++) if (mat[row][co] == 1) c++;
        rowWise=c==1;c=0;
        for (int ro = 0; ro <mat.length; ro++) if (mat[ro][col] == 1) c++;
        colWise=c==1;
        return rowWise&&colWise;
    }

    public static void main(String[] args) {
        System.out.println(numSpecial(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }
}
