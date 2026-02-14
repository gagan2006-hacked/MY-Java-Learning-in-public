package com.Package_assignment;

import java.util.Arrays;
import java.util.Random;


public class TicTacToe {
    public char[][] grid;
    public String playerX = "Player X";
    public String playerO = "Player O";
    public String won = "";

    public TicTacToe() {
        grid = new char[3][3];
        setupGrid();
    }

    public TicTacToe(char[][] grid) {
        this.grid = grid;
        setupGrid();
    }

    public TicTacToe(String playerX, String playerO) {
        grid = new char[3][3];
        setupGrid();
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public TicTacToe(char[][] grid, String playerX, String playerO) {
        this.grid = grid;
        this.playerX = playerX;
        this.playerO = playerO;
        setupGrid();
    }

    private void setupGrid() {
        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }
    }

    public void outPR() {
        setupGrid();
        won = "";
    }

    public boolean won(int moves) {
        char c = checkWin(moves);
        if (c == 'x' || c == 'o') {
            if (c == 'x') {
                won = playerX;
            } else {
                won = playerO;
            }
        }
        return c == 'x' || c == 'o';
    }

    public char checkWin(int fill) {
        if (fill < 5) return 'C'; // no win possible yet
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != ' ') {
                    char p = isWin(i, j, grid[i][j]);
                    if (p == 'x' || p == 'o') return p;
                }
            }
        }
        return 'C';
    }

    private char isWin(int row, int col, char pl) {
        if (checkInRow(row, pl) || checkInCol(col, pl) || checkInDia(row, col, pl)) {
            return pl;
        }
        return 'C';
    }

    private boolean checkInDia(int row, int col, char pl) {
        if (row == 0 && col == 0 || row == 1 && col == 1 || row == 2 && col == 2) {
            for (int i = 0; i < 3; i++) {
                if (grid[i][i] != pl) return false;
            }
            return true;
        }
        if (row + col == 2) {
            for (int i = 0; i < 3; i++) {
                if (grid[i][2 - i] != pl) return false;
            }
            return true;
        }
        return false;
    }

    private boolean checkInCol(int col, char pl) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][col] != pl) return false;
        }
        return true;
    }

    private boolean checkInRow(int row, char pl) {
        for (int i = 0; i < 3; i++) {
            if (grid[row][i] != pl) return false;
        }
        return true;
    }
}
