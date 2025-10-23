package com.Project.Basic;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class WordSuggestionGUI extends JFrame {
    private ImageIcon icon=new ImageIcon("D:\\Progr\\src\\com\\GUI\\bd.png");
    private JTextField inputField;
    private JList<String> suggestionList;
    private DefaultListModel<String> listModel;
    private WordChecker wordChecker;
    private List<String> typedWords = new ArrayList<>();

    public WordSuggestionGUI() {
        setTitle("Word Suggestion System");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        wordChecker = new WordChecker();

        // Input field
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 18));
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputField, BorderLayout.CENTER);
        inputField.setPreferredSize(new Dimension(100, 30)); // smaller height
        topPanel.setPreferredSize(new Dimension(50,50));
        add(topPanel, BorderLayout.PAGE_START);

        // Suggestion list
        listModel = new DefaultListModel<>();
        suggestionList = new JList<>(listModel);
        suggestionList.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(suggestionList);

        // Real-time typing listener
        inputField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                handleTyping();
            }

            public void removeUpdate(DocumentEvent e) {
                handleTyping();
            }

            public void changedUpdate(DocumentEvent e) {
                handleTyping();
            }
        });

        // Handle Enter key to accept suggestion
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // When Enter is pressed
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!listModel.isEmpty()) {
                        String selected = suggestionList.getSelectedValue();
                        if (selected == null) {
                            selected = listModel.getElementAt(0); // pick first if none selected
                        }
                        inputField.setText(selected);
                        listModel.clear(); // clear suggestions after selection
                    }
                }
                // Allow arrow key navigation through list
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    int nextIndex = suggestionList.getSelectedIndex() + 1;
                    if (nextIndex < listModel.getSize()) {
                        suggestionList.setSelectedIndex(nextIndex);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    int prevIndex = suggestionList.getSelectedIndex() - 1;
                    if (prevIndex >= 0) {
                        suggestionList.setSelectedIndex(prevIndex);
                    }
                }
            }
        });

        // Layout
        setLayout(new BorderLayout(10, 10));
        add(new JLabel("Type to get suggestions:", SwingConstants.CENTER), BorderLayout.NORTH);
        add(inputField, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void handleTyping() {
        String text = inputField.getText().trim();
        listModel.clear();

        // If text is empty, reset
        if (text.isEmpty()) {
            typedWords.clear();
            return;
        }

        // Split current input into words
        String[] words = text.split(" ");

        // Update word history
        typedWords = new ArrayList<>(Arrays.asList(words));

        // Generate suggestions based on last word typed
        String lastWord = words[words.length - 1];
        List<String> suggestions = wordChecker.getSuggestions(Collections.singletonList(lastWord));

        // Combine with previously typed words
        for (String suggestion : suggestions) {
            String combined = String.join(" ", typedWords.subList(0, typedWords.size() - 1))
                    + (typedWords.size() > 1 ? " " : "") + suggestion;
            listModel.addElement(combined.trim());
        }

        // Auto-select first suggestion for convenience
        if (!listModel.isEmpty()) {
            suggestionList.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WordSuggestionGUI::new);
    }
}
