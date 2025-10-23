package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][]board=new boolean[n][n];
        List<List<String>> result=new ArrayList<>();
        placeQueens(board,0,result);
        return result;
    }
    public  void placeQueens(boolean[][]board,int row,List<List<String>> result){
        if (row==board.length){
            addToList(board,result);
            return;
        }
        for (int col = 0; col <board.length; col++) {
            if (!isSafeToplace(board,row,col)){
                continue;
            }
            if (!board[row][col]){
                board[row][col]=true;
                placeQueens(board,row+1,result);
                board[row][col]=false;
            }

        }

    }

    public   boolean isSafeToplace(boolean[][] board, int row, int col) {
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

    public   boolean righDiagonal(boolean[][] board, int row, int col) {
        if (board[row][col]){
            return false;
        }if (row==0 || col==board.length-1){
            return true;
        }
        return righDiagonal(board,row-1,col+1);

    }

    public   boolean leftDiagonal(boolean[][] board, int row, int col) {
        if (board[row][col]){
            return false;
        }if(col==0||row==0) {
            return true;
        }
        return leftDiagonal(board,row-1,col-1);
    }
    public   void  addToList(boolean[][]board,List<List<String>> result){
        List<String> list=new ArrayList<>();
        String value="";
        for(boolean[]row1: board){
          for (boolean ele:row1){
              if (ele){
                  value+="Q";
              }else {
                  value+=".";
              }
          }
          list.add(value);
          value="";
        }
        result.add(list);
    }
}