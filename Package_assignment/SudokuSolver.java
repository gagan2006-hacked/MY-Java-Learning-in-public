package com.Package_assignment;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] sudokuGrid = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        int[][] sudoku = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if (solver(sudokuGrid)){
            display(sudokuGrid);
        }else {
            System.out.println("not solve able");
        }
        display(sudoku);
        /*if (solverUpdate(sudoku,0,0)){
            System.out.println();
            display(sudoku);
//            System.out.println(solved(sudoku));
        }
        if (solverUpdate(sudokuGrid,0,0)){
            System.out.println();
            display(sudokuGrid);
//            System.out.println(solved(sudoku));
        }*/

//        System.out.println(solved(sudokuGrid));
    }
    public static boolean solver(int [][]board){
        int n=board.length;
        int row=-1;
        int col=-1;
        boolean emptyPlace=true;
        for (int i =0;i<n;i++){
            if (!emptyPlace){
                break;
            }
            for (int j = 0; j<n ; j++) {
                if (board[i][j]==0){
                    row=i;
                    col=j;
                    emptyPlace=false;
                    break;
                }
            }
        }
        if (emptyPlace){
            return true;
        }
//        back tracking
        for (int i = 1; i <=9; i++) {
            if (isSafeToKeep(board,row,col,i)){
                board[row][col]=i;
                if (solver(board)) {
                    return true;
                }
                else {
                    board[row][col]=0;
                }
            }

        }
       return false;
    }
    private static void display(int[][]board){
        for (int[] row:board) {
            System.out.println(Arrays.toString(row));
        }
    }
    public static boolean isSafeToKeep(int[][]board,int row,int col,int num){
        if (numAlreadyPresentInRow(board,row,num) || numAlreadyPresentInCol(board,col,num)){
            return false;
        }
        if (gridCorrect(board,row-row%3,col-col%3,num)){
            return false;
        }
        return true;
    }

    private static boolean numAlreadyPresentInCol(int[][] board, int col, int num) {
        if (col>=0 && col<board.length){
            for (int row = 0; row < board.length; row++) {
                if (board[row][col]==num){
                    return true;
                }

            }
        }
        return false;
    }

    private static boolean numAlreadyPresentInRow(int[][] board, int row, int num) {
       if (row>=0 && row<board.length)
        for (int i = 0; i <board[row].length; i++) {
            if (board[row][i]==num){
                return true;
            }
        }
        return false;
    }
    public static boolean gridCorrect(int[][]board,int r,int c,int num){
        for (int i =r; i <r+3; i++) {
            for (int j =c; j <c+3;j++) {
                if (board[i][j]==num){
                    return true;
                }
            }

        }
        return false;
    }
    public static boolean solved(int[][]board){
        int n=board.length;
        int row=-1;
        int col=-1;
        boolean emptyPlace=true;
        for (int i =0;i<n;i++){
            if (!emptyPlace){
                break;
            }
            for (int j = 0; j<n ; j++) {
                if (board[i][j]==0){
                    row=i;
                    col=j;
                    emptyPlace=false;
                    break;
                }
            }
        }
        if (emptyPlace){
            for (int i = 0; i <board.length ; i++) {
                for (int j = 0; j <board.length; j++) {
                    if (numAlreadyPresentInRowForSolved(board,i,j,board[i][j]) || numAlreadyPresentInColForSolved(board,i,j,board[i][j])|| gridWorngForSolved(board,i-i%3,j-j%3,board[i][j])){
                        return false;
                    }
                }
            }
            return true;
        }else {
            return false;
        }
    }
    private static boolean numAlreadyPresentInRowForSolved(int[][] board, int row,int col,int num) {
        if (row>=0 && row<board.length) {
            for (int i = 0; i < board[row].length; i++) {
                if (i!=col) {
                    if (board[row][i] == num) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean numAlreadyPresentInColForSolved(int[][] board, int row,int col, int num) {
        if (col>=0 && col<board.length){
            for (int rowi = 0; rowi < board.length; rowi++) {
                if (rowi!=row) {
                    if (board[rowi][col] == num) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean gridWorngForSolved(int[][]board, int r, int c, int num){
        int count=0;
        for (int i =r; i <r+3; i++) {
            for (int j =c; j <c+3;j++) {
                if (board[i][j]==num){
                    count+=1;
                }
            }

        }
        if (count>1){
            return true;
        }
        return false;
    }
    /*public static boolean solverUpdate(int [][]board,int start,int end){
        int n=board.length;
        int row=-1;
        int col=-1;
        boolean emptyPlace=true;
        if (row==n){
            return false;
        }
        for (int i =start;i<n;i++){
            if (!emptyPlace){
                break;
            }
            for (int j =(i==start)?end:0; j<n ; j++) {
                if (board[i][j]==0){
                    row=i;
                    col=j;
                    emptyPlace=false;
                    break;
                }
            }
        }
        if (emptyPlace){
            return true;
        }
//        back tracking
        for (int i = 1; i <=9; i++) {
            if (isSafeToKeep(board,row,col,i)){
                board[row][col]=i;
                if ((col<n-1 )&&solverUpdate(board,row,col)) {
                    return true;
                } else if ((col==n-1)&&solverUpdate(board,row+1,0)) {
                    return true;
                } else {
                    board[row][col]=0;
                }
            }

        }
        return false;
    }*/

}