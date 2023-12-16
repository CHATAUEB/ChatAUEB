import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {

    private static JFrame frame;

    public static void openFrame() {
        frame = new JFrame("CHATAUEB - Credentials");

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
        credentials.setSize(300, 300);

        credentials.setVisible(true);
        credentials.setLayout(null);

        //Panel containing the label and textfield for the username
        JPanel userPanel = new JPanel();
        userPanel.setBounds(100, 70, 100, 40);

        JLabel userLabel = new JLabel("Username: ");
        userLabel.setBounds(100, 70, 100, 20);

        JTextField userText = new JTextField(30);
        userText.setBounds(100, 90, 100, 20);
        
        credentials.add(userLabel);
        credentials.add(userText);

        credentials.add(userPanel);

        //Panel containing the label and textfield for the password
        JPanel passPanel = new JPanel();
        passPanel.setBounds(100, 110, 100, 40);

        JLabel passLabel = new JLabel("Password: ");
        passLabel.setBounds(100, 110, 100, 20);

        JPasswordField passText = new JPasswordField(30);
        passText.setBounds(100, 130, 100, 20);

        credentials.add(passLabel);
        credentials.add(passText);

        credentials.add(passPanel);

 
        
        //Button used to get credentials and login or sign up
        JButton enter = new JButton("Enter");
        enter.setBounds(190, 200, 70, 30);
               
        credentials.add(enter); 

        //Button used to go back to the entry frame
        JButton backButton = new JButton("Back");
        backButton.setBounds(40, 200, 70, 30);
        
        credentials.add(backButton);

        
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText(); //When the enter button is pressed the credentials entered by the user are retrieved 
                String password = new String(passText.getPassword());
                User user;
                switch (action) {
                    case 1 : //The dialog was called from the signUp button
                        user = User.signUp(username, password); //Creating a User Object using the method signUp()
                        if (!user.equals(User.nullUser)) { //If the registration was successful
                            openMainFrame(user); //Open the main frame with the User Object
                            credentials.dispose(); //Close the credentials dialog
                            frame.dispose(); //Close the entry frame
                            break;
                        } else { //The registration was not successful
                            credentials.dispose(); //Close the credentials dialog
                            createCredentialsDialog(1); //Open the credentials dialog again
                            break;
                        }
                    case 2 : //The dialog was called from the logIn button
                        user = User.logIn(username, password); //Creating a User Object using the method logIn()
                        if (!user.equals(User.nullUser)) { //If the connection was successful
                            openMainFrame(user); //Open the main frame with the User Object
                            credentials.dispose(); //Close the credentials dialog
                            frame.dispose(); //Close the entry frame
                            break;
                        } else { //If the connection was not successful
                            credentials.dispose(); //Close the credentials dialog
                            createCredentialsDialog(2); //Open the credentials dialog again
                            break;
                        }
                }
            }

        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                credentials.dispose();
            }
        });

    }

    //The main frame for the application. It contains a menu bar with all the options for the user. 
    public static void openMainFrame(User user) {
        JFrame mainFrame = new JFrame("ChatAUEB - Menu");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000, 1000);

        JMenuBar menuBar = new JMenuBar();
        JMenu questionnaire = new JMenu("Questionnaire");

        JMenuItem answer = new JMenuItem("Fill in questionnaire");
        JMenuItem view = new JMenuItem("See your answers");

        answer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //openQuestionnaireFrame(action 1)
                System.out.println("Fill in button pressed");
            }
        });

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //openQuestionnaireFrame(action 2)
                System.out.println("View button pressed");
            }
        });

        questionnaire.add(answer);
        questionnaire.add(view);

        menuBar.add(questionnaire);

        mainFrame.setJMenuBar(menuBar);

        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);

    }

    public static void main(String[] args) {
        openFrame();
    }
}
