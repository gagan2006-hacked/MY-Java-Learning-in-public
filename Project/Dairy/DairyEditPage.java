package com.Project.Dairy;

import com.Project.FIle_Encrypt.EncryptionV1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DairyEditPage extends JFrame implements ActionListener {
    Image image=new ImageIcon("D:\\Progr\\src\\com\\Project\\Dairy\\Khaby.jpg").getImage();
    JTextField titleField;
    JTextArea contentArea;
    JButton submit;
    Dairy dairy;
    DairyDao dao;
    public DairyEditPage(Dairy d) {
        setIconImage(image);

        setTitle("Edit Diary");
        setSize(800, 600);
        setLocation(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        dairy=d;

        submit=new JButton("Submit");
        submit.addActionListener(this);

        JPanel titlePanel = new JPanel(new BorderLayout());
        titleField = new JTextField();
        titleField.setFont(new Font("Arial", Font.BOLD, 18));
        titleField.setBorder(BorderFactory.createTitledBorder("Title"));
        titlePanel.add(titleField, BorderLayout.CENTER);

        contentArea = new JTextArea();
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setFont(new Font("Serif", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(contentArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Content"));

        JPanel b=new JPanel();
        b.add(submit);
        JButton exit=new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DairyMainGui.main(new String[]{});
            }
        });
        b.add(exit);

        add(titlePanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(BorderLayout.SOUTH,b);

        loadData();
        setVisible(true);
        dao=new DairyDao();
    }

    private void loadData() {
        titleField.setText(dairy.getTittle());
        contentArea.setText(dairy.getData());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
         dairy.setTittle(titleField.getText());
         dairy.setData(contentArea.getText());
         if (dao.updateDairy(dairy)){
                JOptionPane.showMessageDialog(null,"Editing is Successfully ");
         }else {
                JOptionPane.showMessageDialog(null,"Error pls try again ");
         }
         dispose();
         DairyMainGui.main(new String[]{});
        }
    }

    public static void main(String[] args,Dairy dairy) {
        new DairyEditPage(dairy);
    }
}
