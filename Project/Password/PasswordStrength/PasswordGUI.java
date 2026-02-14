package com.Project.Password.PasswordStrength;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class PasswordGUI extends JFrame {
    private final JTextField passwordField;
    private final JLabel strengthLabel;
    private final JTextArea suggestionsArea;

    private final PasswordAlgo algo;

    public PasswordGUI() {
        algo = new PasswordAlgo();
        setTitle("Password Strength Checker");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top panel for password input
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(new JLabel("Enter Password:"));
        passwordField = new JTextField(20);
        topPanel.add(passwordField);
        JButton checkButton = new JButton("Check Strength");
        topPanel.add(checkButton);
        add(topPanel, BorderLayout.NORTH);

        // Center panel for strength display
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        strengthLabel = new JLabel("Strength: ");
        strengthLabel.setFont(new Font("Arial", Font.BOLD, 16));
        strengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(strengthLabel, BorderLayout.NORTH);

        // Text area for suggestions
        suggestionsArea = new JTextArea();
        suggestionsArea.setEditable(false);
        suggestionsArea.setLineWrap(true);
        suggestionsArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(suggestionsArea);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // Button action
        checkButton.addActionListener(_ -> {
            String password = passwordField.getText();
            String strength = algo.getPasswordStrength(password);
            strengthLabel.setText("Strength: " + strength);

            if (password.isBlank()|| password.length()<8){
                StringBuilder b=new StringBuilder();
                Random r=new Random();
                while (b.length()<=10){
                    int random =97;
                    random+=r.nextInt(0,26);
                    b.append((char) random);
                }
                password+=b.toString();
            }
            List<String> suggestions = algo.getSuggestion(password);
            suggestionsArea.setText("Suggested Password for better Security \n");
            for (String sug : suggestions) {
                suggestionsArea.append(sug + "\n");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PasswordGUI::new);
    }
}
