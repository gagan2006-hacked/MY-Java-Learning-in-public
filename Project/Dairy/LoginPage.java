package com.Project.Dairy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener,KeyListener {
    String usr="Jacky",password="Nevergiveup";
    Image image=new ImageIcon("D:\\Progr\\src\\com\\Project\\Dairy\\Khaby.jpg").getImage();
    // <-- your image here
    // Components
    private Container container = new BackgroundPanel(image);
    private JLabel titleLabel, userLabel, passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginBtn, resetBtn;

    public LoginPage() {
        setTitle("Login Page");
        setBounds(480, 150, 420, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(image);

        setContentPane(container);
        container.setLayout(null);

        // Title
        titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setBounds(160, 15, 200, 40);

        // Username
        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 80, 100, 30);
        userField = new JTextField();
        userField.setBounds(150, 80, 200, 30);

        // Password
        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 130, 100, 30);
        passField = new JPasswordField();
        passField.setBounds(150, 130, 200, 30);
        passField.addKeyListener(this);

        // Buttons
        loginBtn = new JButton("Login");
        loginBtn.setBounds(90, 190, 100, 35);
        loginBtn.addActionListener(this);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(220, 190, 100, 35);
        resetBtn.addActionListener(this);

        // Add to container
        container.add(titleLabel);
        container.add(userLabel);
        container.add(userField);
        container.add(passLabel);
        container.add(passField);
        container.add(loginBtn);
        container.add(resetBtn);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginBtn) {
            String username = userField.getText();
            String password = String.valueOf(passField.getPassword());
            if (this.usr.equals(username)&&this.password.equals(password)) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                dispose();
                DairyMainGui.main(new String[]{});
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password!");
            }
        }

        if (e.getSource() == resetBtn) {
            userField.setText("");
            passField.setText("");
        }
    }
    public static void main(String[] args) {
        new LoginPage();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_ENTER){
            loginBtn.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image image) {
            setLayout(null);
           backgroundImage=image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                // draw image scaled to panel size
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            } else {
                // if no image, fill with a fallback color
                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    }
}