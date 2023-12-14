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
                createCredentialsDialog(1); //calls a dialog used to verify credentials, the number signifies the action the method createCredentialsDialog should take, 1 is for signUp, 2 is for logIn
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log In button pressed");
                createCredentialsDialog(2); //calls a dialog used to verify credentials
            }
        });
    }

    public static void createCredentialsDialog(int action) {
        //Creates the dialog used for credentials verification
        JDialog credentials = new JDialog();
        credentials.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        credentials.setSize(500, 500);

        credentials.setVisible(true);
        credentials.setLayout(null);

        //Panel containing the label and textfield for the username
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
                String username = userText.getText(); //When the enter button is pressed the credentials entered by the user are retrieved 
                String password = passText.getText();
                User user;
                switch (action) {
                    case 1 : //The dialog was called from the signUp button
                        user = User.signUp(username, password); //Creating a User Object using the method signUp ()
                        if (!user.equals(User.nullUser)) { //If the registration was successful
                            //openMainFrame(user); //Open the main frame from which the user can answer the questionnaire
                            credentials.dispose(); //Close the credentials dialog
                            break;
                        } else { //The registration was not successful
                            credentials.dispose(); //Close the credentials dialog
                            createCredentialsDialog(1); //Open the credentials dialog again
                            break;
                        }
                    case 2 :
                        user = User.logIn(username, password);
                        if (!user.equals(User.nullUser)) {
                            //openMainFrame(user);
                            credentials.dispose();
                            break;
                        } else {
                            credentials.dispose();
                            createCredentialsDialog(2);
                            break;
                        }
                }
            }

        });

    }

    public static void main(String[] args) {
        openFrame();
    }
}
