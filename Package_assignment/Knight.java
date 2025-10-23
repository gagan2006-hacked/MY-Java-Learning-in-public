package com.Package_assignment;

public class Knight {
    public static void main(String[] args) {
        boolean[][]board=new boolean[3][3];
//        placeNKnight(board,0,0,3);
        System.out.println(placeNKnightCount(board,0,0,3));
        System.out.println(knight(board,0,0,3));
    }
   /* public static void placeNKnight(boolean[][]board,int row,int colm,int k){
        if (k==0){
            display(board);
            System.out.println();
            return;
        }if (row==board.length-1 && colm==board.length-1){
            return;
        }
        if (colm==board.length){
            placeNKnight(board,row+1,0,k);
            return;
        }
        if (isSafeplaceForK(board,row,colm)){
            board[row][colm]=true;
            placeNKnight(board,row,colm+1,k-1);
            board[row][colm]=false;
        }

        placeNKnight(board,row,colm+1,k);
    }

    private static boolean isSafeplaceForK(boolean[][] board, int row, int col) {
        if (row==0 && col==0){
            return true;
        }
        if (isValid(board,row-2,col+1)){
            return false;
        }if (isValid(board,row-2,col-1)){
            return false;
        }if (isValid(board,row-1,col+2)){
            return false;
        }if (isValid(board,row-1,col-2)){
            return false;
        }
        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        if (row>=0 && row<board.length && col>=0 && col<board.length){
            if (board[row][col]){
                return true;
            }
        }
        return false;
    }

    private static void display(boolean[][] board) {
            for(boolean[]row1: board){
                for (boolean ele:row1){
                    if (ele){
                        System.out.print(" K ");
                    }else {
                        System.out.print(" x ");
                    }
                }
                System.out.println();
            }

    }*/
    /*
    static void knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        if (row == board.length - 1 && col == board.length) {
            return;
        }

        if (col == board.length) {
            knight(board, row + 1, 0, knights);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        knight(board, row, col + 1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        return true;
    }

    // do not repeat yourself, hence created this function
    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board) {
            for(boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }*/
    public static int placeNKnightCount(boolean[][]board,int row,int colm,int k){
        if (k==0){
            return 1;
        }if (row==board.length-1 && colm==board.length-1){
            return 0;
        }
        int count=0;
        if (colm==board.length){
            count+=placeNKnightCount(board,row+1,0,k);
            return count;
        }
        if (isSafeplaceForK(board,row,colm)){
            board[row][colm]=true;
           count+=placeNKnightCount(board,row,colm+1,k-1);
            board[row][colm]=false;
        }

        count+=placeNKnightCount(board,row,colm+1,k);
        return count;
    }
    static int knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            return 1 ;
        }
        int count=0;
        if (row == board.length - 1 && col == board.length) {
            return 0;
        }

        if (col == board.length) {
            count+=knight(board, row + 1, 0, knights);
            return count;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count+=knight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }
        count+=knight(board, row, col + 1, knights);
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        return true;
    }

    // do not repeat yourself, hence created this function
    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board) {
            for(boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
//    lllll
    private static boolean isSafeplaceForK(boolean[][] board, int row, int col) {
        if (row==0 && col==0){
            return true;
        }
        if (isValid1(board,row-2,col+1)){
            return false;
        }if (isValid1(board,row-2,col-1)){
            return false;
        }if (isValid1(board,row-1,col+2)){
            return false;
        }if (isValid1(board,row-1,col-2)){
            return false;
        }
        return true;
    }

    private static boolean isValid1(boolean[][] board, int row, int col) {
        if (row>=0 && row<board.length && col>=0 && col<board.length){
            if (board[row][col]){
                return true;
            }
        }
        return false;
    }



}
