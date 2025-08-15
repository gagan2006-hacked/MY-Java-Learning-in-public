package com.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Objects;

public class GuiLearn {
    public static void main(String[] args) {
        JFrame frame=new JFrame("MY Leaning Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,750);
       /* frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image=new ImageIcon(Objects.requireNonNull(GuiLearn.class.getResource("bd.png"),"The image is missing "));

//        ImageIcon image=new ImageIcon("D:\\Progr\\src\\com\\GUI\\bd.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(Color.GRAY);

//        Jlabel
        Border border=BorderFactory.createLineBorder(Color.green);
        JLabel label=new JLabel("I am gagan ");
        label.setIcon(new ImageIcon("D:\\Progr\\src\\com\\GUI\\OIP.jpg"));
//        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("ITALIC",Font.BOLD,20));
        label.setBackground(Color.BLACK);
        label.setForeground(Color.green);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBorder(border);
        label.setOpaque(true);
        label.setBounds(0,0,250,250);

        frame.add(label);*/

//        red one
        /*JPanel redP=new JPanel();
        redP.setBackground(Color.red);
        redP.setBounds(0,0,250,250);
        redP.setLayout(new BorderLayout());
        JLabel red=new JLabel("RED");
        red.setForeground(Color.BLACK);
//        red.setBounds(125,125,100,20);
        red.setBackground(Color.red);
        red.setVerticalAlignment(JLabel.CENTER);
        red.setHorizontalAlignment(JLabel.CENTER);
        red.setOpaque(true);

//        blue One
        JPanel blueP=new JPanel();
        blueP.setBackground(Color.BLUE);
        blueP.setBounds(250,0,250,250);
        blueP.setLayout(new BorderLayout());
        JLabel blue=new JLabel("BLUE");
        blue.setForeground(Color.green);
//        blue.setBounds(375,125,100,20);
        blue.setBackground(Color.blue);
        blue.setVerticalAlignment(JLabel.CENTER);
        blue.setHorizontalAlignment(JLabel.CENTER);
        blue.setOpaque(true);
//        blueP.setCom

//      CYan one
        JPanel g=new JPanel();
        g.setBackground(Color.CYAN);
        g.setBounds(0,250,500,250);
        g.setLayout(new BorderLayout());
        JLabel cyan=new JLabel("CYAN");
        cyan.setForeground(Color.YELLOW);
        cyan.setBackground(Color.cyan);
//        cyan.setBounds(250,375,100,20);
        cyan.setVerticalAlignment(JLabel.CENTER);
        cyan.setHorizontalAlignment(JLabel.CENTER);
        cyan.setOpaque(true);


        frame.setLayout(null);
//
        blueP.add(blue);
        frame.add(blueP);
//
        redP.add(red);
        frame.add(redP);
//
        g.add(cyan);
        frame.add(g);*/
        
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
