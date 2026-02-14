package com.Project.Flames;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {
    JLabel timeLabel;
    JLabel dateLabel;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dateFormat;
    String time;
    String date;
    Timer timer;

    DigitalClock() {
        this.setTitle("Digital Clock");
        this.setSize(400, 300);
        this.setLayout(new GridLayout(1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // center window
        setIconImage(new ImageIcon("D:\\Progr\\src\\com\\Project\\Flames\\Clock.png").getImage());
        setResizable(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel backgroundPanel = new JPanel(new GridLayout(2,1)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(255, 94, 98),
                        getWidth(), getHeight(), new Color(255, 195, 113));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };backgroundPanel.add(timeLabel);
        backgroundPanel.add(dateLabel);
        add(backgroundPanel);
        JButton button = getButton();
//        add(button);
        startClock();
        this.setVisible(true);
    }

    private static JButton getButton() {
        JButton button = new JButton("Timer") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                // Draw gradient background first
                GradientPaint gp = new GradientPaint(0, 0, new Color(255, 94, 98),
                        getWidth(), getHeight(), new Color(255, 195, 113));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();

                // Then draw default button features (text, border, etc.)
                super.paintComponent(g);
            }
        };

        // Make text visible and styled
        button.setFont(new Font("Poppins", Font.BOLD, 22));
        button.setForeground(Color.WHITE); // white text looks great on warm gradient
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false); // ensures custom paint is visible
        button.setOpaque(false);
        return button;
    }


    public void startClock() {
        timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    public void updateTime() {
        time = timeFormat.format(new Date());
        date = dateFormat.format(new Date());
        timeLabel.setText(time);
        dateLabel.setText(date);
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}
