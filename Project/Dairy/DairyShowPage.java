package com.Project.Dairy;

import javax.swing.*;
import java.awt.*;

public class DairyShowPage extends JFrame {
    Image image=new ImageIcon("D:\\Progr\\src\\com\\Project\\Dairy\\Khaby.jpg").getImage();

    JTextField titleField;
    JTextArea contentArea;
    JButton button=new JButton("Exit");
    public DairyShowPage(Dairy dairy) {
        setIconImage(image);
        setTitle("View Diary Entry");
        setSize(800, 600);
        setLocation(250, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // -------- TITLE (READ-ONLY) ----------
        titleField = new JTextField(dairy.getTittle());
        titleField.setFont(new Font("Arial", Font.BOLD, 20));
        titleField.setEditable(false); // ❗ user cannot change
        titleField.setBorder(BorderFactory.createTitledBorder("Title"));

        // ---------- CONTENT (READ-ONLY) ----------
        contentArea = new JTextArea(dairy.getData());
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setFont(new Font("Serif", Font.PLAIN, 16));
        contentArea.setEditable(false); // ❗ user cannot type

        JScrollPane scrollPane = new JScrollPane(contentArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Content"));

        // -------- ADD TO FRAME ---------
        add(titleField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(BorderLayout.SOUTH,button);
        button.addActionListener(e -> {dispose();DairyMainGui.main(new String[]{});});

        setVisible(true);
    }

    public static void main(String[] args,Dairy dairy) {
        DairyShowPage page= new DairyShowPage(dairy);
    }
}
