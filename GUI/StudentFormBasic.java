package com.GUI;

import com.OSIMP.NONPREMP.Job;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentFormBasic {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);

        // Basic grid layout: 6 rows, 2 columns
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        // Labels and fields
        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        JTextField ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Gender:"));
        String[] gender = {"Male", "Female", "Other"};
        JComboBox<String> genderBox = new JComboBox<>(gender);
        panel.add(genderBox);

        panel.add(new JLabel("Course:"));
        JTextField courseField = new JTextField();
        panel.add(courseField);

        panel.add(new JLabel("Address:"));
        JTextField addressField = new JTextField();
        panel.add(addressField);

        // Submit button (full width)
        JButton submit = new JButton("Submit");
        panel.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==submit){
                    if (nameField.getText().isBlank()||ageField.getText().isBlank()||(genderBox.getSelectedIndex()==-1)||addressField.getText().isBlank()){
                        JOptionPane.showMessageDialog(null,"Enter all the data , do not leave blank or unselected box");return;
                    }
                    String data="Name:"+nameField.getText()+"\n"
                            +"Age:"+ageField.getText()+"\n"
                            +"Gender:"+genderBox.getSelectedItem()+"\n"
                            +"Address:"+addressField.getText()+"\n";
                    JTextArea area=new JTextArea(4,2);
                    area.setText(data);
                    JOptionPane.showMessageDialog(null,new JScrollPane(area));
                }
            }});
        frame.add(panel);
        frame.setVisible(true);
    }
}
