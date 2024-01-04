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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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

        JButton guestButton = new JButton("Enter as a guest");
        guestButton.setBounds(175, labelHeight + 80, 150, 30);
        frame.add(guestButton);

        // Add action listeners for the buttons
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sign Up button pressed");
                createCredentialsDialog(1, frame); //calls a dialog used to verify credentials, the number signifies the action the method createCredentialsDialog should take, 1 is for signUp, 2 is for logIn
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log In button pressed");
                createCredentialsDialog(2, frame); //calls a dialog used to verify credentials
            }
        });

        guestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Guest button pressed");
                User user = User.guestUser;
                user.clearAnswers();
                openMainFrame(user, frame);
            }
        });


    }

    public static void createCredentialsDialog(int action, JFrame calledByFrame) {
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
                        user = User.signUp(username, password, calledByFrame); //Creating a User Object using the method signUp()
                        if (!user.equals(User.nullUser)) { //If the registration was successful
                            openMainFrame(user, calledByFrame); //Open the main frame with the User Object
                            credentials.dispose(); //Close the credentials dialog
                            frame.dispose(); //Close the entry frame
                            break;
                        } else { //The registration was not successful
                            credentials.dispose(); //Close the credentials dialog
                            createCredentialsDialog(1, calledByFrame); //Open the credentials dialog again
                            break;
                        }
                    case 2 : //The dialog was called from the logIn button
                        user = User.logIn(username, password, calledByFrame); //Creating a User Object using the method logIn()
                        if (!user.equals(User.nullUser)) { //If the connection was successful
                            openMainFrame(user, calledByFrame); //Open the main frame with the User Object
                            credentials.dispose(); //Close the credentials dialog
                            frame.dispose(); //Close the entry frame
                            break;
                        } else { //If the connection was not successful
                            credentials.dispose(); //Close the credentials dialog
                            createCredentialsDialog(2, calledByFrame); //Open the credentials dialog again
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
    public static void openMainFrame(User user, JFrame calledByFrame) {
        JFrame mainFrame = new JFrame("ChatAUEB - Menu");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        calledByFrame.setVisible(false);

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

    //Method used to create the fifth and final menu in the main frame. It includes an option to log out from the app
    public static JMenu createUserMenu(User user, JFrame mainFrame) {
        JMenu userMenu = new JMenu(user.username);

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
        questionnaireFrame.setSize(1024, 1024);
        questionnaireFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        questionnaireFrame.setLayout(new BorderLayout()); 

        questionnaireFrame.setVisible(true);
        mainFrame.setVisible(false);
        
        JPanel questionnairePanel = new JPanel(new GridLayout(0,1, 20, 20));
        questionnairePanel.setBounds(40, 20, 2048, 5100);

        //Creating a similiar menu to the one in the main frame
        JMenuBar menuBar = createMenuBar(user, questionnaireFrame);
        questionnaireFrame.add(menuBar, BorderLayout.NORTH);
        
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

        switch (action) {
            case 1 : 
                for (int i = 0; i < Questions.questionsLength; i++) {
                    questionnairePanel.add(questions[i]);
                    buttonGroups[i] = new ButtonGroup();

                    for (int j = 1; j < Questions.choices + 1; j++) {
                        if (!(Questions.fullQuestions[i][j].equals(""))) {
                            radioButtons[i][j] = new JRadioButton(Questions.fullQuestions[i][j]);
                            buttonGroups[i].add(radioButtons[i][j]);
                            questionnairePanel.add(radioButtons[i][j]);
                        }
                    }
                }
                break;

            case 2 :
                for (int i = 0; i < Questions.questionsLength; i++) {
                    questionnairePanel.add(questions[i]);
                    buttonGroups[i] = new ButtonGroup();

                    for (int j = 1; j < Questions.choices + 1; j++) {
                        if (!(Questions.fullQuestions[i][j].equals(""))) {
                            radioButtons[i][j] = new JRadioButton(Questions.fullQuestions[i][j]);
                            if (radioButtons[i][j].getText().equals(user.answers[i])) {
                                radioButtons[i][j].setSelected(true);
                            }
                            buttonGroups[i].add(radioButtons[i][j]);
                            questionnairePanel.add(radioButtons[i][j]);
                        }
                    }
                }
                break;
            }

                JPanel buttonsPanel = new JPanel(new GridLayout(1,2,20,0));
        
                final JRadioButton[][] tempRadioButtons = radioButtons;

                JButton enter = new JButton("Enter");
                enter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        processAnswers(user, tempRadioButtons);
                        int count = user.countAnswers();
                        if (count < 10) {
                            JDialog dialog = new JDialog();
                            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                            dialog.setSize(400, 400);
                            dialog.setLayout(null);
                            dialog.setVisible(true);

                            JLabel warning1 = new JLabel("Έχεις απαντήσει σε " + count + " απαντήσεις");
                            JLabel warning2 = new JLabel("Προτείνουμε να απαντήσεις σε περισσότερες από 10 ερωτήσεις");
                            warning1.setBounds(10, 30, 380, 30);
                            warning2.setBounds(10, 60, 380, 30);

                            dialog.add(warning1);
                            dialog.add(warning2);

                            JButton back = new JButton("Back");
                            back.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    dialog.dispose();
                                }
                            });
                            back.setBounds(10, 240, 150, 30);
                            dialog.add(back);

                            JButton cont = new JButton("Continue Anyway");
                            cont.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    dialog.dispose();
                                    questionnaireFrame.dispose();
                                    openResponseFrame(user, "", mainFrame);
                                }
                            });
                            cont.setBounds(230, 240, 150, 30);
                            dialog.add(cont);
                
                        } else {
                            questionnaireFrame.dispose();
                            openResponseFrame(user, "", mainFrame);
                        }
                    }
                });

                JButton back = new JButton("Back");
                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        questionnaireFrame.dispose();
                        mainFrame.setVisible(true);
                    }
                });

                buttonsPanel.add(back);
                buttonsPanel.add(enter);
                questionnairePanel.add(buttonsPanel, BorderLayout.SOUTH);
        
        //Adding a scroll bar
        JScrollPane scrollPane = new JScrollPane(questionnairePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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
        promptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                promptFrame.dispose();
                openResponseFrame(user, prompt, mainFrame);
            }
        });
        
        JButton view = new JButton("View Answers");
        view.setBounds(200, 250, 120, 20);
        promptFrame.add(view);

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openQuestionnaireFrame(user, 2, promptFrame);
                System.out.println("View button pressed");
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(50, 250, 70, 20);
        promptFrame.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promptFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
    }

    public static void openResponseFrame(User user, String prompt, JFrame calledByFrame) {        
        JFrame responseFrame = new JFrame("ChatAUEB - Response");
        responseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        responseFrame.setSize(1024, 1024);
        responseFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        responseFrame.setVisible(true);
        responseFrame.setLayout(new BorderLayout());

        JMenuBar menuBar = createMenuBar(user, responseFrame);
        responseFrame.add(menuBar, BorderLayout.NORTH);

        JPanel responsePanel = new JPanel();
        responsePanel.setLayout(null);
        responsePanel.setSize(2048, 2048);
        responseFrame.add(responsePanel, BorderLayout.CENTER);

        String[] questions = Questions.createQuestionsOnly(Questions.fullQuestions);
        String[] answers = user.answers;
        String text = QueryBuilder.query(questions, answers, prompt);
        
        Message msg = new Message(text);
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                msg.run();
            }
        });
        thread1.start();

        ProgressBar progress = new ProgressBar();

        responsePanel.add(progress.bar);
        responseFrame.add(responsePanel);

        progress.start();

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                msg.waitingForResponse();

                System.out.println("Waiting done");

                String appropriateResponse = createAppropriateResponse(Message.retResponse);
                progress.bar.setValue(100);
                progress.bar.setString("Done");
                progress.bar.setVisible(false); 
                
                JLabel responseLabel = new JLabel();
                responseLabel.setText(appropriateResponse);
                responseLabel.setHorizontalAlignment(JLabel.CENTER);
                responseLabel.setBounds(100, 50, 1000, 600);

                responsePanel.add(responseLabel);

                JPanel buttonsPanel = new JPanel(new GridLayout(1,1,20,0));

                JButton back = new JButton("Back");
                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        responseFrame.dispose();
                        calledByFrame.setVisible(true);
                    }  
                });

                buttonsPanel.add(back);
                responseFrame.add(buttonsPanel, BorderLayout.SOUTH);
                responseFrame.setVisible(true);
            }   
        });
        thread2.start();
                    
    }

    public static String createAppropriateResponse(String response) {
        StringBuilder ret = new StringBuilder();
        char[] characters = response.toCharArray();
        ret.append("<html>");
        int count = 0;
        for (int i = 0; i < characters.length; i++) {
            count++;
            if (count > 200 && characters[i] == ' ') {
                ret.append("<br/>");
                count = 0;
            } else {
                if (!(characters[i] == 'n') && !(characters[i] == '\\')) {
                    ret.append(characters[i]);
                } else if (characters[i] == '\\') {
                    ret.append("");
                } else {
                    ret.append("<br/>");
                }
            }
        }
        ret.append("<br/>");
        ret.append("<br/>");
        ret.append("<br/>");
        ret.append("<br/>");
        ret.append("Η παραπάνω απάντηση προκύπτει από την ερμηνεία των απαντήσεών σας από το μοντέλο GPT-3.5 της OpenAI.");
        ret.append(" ");
        ret.append("Η ομάδα του ChatAUEB δεν φέρει καμία ευθύνη για τα παραπάνω αποτέλεσματα και την ορθότητά τους.");
        ret.append("</html>");
        return ret.toString();
    }

    public static void main(String[] args) {
        Questions.createQuestions();
        openFrame();
    }
}
