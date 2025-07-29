package com.PersonalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTac {
    static char[][] board = new char[3][3];
    static JButton[][] buttons = new JButton[3][3];
    static boolean isXTurn = true;
    static int entryDone = 0;
    static String playerX = "Player X";
    static String playerO = "Player O";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe Game");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                board[i][j] = ' ';

        playerX = JOptionPane.showInputDialog("Enter the name of Player 'X':");
        playerO = JOptionPane.showInputDialog("Enter the name of Player 'O':");

        createGrid(frame);
        frame.setVisible(true);
    }

    private static void createGrid(JFrame frame) {
        Font font = new Font("Arial", Font.BOLD, 40);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("");
                buttons[i][j] = button;
                button.setFont(font);
                int row = i;
                int col = j;
                button.addActionListener(e -> {
                    if (button.getText().equals("")) {
                        char symbol = isXTurn ? 'X' : 'O';
                        board[row][col] = symbol;
                        button.setText(String.valueOf(symbol));
                        entryDone++;

                        if (entryDone >= 5 && gameWon(board)) {
                            String winner = (symbol == 'X') ? playerX : playerO;
                            JOptionPane.showMessageDialog(null, winner + " wins!");
                            resetGame();
                            return;
                        }

                        if (entryDone == 9) {
                            JOptionPane.showMessageDialog(null, "It's a Draw!");
                            resetGame();
                            return;
                        }

                        isXTurn = !isXTurn;
                    }
                });
                frame.add(button);
            }
        }
    }

    private static void resetGame() {
        entryDone = 0;
        isXTurn = true;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
                buttons[i][j].setText("");
            }
    }

    public static boolean gameWon(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != ' ') {
                    if (hasWon(board, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean hasWon(char[][] board, int row, int col) {
        return checkInRow(board, row, col) ||
               checkInCol(board, row, col) ||
               checkInDiagonal(board, row, col);
    }

    private static boolean checkInRow(char[][] board, int row, int col) {
        char toCheck = board[row][col];
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != toCheck)
                return false;
        }
        return true;
    }

    private static boolean checkInCol(char[][] board, int row, int col) {
        char toCheck = board[row][col];
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != toCheck)
                return false;
        }
        return true;
    }

    private static boolean checkInDiagonal(char[][] board, int row, int col) {
        char toCheck = board[row][col];

        // Check main diagonal
        if (row == col) {
            boolean win = true;
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] != toCheck)
                    win = false;
            }
            if (win) return true;
        }

        // Check anti-diagonal
        if (row + col == board.length - 1) {
            boolean win = true;
            for (int i = 0; i < board.length; i++) {
                if (board[i][board.length - 1 - i] != toCheck)
                    win = false;
            }
            if (win) return true;
        }

        return false;
    }
}
