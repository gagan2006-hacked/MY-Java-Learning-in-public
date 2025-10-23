package com.Leetcode;

import java.util.Random;

public class LeetCode79 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED"; // Expected output: true
        String word2 = "SEE";    // Expected output: true
        String word3 = "ABCB";   // Expected output: false
        LeetCode79 solve=new LeetCode79();
        System.out.println("Test Case 1: " + solve.exist(board, word1));
        System.out.println("Test Case 2: " + solve.exist(board, word2));
        System.out.println("Test Case 3: " + solve.exist(board, word3));

    }

    public  boolean exist(char[][] board, String word) {
        int row = 0;
        int col = 0;
        return existHelper(board, word, row, col, new StringBuilder(), 0);
    }

    /*private  boolean existHelper(char[][] board, String word, int row, int col, StringBuilder process, int i) {
        if (col == board[row].length) {
            return existHelper(board, word, row + 1, 0, process, i);
        }
        boolean existCheck = false;
        for (int j = row; j < board.length; j++) {
            if (existCheck){
                break;
            }
            for (int k = col; k < board[j].length; k++) {
                if (existCheck){
                    break;
                }
                if (board[j][k] == word.charAt(i)) {
                    char value = board[j][k];
                    board[j][k] = '0';
                    process.append(word.charAt(i));
                    existCheck = word.contentEquals(process);
                    if (i < word.length() - 1) {
                        if (rightCheck(board, word.charAt(i + 1), j, k) && existHelper(board, word, j, k+ 1, process, i + 1)) {
                            existCheck = true;
                        } else if (leftCheck(board, word.charAt(i + 1), j, k) && existHelper(board, word, j, k- 1, process, i + 1)) {
                            existCheck = true;
                        } else if (upCheck(board, word.charAt(i + 1), j, k) && existHelper(board, word, j-1, k, process, i + 1)) {
                            existCheck = true;
                        } else if (downCheck(board, word.charAt(i + 1), j, k) && existHelper(board, word, j + 1, k, process, i + 1)) {
                            existCheck = true;
                        } else {
                            process.deleteCharAt(process.length() - 1);
                        }
                    }
                    board[j][k] = value;
                }
                if (!existCheck && !process.isEmpty()){
                    break;
                }
            }
            if (!existCheck && !process.isEmpty()){
                break;
            }
        }
        return existCheck;
    }*/


    private  Boolean existHelper(char[][] board, String word, int row, int col,StringBuilder process,int i){
        if (row==board.length){
            return false;
        }
        if (col==board[row].length){
            return existHelper(board,word,row+1,0,process,i);
        }boolean existCheck=false;

        if (board[row][col]==word.charAt(i)){
            char value=board[row][col];
            board[row][col]='0';
            process.append(word.charAt(i));
            existCheck=word.contentEquals(process);
            if (existCheck){
                return true;
            }
            if (i<word.length()-1) {
                if (rightCheck(board, word.charAt(i + 1), row, col)&&existHelper(board, word, row, col + 1, process, i + 1) ||(leftCheck(board, word.charAt(i + 1), row, col) && existHelper(board, word, row, col - 1, process, i + 1)) ||(upCheck(board, word.charAt(i + 1), row, col) && existHelper(board, word, row - 1, col, process, i + 1)) || (downCheck(board, word.charAt(i + 1), row, col) && existHelper(board, word, row + 1, col, process, i + 1)) ) {
                    existCheck=true;
                }
                else {
                    process.deleteCharAt(process.length() - 1);
                }
            }
            board[row][col] = value;
        }if (!existCheck && !process.isEmpty()){
            return false;
        }
        return existCheck || existHelper(board,word,row,col+1,process,i);
    }
    public  boolean rightCheck(char[][] board, char target, int row, int col) {
        if (!(col < board[row].length - 1)) {
            return false;
        }
        return (board[row][col + 1] == target);
    }

    public  boolean leftCheck(char[][] board, char target, int row, int col) {
        if ((col == 0)) {
            return false;
        }
        boolean ret = (board[row][col - 1] == target);
        return ret;
    }

    public  boolean upCheck(char[][] board, char target, int row, int col) {
        if ((row == 0)) {
            return false;
        }
        return (board[row - 1][col] == target);
    }

    public  boolean downCheck(char[][] board, char target, int row, int col) {
        if ((row == board.length - 1)) {
            return false;
        }
        return (board[row + 1][col] == target);
    }
}

