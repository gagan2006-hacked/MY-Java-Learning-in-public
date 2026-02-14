package com.Package_assignment;
//import java.util.Arrays;
public class Queens {
    public static void main(String[] args) {
        boolean[][]board=new boolean[4][4];
        placeQueens(board,0);
        System.out.println( placeQueen(board,0));

    }
    public static void placeQueens(boolean[][]board,int row){
        if (row==board.length){
            display(board);
            System.out.println();
            return;
        }
        for (int col = 0; col <board.length; col++) {
            if (!isSafeToplace(board,row,col)){
                continue;
            }
            if (!board[row][col]){
                board[row][col]=true;
                placeQueens(board,row+1);
                board[row][col]=false;
            }

        }

    }

    private static boolean isSafeToplace(boolean[][] board, int row, int col) {
        if (row==0){
            return true;
        }
        for (int i = 0; i <=row ; i++) {
            if (board[i][col]){
                return false;
            }
        }
        if (leftDiagonal(board,row,col)&&righDiagonal(board,row,col)){
            return true;
        }
        return false;
    }

    private static boolean righDiagonal(boolean[][] board, int row, int col) {
        if (board[row][col]){
            return false;
        }if (row==0 || col==board.length-1){
            return true;
        }
        return righDiagonal(board,row-1,col+1);

    }

    private static boolean leftDiagonal(boolean[][] board, int row, int col) {
        if (board[row][col]){
            return false;
        }if(col==0||row==0) {
            return true;
        }
        return leftDiagonal(board,row-1,col-1);
    }
    private static void  display(boolean[][]board){
        for(boolean[]row1: board){
          for (boolean ele:row1){
              if (ele){
                  System.out.print(" Q ");
              }else {
                  System.out.print(" x ");
              }
          }
            System.out.println();
        }
    }

    public static int placeQueen(boolean[][]board,int row){
        if (row==board.length){
/*            display(board);
            System.out.println();*/
            return 1;
        }
        int count =0;
        for (int col = 0; col <board.length; col++) {
            if (!isSafeToplace(board,row,col)){
                continue;
            }
            if (!board[row][col]){
                board[row][col]=true;
                count+=placeQueen(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }


}