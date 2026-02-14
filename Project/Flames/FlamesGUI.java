package com.Project.Flames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class FlamesGUI extends JFrame {
    ImageIcon icon=new ImageIcon("D:\\Progr\\src\\com\\Project\\Flames\\heart.png");
    private JTextField nameField1;
    private JTextField nameField2;
    private JButton calcButton;
    private JLabel resultLabel;
    private Flames flamesLogic;

    public FlamesGUI() {
        flamesLogic = new Flames();
        setTitle("🔥 FLAMES Love Calculator ❤️");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setIconImage(icon.getImage());

        // Background gradient panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(255, 94, 98),
                        getWidth(), getHeight(), new Color(255, 195, 113));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setLayout(new GridBagLayout());
        add(backgroundPanel, BorderLayout.CENTER);

        // Panel for inputs and button
        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("💖 FLAMES Relationship Finder 💖");
        titleLabel.setFont(new Font("Poppins", Font.BOLD, 22));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel nameLabel1 = new JLabel("Enter your name:");
        nameLabel1.setFont(new Font("Poppins", Font.PLAIN, 16));
        nameLabel1.setForeground(Color.WHITE);
        mainPanel.add(nameLabel1, gbc);

        gbc.gridx = 1;
        nameField1 = new JTextField(15);
        nameField1.setFont(new Font("Poppins", Font.PLAIN, 16));
        nameField1.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        mainPanel.add(nameField1, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel nameLabel2 = new JLabel("Enter partner's name:");
        nameLabel2.setFont(new Font("Poppins", Font.PLAIN, 16));
        nameLabel2.setForeground(Color.WHITE);
        mainPanel.add(nameLabel2, gbc);

        gbc.gridx = 1;
        nameField2 = new JTextField(15);
        nameField2.setFont(new Font("Poppins", Font.PLAIN, 16));
        nameField2.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        mainPanel.add(nameField2, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        calcButton = new JButton("💘 Calculate");
        calcButton.setFont(new Font("Poppins", Font.BOLD, 16));
        calcButton.setBackground(new Color(255, 82, 82));
        calcButton.setForeground(Color.WHITE);
        calcButton.setFocusPainted(false);
        calcButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        calcButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mainPanel.add(calcButton, gbc);

        gbc.gridy++;
        resultLabel = new JLabel("Result will appear here ✨");
        resultLabel.setFont(new Font("Poppins", Font.BOLD, 20));
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(resultLabel, gbc);

        backgroundPanel.add(mainPanel);

        // Button Action
        calcButton.addActionListener(e -> {
            String name1 = nameField1.getText().trim();
            String name2 = nameField2.getText().trim();

            if (name1.isEmpty() || name2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both names 😅", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String result = flamesLogic.makeFlames(name1, name2);
            resultLabel.setText("💫 " + name1 + " & " + name2 + " are " + result + "! 💫");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlamesGUI gui = new FlamesGUI();
            gui.setVisible(true);
        });
    }
}