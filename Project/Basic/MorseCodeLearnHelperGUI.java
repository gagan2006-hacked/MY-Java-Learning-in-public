package com.Project.Basic;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MorseCodeLearnHelperGUI extends JFrame {

    private final JButton restartBtn;
    MorseCodeTranslate translate = new MorseCodeTranslate();

    private HashSet<Character> characterHashSet;

    private final Random random;

    // UI Components
    JLabel questionLabel, statsLabel;
    JTextField inputField, nameField;
    JButton submitBtn, alphaBtn, numberBtn, startBtn,resetBtn;

    // Logic
    boolean isAlphabetMode = true;
    int index = 0;
    int correct = 0;
    int total = 0;
    String userName = "";

    public MorseCodeLearnHelperGUI() {

        setTitle("Morse Code Learning Helper");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ================= QUESTION PANEL (NORTH) =================
        JPanel questionPanel = new JPanel(new BorderLayout());
        questionPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        questionPanel.setBackground(new Color(30, 30, 30));

        questionLabel = new JLabel("Welcome to Morse Code Learning", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionLabel.setForeground(Color.WHITE);

        questionPanel.add(questionLabel, BorderLayout.CENTER);
        add(questionPanel, BorderLayout.NORTH);

        // ================= MAIN PANEL (CENTER) =================
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(mainPanel, BorderLayout.CENTER);

        // -------- LEFT PANEL (INFO) --------
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createTitledBorder("User & Mode"));

        nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(200, 30));
        startBtn=new JButton("Start");startBtn.setFocusable(false);
        alphaBtn = new JButton("Learn Alphabets");
        numberBtn = new JButton("Learn Numbers");

        leftPanel.add(new JLabel("Enter Name:"));
        leftPanel.add(nameField);
        leftPanel.add(startBtn);
        leftPanel.add(Box.createVerticalStrut(15));
        leftPanel.add(alphaBtn);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(numberBtn);

        mainPanel.add(leftPanel);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Answer"));

        inputField = new JTextField();
        inputField.setMaximumSize(new Dimension(250, 35));

        submitBtn = new JButton("Submit Morse Code");
        submitBtn.setBackground(new Color(70, 130, 180));
        submitBtn.setForeground(Color.WHITE);

        rightPanel.add(new JLabel("Enter Morse Code:"));
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(inputField);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(submitBtn);

        mainPanel.add(rightPanel);

        // ================= STATS PANEL (SOUTH) =================
        JPanel statsPanel = new JPanel();
        statsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        statsLabel = new JLabel("Total: 0 | Correct: 0 | Wrong: 0");
        statsLabel.setFont(new Font("Arial", Font.BOLD, 14));



        restartBtn = new JButton("Restart");
        restartBtn.setBackground(new Color(178, 34, 34));
        restartBtn.setForeground(Color.WHITE);

        resetBtn=new JButton("Reset");
        resetBtn.setBackground(Color.white);
        resetBtn.setForeground(Color.BLACK);

        leftPanel.add(Box.createVerticalStrut(15));
        leftPanel.add(restartBtn);
        leftPanel.add(resetBtn);

        // ================= ACTIONS =================
        startBtn.addActionListener(e->{userName=nameField.getText();JOptionPane.showMessageDialog(null,"Click either Alphabet or Number Button");});
        alphaBtn.addActionListener(e -> startAlphabet());
        numberBtn.addActionListener(e -> startNumbers());
        submitBtn.addActionListener(e -> checkAnswer());
        restartBtn.addActionListener(e -> restartApp());
        resetBtn.addActionListener(e -> reset());

        statsPanel.add(statsLabel);
        add(statsPanel, BorderLayout.SOUTH);


        setVisible(true);


        random = new Random();
    }

    void restartApp() {
        index = 0;
        correct = 0;
        total = 0;
        userName = "";

        nameField.setText("");
        inputField.setText("");

        questionLabel.setText("Welcome to Morse Code Learning");
        statsLabel.setText("Total: 0 | Correct: 0 | Wrong: 0");
    }

    // ================= LOGIC METHODS =================

    void startAlphabet() {
        userName = nameField.getText();
        if (userName.isBlank()) {
            JOptionPane.showMessageDialog(this,"Enter ur  Name Please");
            return;
        }
        isAlphabetMode = true;
        askQuestion();
    }

    void startNumbers() {
        userName = nameField.getText();
        if (userName.isBlank()) {
            JOptionPane.showMessageDialog(this,"Enter ur Name Please");
            return;
        }
        isAlphabetMode = false;
        askQuestion();
    }

    void reset() {
        index = 0;
        correct = 0;
        total = 0;
        updateStats();
    }

    void askQuestion() {
        if (isAlphabetMode && index < 26) {
            char c = (char) ('a' + index);
            questionLabel.setText("Hello " + userName +", Q"+total+" Morse for: " + c);
        } else if (!isAlphabetMode && index < 10) {
            questionLabel.setText("Hello " + userName +", Q"+total+ " → Morse for: " +index);
        } else {
            questionLabel.setText("Completed! 🎉");
        }
    }



    void checkAnswer() {
        if ((isAlphabetMode && index >= 26) || (!isAlphabetMode && index >= 10)) {
            return;
        }

        String expected;
        if (isAlphabetMode) {
            char c = (char) ('a' + index);
            expected = translate.encoder(String.valueOf(c));
        } else {
            expected = translate.encoder(String.valueOf(index));
        }

        if (inputField.getText().equals(expected)) {
            correct++;
        }

        total++;
        index++;
        inputField.setText("");
        updateStats();
        askQuestion();
    }

    void updateStats() {
        int wrong = total - correct;
        statsLabel.setText("Total: " + total + " | Correct: " + correct + " | Wrong: " + wrong);
    }

    public static void main(String[] args) {
        new MorseCodeLearnHelperGUI();
    }
}

