package com.MOCK;

import com.Package_assignment.TicTacToe;

public class Mock3 {
    public String tictactoe(int[][] moves) {
        if (moves.length<5){
            return "Pending";
        }

        char grid[][]=new char[3][3];
        TicTacToe toe=new TicTacToe(grid,"A","B");
        setBoard(grid,moves);
        char ch=toe.checkWin(moves.length);
        if (ch=='C'){
            if (moves.length==9){
                return "Draw";
            }else {
                return "Pending";
            }
        }else {
            if (ch=='x'){
                return "A";
            }else{
                return "B";
            }
        }
    }

    private void setBoard(char[][] grid, int[][] moves) {
        boolean pl=true;
        for (int[] cordinates:moves){
            int row=cordinates[0];
            int col=cordinates[1];
            if (pl){
                grid[row][col]='x';
                pl=!pl;
            }else {
                grid[row][col]='o';
                pl=!pl;
            }
        }
    }

    public static void main(String[] args) {
        Mock3 m=new Mock3();
        System.out.println(m.tictactoe(new int[][]{{1,0},{2,2},{2,0},{0,1},{1,1}}));
//        [[0,0],[2,0],[1,1],[2,1],[2,2]]
    }
}
