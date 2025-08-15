package com.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class TicTacToeGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NameEntryFrame());
    }
}

// Frame to get player names
class NameEntryFrame extends JFrame {
    JTextField player1Field, player2Field;
    ImageIcon icon=new ImageIcon("D:\\Progr\\src\\com\\GUI\\bd.png");
    NameEntryFrame() {
        setTitle("Enter Player Names");
        setSize(300, 150);
        setLayout(new GridLayout(3, 2, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon.getImage());
        add(new JLabel("Player X:"));
        player1Field = new JTextField();
        add(player1Field);

        add(new JLabel("Player O:"));
        player2Field = new JTextField();
        add(player2Field);

        JButton startBtn = new JButton("Start Game");
        add(new JLabel()); //  to postion the button
        add(startBtn);
        startBtn.setFocusable(false);
        startBtn.addActionListener(e -> {
            String p1 = player1Field.getText().trim();
            String p2 = player2Field.getText().trim();

            if (p1.isEmpty() || p2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter both player names!");
                return;
            }
            new GameFrame(p1, p2);
            dispose();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// Main Game Frame
class GameFrame extends JFrame {
    JButton[][] buttons = new JButton[3][3];
    TicTacToe game;
    boolean playerXTurn;
    int moveCount = 0;
    ImageIcon icon=new ImageIcon("D:\\Progr\\src\\com\\GUI\\bd.png");
    GameFrame(String p1, String p2) {
        game = new TicTacToe(p1, p2);
        setIconImage(icon.getImage());
        setTitle("Tic Tac Toe - " + p1 + " vs " + p2);
        setSize(400, 400);
        setLayout(new GridLayout(3, 3,2,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Randomly choose who starts
        playerXTurn = new Random().nextBoolean();
        JOptionPane.showMessageDialog(this, 
            (playerXTurn ? p1 : p2) + " starts first!");

        // Create board buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton("");
                btn.setFocusable(false);
                btn.setFont(new Font("Arial", Font.BOLD, 40));
                final int row = i, col = j;
                btn.addActionListener(e -> handleMove(btn, row, col));
                buttons[i][j] = btn;
                add(btn);
            }
        }

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleMove(JButton btn, int row, int col) {
        if (!btn.getText().equals("")) return; // already filled

        char symbol = playerXTurn ? 'x' : 'o';
        btn.setText(String.valueOf(symbol).toUpperCase());
        game.grid[row][col] = symbol;

        moveCount++;

        // Start checking wins after 5 moves
        if (moveCount >= 5 && game.won(moveCount)) {
            String winner = game.won.contains(game.playerX) ? game.playerX : game.playerO;
            JOptionPane.showMessageDialog(this, winner + " wins!","Game Won",JOptionPane.INFORMATION_MESSAGE);
            resetBoard();
            return;
        }

        // If all moves done and no winner → draw
        if (moveCount == 9) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            resetBoard();
            return;
        }

        playerXTurn = !playerXTurn; // switch turn
    }

    private void resetBoard() {
        game.outPR();
        moveCount = 0;
        playerXTurn = new Random().nextBoolean();
        JOptionPane.showMessageDialog(this, 
            (playerXTurn ? game.playerX : game.playerO) + " starts first!");

        for (JButton[] row : buttons) {
            for (JButton btn : row) {
                btn.setText("");
            }
        }
    }
}

// Backend Logic (Your code slightly adjusted)
class TicTacToe {
    char[][] grid;
    String playerX = "Player X";
    String playerO = "Player O";
    String won = "";

    public TicTacToe() {
        grid = new char[3][3];
        setupGrid();
    }

    public TicTacToe(String playerX, String playerO) {
        grid = new char[3][3];
        setupGrid();
        this.playerX = playerX;
        this.playerO = playerO;
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
