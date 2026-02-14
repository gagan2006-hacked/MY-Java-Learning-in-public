package com.Leetcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Bored {
    JFrame frame;
    JLabel label;
    JButton button;

    public Bored(){
        frame=new JFrame(" Leet Code Question Chooser ");
        label=new JLabel("Press the get button");
        label.setBackground(Color.pink);
        label.setForeground(Color.BLACK);
        button=new JButton("Get");
        button.setBackground(Color.YELLOW);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button){
                    Random random=new Random();
                    int question = random.nextInt(1,3729);
                    label.setText("LC"+question);
                }
            }
        });
        frame.setLocation(1920/2,1200/2);
        frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    public static void main(String[] args) {
        Bored b=new Bored();
    }
}
