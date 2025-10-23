package com.Package_assignment;

import java.util.Arrays;
import java.util.Random;


public class TicTacToe {
    public static void main(String[] args) {
        boolean[][]booleans=new boolean[3][3];
//        ticTac(booleans,0,0,true);
    }
    //solving for x user
    /*public static void ticTac(boolean [][]board,int row,int col,boolean user,Random random){
        if (row>board.length-1){
            for (boolean[] b:board){
                System.out.println(Arrays.toString(b));
            }
            System.out.println();
            return;
        }
        if (col>board.length-1){
            ticTac(board,row+1,0,user);
            return;
        }
        if (ticTacSolved(board,row,col)) {
            return;
        }
        row=random.nextInt(0,board.length);

    }

    private static boolean ticTacSolved(boolean[][] board, int row, int col) {
        if (row>=0 && row<board.length && col>=0 && col<board.length){
            if (solvedThroughrow(board,row,col) || solvedThroughcol(board,row,col) || solvedThroughtDiagonal(board,row,col)){
                return true;
            }
        }
        return false;
    }

    private static boolean solvedThroughtDiagonal(boolean[][] board, int row, int col) {
//        if in (0,0)
        if (row==0 && col==0){
            return checkDiagonalUpper(board,row,col);
        }
//        if in (2,0)
        if (row==board.length-1 && col==0){
            return checkDiagonalLower(board,row,col);
        }
//        if in (2,2)
        if (row==board.length-1 && col==board.length-1){
            return checkDiagonalUpper(board,0,0);
        }
        return false;
    }

    private static boolean checkDiagonalLower(boolean[][] board, int row, int col) {
        if (row==0 || col==board.length-1){
            return true;
        }if (board[row][col]){
            return checkDiagonalLower(board,row-1,col+1);
        }
        return false;
    }

    private static boolean checkDiagonalUpper(boolean[][] board, int row, int col) {
        if (row==board.length || col==board.length){
            return true;
        }
        if (board[row][col]){
            return checkDiagonalUpper(board,row+1,col+1);
        }
        return false;
    }

    private static boolean solvedThroughcol(boolean[][] board, int row, int col) {
        boolean colCheck =false;
        if (row>=0 && row<board.length && col>=0 && col<board.length){
            for (int i = 0; i <board.length ; i++) {
                if (board[i][col]){
                    colCheck =true;
                    continue;
                }else {
                    return false;
                }
            }
        }
        return colCheck;
    }

    private static boolean solvedThroughrow(boolean[][] board, int row, int col) {
        boolean rowCheck=false;
        if (row>=0 && row<board.length && col>=0 && col<board.length){
            for (int i = 0; i <board.length; i++) {
                if (board[row][i]){
                    rowCheck=true;
                    continue;
                }else {
                    return false;
                }
            }
        }
        return rowCheck;
    }*/

}
