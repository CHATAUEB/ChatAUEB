import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

        //Button used to go back to the entry frame
        JButton backButton = new JButton("Back");
        backButton.setBounds(40, 200, 70, 30);
        
        credentials.add(backButton);

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
        mainFrame.setSize(500, 500);

        JMenuBar menuBar = createMenuBar(user, mainFrame);
        mainFrame.setJMenuBar(menuBar);

        mainFrame.setVisible(true);        
    }
    
    //Method used to create all the components included in the MenuBar
    public static JMenuBar createMenuBar(User user, JFrame mainFrame) {
        JMenuBar menuBar = new JMenuBar();

        JMenu questionnaire = createQuestionnaireMenu(user, mainFrame); //line 209
        menuBar.add(questionnaire);

        JMenu chat = createChatMenu(user, mainFrame); //line 238
        menuBar.add(chat);

        JMenu aboutUs = createAboutUsMenu(); //line 257
        menuBar.add(aboutUs);

        JMenu help = createHelpMenu(); //line 288
        menuBar.add(help);
 
        menuBar.add(Box.createHorizontalGlue()); //used to send the user menu to the far right of the screen

        JMenu userMenu = createUserMenu(user, mainFrame); //line 331
        menuBar.add(userMenu);

        return menuBar;
    }
    
    //Method used to create the first menu in the main frame. It includes options to fill in the questionnaire and to view the user's answer already given
    public static JMenu createQuestionnaireMenu(User user, JFrame mainFrame) {
        JMenu questionnaire = new JMenu("Questionnaire");

        JMenuItem answer = new JMenuItem("Fill in questionnaire");
        JMenuItem view = new JMenuItem("See your answers");

        answer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openQuestionnaireFrame(user, 1, mainFrame);
                System.out.println("Fill in button pressed");
            }
        });

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openQuestionnaireFrame(user, 2, mainFrame);
                System.out.println("View button pressed");
            }
        });

        questionnaire.add(answer);
        questionnaire.add(view);

        return questionnaire;
    }

    //Method used to create the second menu in the main frame. It includes an option to send a message to ChatGPT directly
    public static JMenu createChatMenu(User user, JFrame mainFrame) {
        JMenu chat = new JMenu("Chat with ChatAUEB");

        JMenuItem prompt = new JMenuItem("Direct Prompt");

        prompt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPromptFrame(user, mainFrame);
                System.out.println("Chat button pressed");
            }
        });

        chat.add(prompt);

        return chat;
    }

    //Method used to create the third menu in the main frame. It includes options to read about our purpose and about our members
    public static JMenu createAboutUsMenu() {
        JMenu aboutUs = new JMenu("About Us");

        JMenuItem purpose = new JMenuItem("Purpose");

        purpose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //openPurposeFrame
                System.out.println("Purpose button pressed");
            }
        });

        aboutUs.add(purpose);

        JMenuItem members = new JMenuItem("Our Team");

        members.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //openMembersFrame
                System.out.println("Members button pressed");
            }
        });

        aboutUs.add(members);

        return aboutUs;
    }

    //Method used to create the fourth menu in the main frame. It includes options to help the user understand the usage of the questionnaire and the direct prompt as well as look at some frequently asked questions
    public static JMenu createHelpMenu() {
        JMenu help = new JMenu("Help");

        JMenuItem questionnaire = new JMenuItem("Questionnaire");

        questionnaire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //openHelpFrame(action 1)
                System.out.println("Questionnaire Help button pressed");
            }
        });

        help.add(questionnaire);

        JMenuItem prompt = new JMenuItem("Direct Prompt");

        prompt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //openHelpFrame(action 2)
                System.out.println("Chat Help button pressed");
            }
        });

        help.add(prompt);

        JMenuItem faq = new JMenuItem("FAQ's");

        faq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //openHelpFrame(action 3)
                System.out.println("FAQ button pressed");
            }
        });

        help.add(faq);

        return help;
    }

    //Method used to create the fifth and final menu in the main frame. It includes options to change a user's credentials and log out from the app
    public static JMenu createUserMenu(User user, JFrame mainFrame) {
        JMenu userMenu = new JMenu(user.username);

        JMenuItem changeUsername = new JMenuItem("Change username");

        changeUsername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //openChangeFrame(action 1)
                System.out.println("Change Username button pressed");
            }
        });

        userMenu.add(changeUsername);

        JMenuItem changePassword = new JMenuItem("Change password");

        changeUsername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //openChangeFrame(action 2)
                System.out.println("Change Password button pressed");
            }
        });

        userMenu.add(changePassword);

        JMenuItem logOut = new JMenuItem("Log Out");

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                openFrame();
                System.out.println("Log Out button pressed");
            }
        });

        userMenu.add(logOut);

        return userMenu;
    }

    //Questionnaire frame used to answer the questionnaire (action = 1) or view the user's previous answers (action = 2)
    public static void openQuestionnaireFrame(User user, int action, JFrame mainFrame) {
        JFrame questionnaireFrame = new JFrame("CHATAUEB - Questionnaire");
        questionnaireFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionnaireFrame.setSize(2045, 2045);
        questionnaireFrame.setLayout(new BorderLayout()); 

        questionnaireFrame.setVisible(true);
        mainFrame.setVisible(false);
        
        JPanel questionnairePanel = new JPanel(null);
        questionnairePanel.setBounds(0, 20, 2048, 5100);

        //Creating a similiar menu to the one in the main frame
        JMenuBar menuBar = createMenuBar(user, questionnaireFrame);
        questionnaireFrame.add(menuBar, BorderLayout.NORTH);

        //Creating the two dimensional array containing the questions and choices in the class Questions
        Questions.createQuestions();
        
        //Creating a one dimensional array containing the questions only
        String[] questionsOnly = Questions.createQuestionsOnly(Questions.fullQuestions);

        //Creating a JTextArea array including only the main questions without the choices
        JLabel[] questions = createTextAreas(questionsOnly);

        //Creating a ButtonGroup array used to contain the choices in the form of JRadioButtons
        ButtonGroup[] buttonGroups = new ButtonGroup[Questions.questionsLength];

        //Creating a two dimensional JRadioButton array in order to store all of the choices a user has,
        //while simultaneously sorting them according to the question to which they belong to
        JRadioButton[][] radioButtons = new JRadioButton[Questions.questionsLength][Questions.choices + 1];
        radioButtons = initializeRadioButtons(radioButtons); //Line 506
        
        //The dimensions of the bounds for all the questions and the choices
        int x = 40; 
        int y = 10;
        int width = 2000;
        int height = 40;

        switch (action) {
            case 1 : 
                for (int i = 0; i < Questions.questionsLength; i++) {
                    questions[i].setBounds(x, y, width, height);
                    questionnairePanel.add(questions[i]);
                    buttonGroups[i] = new ButtonGroup();
                    y += 40;

                    for (int j = 1; j < Questions.choices + 1; j++) {
                        if (!(Questions.fullQuestions[i][j].equals("")))
                            radioButtons[i][j] = new JRadioButton(Questions.fullQuestions[i][j]);
                            radioButtons[i][j].setBounds(x, y, width, height);
                            buttonGroups[i].add(radioButtons[i][j]);
                            questionnairePanel.add(radioButtons[i][j]);
                            y += 40;
                    }

                }

                final JRadioButton[][] tempRadioButtons = radioButtons;

                JButton enter = new JButton("Enter");
                enter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        processAnswers(user, tempRadioButtons); //Line 507
                        questionnaireFrame.dispose();
                        mainFrame.setVisible(true);
                    }
                });

                questionnairePanel.add(enter, BorderLayout.SOUTH);
                break;

            case 2 :
                JLabel[] answers = createTextAreas(user.answers);
                for (int i = 0; i < User.answersLength; i++) {
                    questions[i].setBounds(x, y, width, height);
                    questionnairePanel.add(questions[i]);
                    y += y;

                    answers[i].setBounds(x, y, width, height);
                    questionnairePanel.add(answers[i]);
                    y += y;
                }

                JButton back = new JButton("Back");

                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        questionnaireFrame.dispose();
                        mainFrame.setVisible(true);
                    }
                });

                questionnairePanel.add(back, BorderLayout.SOUTH);
                break;
        }
        
        //Adding a scroll bar
        JScrollPane scrollPane = new JScrollPane(questionnairePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        scrollPane.setPreferredSize(new Dimension(2048,2048));

        questionnaireFrame.add(scrollPane, BorderLayout.CENTER);
    }

    public static JLabel[] createTextAreas(String[] array) {
        JLabel[] ret = new JLabel[Questions.questionsLength];
        for (int i = 0; i < Questions.questionsLength; i++) {
            ret[i] = new JLabel(i+1 + ") " + array[i]);
        }
        return ret;
    }

    public static JRadioButton[][] initializeRadioButtons(JRadioButton[][] radioButtons) {
        JRadioButton[][] ret = new JRadioButton[Questions.questionsLength][Questions.choices + 1];
        for (int i = 0; i < Questions.questionsLength ; i ++) {
            for (int j = 0; j < Questions.choices + 1; j++) {
                ret[i][j] = new JRadioButton("", false); 
            }
        }
        return ret;
    }

    public static void processAnswers(User user, JRadioButton[][] radioButtons) {
        for (int i = 0; i < Questions.questionsLength; i++) {
            String answer = "";
            for (int j = 0; j < Questions.choices + 1; j++) {
                if(radioButtons[i][j].isSelected()) {
                    answer = radioButtons[i][j].getText();
                    break;
                }
            }
            user.answers[i] = answer;
        }
    }

    public static void openPromptFrame(User user, JFrame mainFrame) {
        JFrame promptFrame = new JFrame("CHATAUEB - Direct Prompt");
        promptFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        promptFrame.setSize(500, 500);
        promptFrame.setLayout(null); 

        promptFrame.setVisible(true);
        mainFrame.setVisible(false); 
        
        JMenuBar menuBar = createMenuBar(user, mainFrame);
        promptFrame.add(menuBar);
        
        JLabel promptLabel1 = new JLabel("Write down a question you would like to ask ChatGPT based on");
        promptLabel1.setBounds(50, 100, 400, 20);
        promptFrame.add(promptLabel1);

        JLabel promptLabel2 = new JLabel("the information you have filled out");
        promptLabel2.setBounds(50, 120, 400, 20);
        promptFrame.add(promptLabel2);

        JTextField promptField = new JTextField();
        promptField.setBounds(50, 160, 400, 40);
        promptFrame.add(promptField);

        JButton enter = new JButton("Enter");
        enter.setBounds(400, 250, 70, 20);
        promptFrame.add(enter);
        
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prompt = promptField.getText();
                //QueryBuilder.build(questions, answers, prompt);
                promptFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        
        JButton view = new JButton("View Answers");
        view.setBounds(50, 250, 120, 20);
        promptFrame.add(view);

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //openQuestionnaireFrame(action 2)
                System.out.println("View button pressed");
            }
        });
    }

    public static void main(String[] args) {
        openFrame();
    }
}
