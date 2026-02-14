package com.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiLearn {
    public static void main(String[] args) {

        JFrame frame = new JFrame("My Learning Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setLayout(new BorderLayout());

        // Panel for input
        JLabel name = new JLabel("Name:");
        JTextField nameText = new JTextField(20);

        JPanel panel = new JPanel(new BorderLayout());

        panel.add(name, BorderLayout.NORTH);
        panel.add(nameText, BorderLayout.CENTER);


        JButton button = new JButton("Submit");
        panel.add(button, BorderLayout.SOUTH);


        // Button action
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = nameText.getText().trim();

                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Enter your name", "Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Create large content for testing scroll
                JTextArea area = new JTextArea(10, 30);
                area.setText(text);
                area.setLineWrap(true);
                area.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(area);
                scrollPane.setPreferredSize(new Dimension(350, 200));

                JOptionPane.showMessageDialog(
                        frame,
                        scrollPane,
                        "Details",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        frame.add(panel, BorderLayout.NORTH);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
