package example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui2 {

    private static JFrame frame;
    private static JPanel cardPanel;
    private static CardLayout cardLayout;

    public static void openFrame() {
        frame = new JFrame("CHATAUEB - Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Add menu panel
        cardPanel.add(createMenuPanel(), "menu");

        // Add login panel
        cardPanel.add(createLoginPanel(), "login");

        // Add signup panel
        cardPanel.add(createSignupPanel(), "signup");

        frame.add(cardPanel);
        frame.setVisible(true);
    }

    public static JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);

        JLabel label = new JLabel("Welcome to ChatAUEB.");
        label.setBounds(10, 10, 480, 100);
        label.setHorizontalAlignment(JLabel.CENTER);
        Font boldFont = new Font(label.getFont().getFontName(), Font.BOLD, 20);
        label.setFont(boldFont);
        menuPanel.add(label);

        // Add buttons for sign up, log in, and change password
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(200, 100, 100, 30);
        menuPanel.add(signUpButton);

        JButton loginButton = new JButton("Log In");
        loginButton.setBounds(200, 140, 100, 30);
        menuPanel.add(loginButton);

        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(175, 180, 150, 30);
        menuPanel.add(changePasswordButton);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "signup");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "login");
            }
        });

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Placeholder method for changing password (replace with actual implementation)
                System.out.println("Change Password button pressed");
                // Implement your logic for changing the password here
            }
        });

        return menuPanel;
    }

    public static JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(150, 100, 80, 20);
        loginPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(240, 100, 120, 20);
        loginPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(150, 130, 80, 20);
        loginPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(240, 130, 120, 20);
        loginPanel.add(passwordField);

        JButton loginButton = new JButton("Log In");
        loginButton.setBounds(200, 200, 100, 30);
        loginPanel.add(loginButton);

        JButton backButton = new JButton("Back to Menu");
        backButton.setBounds(200, 250, 150, 30);
        loginPanel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "menu");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Use the username and password as needed (e.g., for login validation)
                System.out.println("Logging in with username: " + username + " and password: " + password);
            }
        });

        return loginPanel;
    }

    public static JPanel createSignupPanel() {
        JPanel signupPanel = new JPanel();
        signupPanel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(150, 100, 80, 20);
        signupPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(240, 100, 120, 20);
        signupPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(150, 130, 80, 20);
        signupPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(240, 130, 120, 20);
        signupPanel.add(passwordField);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(200, 200, 100, 30);
        signupPanel.add(signupButton);

        JButton backButton = new JButton("Back to Menu");
        backButton.setBounds(200, 250, 150, 30);
        signupPanel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "menu");
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Use the username and password as needed (e.g., for signup)
                System.out.println("Signing up with username: " + username + " and password: " + password);
            }
        });

        return signupPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                openFrame();
            }
        });
    }
}
