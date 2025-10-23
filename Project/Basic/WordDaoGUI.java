package com.Project.Basic;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class WordDaoGUI extends JFrame {
    private final JTextField inputField;
    private final JList<String> suggestionList;
    private final DefaultListModel<String> listModel;
    private final WordDAO wordDAO;

    public WordDaoGUI() {
        setTitle("Smart Word Suggestion (DAO)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        wordDAO = new WordDAO();

        // Title label
        JLabel label = new JLabel("Type to get suggestions:", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(label, BorderLayout.NORTH);

        // Input field
        inputField = new JTextField();
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        inputField.setPreferredSize(new Dimension(200, 35));
        add(inputField, BorderLayout.CENTER);

        // Suggestion list
        listModel = new DefaultListModel<>();
        suggestionList = new JList<>(listModel);
        suggestionList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        suggestionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(suggestionList);
        scrollPane.setPreferredSize(new Dimension(200, 150));
        add(scrollPane, BorderLayout.SOUTH);

        // 🔹 Real-time suggestions when typing
        inputField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { showSuggestions(); }
            public void removeUpdate(DocumentEvent e) { showSuggestions(); }
            public void changedUpdate(DocumentEvent e) { showSuggestions(); }
        });

        // 🔹 ActionListener handles Enter key
        inputField.addActionListener(e -> selectWord());

        // 🔹 Arrow key navigation
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();

                if (code == KeyEvent.VK_DOWN) {
                    int next = suggestionList.getSelectedIndex() + 1;
                    if (next < listModel.size()) suggestionList.setSelectedIndex(next);
                } else if (code == KeyEvent.VK_UP) {
                    int prev = suggestionList.getSelectedIndex() - 1;
                    if (prev >= 0) suggestionList.setSelectedIndex(prev);
                }
            }
        });

        // 🔹 Double-click on suggestion
        suggestionList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) selectWord();
            }
        });

        setVisible(true);
    }

    /** 🔹 Fetch top 5 suggestions from DB based on prefix and popularity */
    private void showSuggestions() {
        String text = inputField.getText().trim();
        listModel.clear();

        if (text.isEmpty()) return;

        List<String> suggestions = wordDAO.getSuggestions(text);
        for (String s : suggestions) {
            listModel.addElement(s);
        }

        // Show add option if no matches found
        if (suggestions.isEmpty()) {
            listModel.addElement("Add \"" + text + "\"");
        }

        // Auto-select first suggestion
        if (!listModel.isEmpty()) suggestionList.setSelectedIndex(0);
    }

    /** 🔹 Handle selection or Enter key press */
    private void selectWord() {
        String selected = suggestionList.getSelectedValue();

        if (selected == null || selected.isBlank()) return;

        if (selected.startsWith("Add")) {
            // Add new word
            String newWord = inputField.getText().trim().toLowerCase();
            wordDAO.increasePopularity(newWord);
            inputField.setText(newWord);
        } else {
            // Existing word: update popularity
            inputField.setText(selected);
            wordDAO.increasePopularity(selected);
        }

        listModel.clear();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WordDaoGUI::new);
    }
}
