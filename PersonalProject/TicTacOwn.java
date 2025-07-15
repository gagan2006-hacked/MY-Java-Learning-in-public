package com.PersonalProject;

import javax.swing.*;
import java.util.Scanner;

public class TicTacOwn {
    public static void main(String[] args) {
        JFrame frame=new JFrame("Tic Tac Toe Game" );
//        entryPage(frame);
        Scanner in = new Scanner(System.in);
        System.out.println("enter the name of Player \'X\'");
        String playerX = in.next();
        System.out.println("enter the name of Player \'O\'");
        String playerO = in.next();
        createGrid(frame);

        char [][]board=new char[3][3];
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j]=' ';
            }
        }
        int entryDone=0;
        boolean gameOver=false;
        while (!gameOver){


        }
    }
    public static boolean gameWon(char [][]board){
        int row=-1;
        int col=-1;
        boolean foundMove=false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j]!=' '){
                    row=i;
                    col=j;
                    if (hasWon(board,row,col)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean hasWon(char[][] board, int row, int col) {
        char player=board[row][col];

        if (checkInCol(board,row,col) || checkInRow(board,row,col)|| checkInDiagonal(board,row,col)){
            return true;
        }
        return false;
    }

    private static boolean checkInDiagonal(char[][] board, int row, int col) {
        char toCheck=board[row][col];
//        top left
        if ( row==0 && col==0){
            while (row< board.length && col<board.length){
                if (toCheck!=board[row][col]){
                    return false;
                }
                row=row+1;
                col=col+1;
            }
            return true;
        }
//        bottom left
        else if (row==board.length-1 && col==0) {
            while (row>=0&& col< board.length){
                if (toCheck!=board[row][col]){
                    return false;
                }
                row=row-1;
                col=col+1;
            }
            return true;
        }
//        top right
        else if (row==0 && col== board.length-1) {
            while (row< board.length && col>=0){
                if (toCheck!=board[row][col]){
                    return false;
                }
                row=row+1;
                col=col-1;
            }
            return true;
        }
//        bottom right
        else if (row== board.length-1 && col== board.length-1) {
            while (row>=0 && col>=0){
                if (toCheck!=board[row][col]){
                    return false;
                }
                row-=1;
                col-=1;
            }
            return true;
        }
        return false;
    }

    private static boolean checkInRow(char[][] board, int row, int col) {
        char toCheck=board[row][col];
        for (int i = 0; i < board.length;i++) {
            if (toCheck!=board[row][col]){
                return false;
            }
        }
        return true;
    }

    private static boolean checkInCol(char[][] board, int row, int col) {
        char toCheck=board[row][col];
        for (int i = 0; i < board.length; i++) {
            if (toCheck!=board[i][col]){
                return false;
            }
        }
        return true;
    }

    private static void printBoard(char[][] board) {

    }

    private static void createGrid(JFrame frame) {

    }

    private static void entryPage(JFrame frame) {

    }


}
