import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {

    private static JFrame frame;

    public static void openFrame() {
        frame = new JFrame("CHATAUEB - Menu");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 500);

        TextFrame();
        createButtons(); // Call createButtons to add buttons to the frame

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void TextFrame() {
        JLabel label = new JLabel("Welcome to ChatAUEB.");
        label.setBounds(10, 10, 480, 100); // Adjusted the width to 480 for centering
        label.setHorizontalAlignment(JLabel.CENTER); // Center the text

        // Set the font to bold
        Font boldFont = new Font(label.getFont().getFontName(), Font.BOLD, 20);
        label.setFont(boldFont);

        frame.add(label);
    }

    public static void createButtons() {
        JLabel label = new JLabel("Welcome to ChatAUEB.");
        int labelHeight = 100; // Height of the label

        // Add buttons for sign up, log in, and change password
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(200, labelHeight, 100, 30); // Centered vertically based on label height
        frame.add(signUpButton);

        JButton loginButton = new JButton("Log In");
        loginButton.setBounds(200, labelHeight + 40, 100, 30); // Centered vertically based on label height
        frame.add(loginButton);

        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(175, labelHeight + 80, 150, 30); // Centered vertically based on label height
        frame.add(changePasswordButton);

        // Add action listeners for the buttons
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sign Up button pressed");
                createCredentialsDialog(1);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log In button pressed");
                createCredentialsDialog(2);
            }
        });

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Change Password button pressed");
                createCredentialsDialog(3);
            }
        });
    }

    public static void createCredentialsDialog(int action) {
        
        JDialog credentials = new JDialog();
        credentials.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        credentials.setSize(500, 500);

        credentials.setVisible(true);
        credentials.setLayout(null);

        JPanel userPanel = new JPanel();
        userPanel.setBounds(200, 170, 100, 40);

        JLabel userLabel = new JLabel("Username: ");
        userLabel.setBounds(200, 170, 100, 20);

        JTextField userText = new JTextField(30);
        userText.setBounds(200, 190, 100, 20);
        
        credentials.add(userLabel);
        credentials.add(userText);

        credentials.add(userPanel);

        JPanel passPanel = new JPanel();
        passPanel.setBounds(200, 230, 100, 40);

        JLabel passLabel = new JLabel("Password: ");
        passLabel.setBounds(200, 230, 100, 20);

        JTextField passText = new JTextField(30);
        passText.setBounds(200, 250, 100, 20);

        credentials.add(passLabel);
        credentials.add(passText);

        credentials.add(passPanel);

        JButton enter = new JButton("Enter");
        enter.setBounds(300, 350, 70, 30);

        credentials.add(enter); 

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = passText.getText();
                User user;
                switch (action) {
                    case 1 :
                        user = User.signUp(username, password);
                        if (user != User.nullUser) {
                            //openMainFrame(user);
                            credentials.dispose();
                            break;
                        } else {
                            credentials.dispose();
                            createCredentialsDialog(1);
                            break;
                        }
                    case 2 :
                        user = User.logIn(username, password);
                        if (user != User.nullUser) {
                            //openMainFrame(user);
                            credentials.dispose();
                        } else {
                            credentials.dispose();
                            createCredentialsDialog(2);
                        }
                }
            }

        });

    }

    public static void main(String[] args) {
        openFrame();
    }
}
