package com.OOPs;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        return solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (!isCorrectCol(board,row,board[row][col])){
                    return false;
                }
                if (!isCorrectCol(board,col,board[row][col])){
                    return false;
                }
            }
        }
        for (int row = 0; row < board.length; row+=3) {
            for (int col = 0; col <board.length ; col+=3) {
                if (!isCorrectGrid(board,row,col,board[row][col])){
                    return false;
                }
            }
        }
        return true; // Board completely filled
    }

    public boolean isCorrectRow(char [][]board,int row,char num){
        int rowCount=0;
        for (int i = 0; i <board[row].length; i++) {
            if (board[row][i]==num){
                rowCount+=1;
            }
        }
        return rowCount==1;
    }
    private boolean isCorrectCol(char[][]board,int col,char num){
        int colCount=0;
        for (int i = 0; i <board.length ; i++) {
            if (board[i][col]==num){
                colCount+=1;
            }
        }
        return colCount==1;
    }
    public boolean isCorrectGrid(char[][]board,int row,int col,char num){
        int gridCount=0;
        for (int i=row;i<row+3;i++){
            for (int j = col; j <col+3 ; j++) {
                if (board[i][j]==num){
                    gridCount+=1;
                }
            }
        }
        return gridCount==1;
    }
}
