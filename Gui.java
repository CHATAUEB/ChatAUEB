import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui {

    public static JFrame entryFrame;
    public static JFrame mainFrame;
    public static JFrame questionnaireFrame;
    public static JFrame promptFrame;
    public static JFrame aboutUsFrame;
    public static JFrame helpFrame;
    public static JFrame FAQFrame;
    public static JFrame responseFrame;

    private static User user;

    static Color BLACK = new Color(51, 51, 51);
    static Color RED = new Color(158, 22, 22);

    public static void openEntryFrame() {
        entryFrame = new JFrame("CHATAUEB - Credentials");

        entryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        entryFrame.setSize(500, 500);

        createEntryLabel();
        createEntryButtons(); // Call createButtons to add buttons to the frame

        entryFrame.getContentPane().setBackground(BLACK);
        entryFrame.setLayout(null);
        entryFrame.setVisible(true);
    }

    public static void createEntryLabel() {
        JLabel label = new JLabel("Welcome to ");
        label.setBounds(13, 50, 480, 50); // Adjusted the width to 480 for centering
        label.setForeground(Color.WHITE); //White text colour font
        label.setHorizontalAlignment(JLabel.CENTER); // Center the text
        
        // Set the font to bold
        Font boldFont = new Font(label.getFont().getFontName(), Font.BOLD, 20);
        label.setFont(boldFont);

        entryFrame.add(label);

         // Upload the png
        ImageIcon image = new ImageIcon("lib/CA.png");
        JLabel label2 = new JLabel();
        label2.setIcon(image);
        label2.setBounds(176, 75, 150, 150);
        label2.setHorizontalAlignment(JLabel.CENTER);

        //label2.setForeground(RED);
        //label2.setFont(boldFont);

        entryFrame.add(label2);
    }

    public static void createEntryButtons() {
        //int labelHeight = 100; // Height of the label

        int labelx = 200; // X of the label

        // Add buttons for sign up, log in, and change password
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(labelx - 125, 230, 100, 30); // ALLAGES!!//:X apo 200 se 75,labelheight apo 100 se 230 //Centered vertically based on label height
        signUpButton.setBackground(RED);
        signUpButton.setForeground(Color.WHITE);
        entryFrame.add(signUpButton);

        JButton loginButton = new JButton("Log In");
        loginButton.setBounds(labelx, 230, 100, 30); //ALLAGES!!//:label height apo 140 se 230 //Centered vertically based on label height
        loginButton.setBackground(RED);
        loginButton.setForeground(Color.WHITE);
        entryFrame.add(loginButton);

        JButton guestButton = new JButton("Enter as a guest");
        guestButton.setBounds(labelx + 125, 230, 130, 30); //ALLAGES!!//:Width apo 150 se 130,label height apo 180 se 230,x apo 175 se 325
        guestButton.setBackground(RED);
        guestButton.setForeground(Color.WHITE);
        entryFrame.add(guestButton);

        // Add action listeners for the buttons
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCredentialsDialog(1); //calls a dialog used to verify credentials, the number signifies the action the method createCredentialsDialog should take, 1 is for signUp, 2 is for logIn
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCredentialsDialog(2); //calls a dialog used to verify credentials
            }
        });

        guestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user = User.guestUser;
                user.clearAnswers();
                openMainFrame();
            }
        });


    }

    public static void createCredentialsDialog(int action) {
        //Creates the dialog used for credentials verification
        JDialog credentials = new JDialog();
        credentials.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        credentials.setSize(300, 300);
        credentials.getContentPane().setBackground(BLACK);

        credentials.setVisible(true);
        credentials.setLayout(null);

        //Panel containing the label and textfield for the username
        JPanel userPanel = new JPanel();
        userPanel.setBounds(100, 70, 100, 40);
        userPanel.setBackground(BLACK);

        JLabel userLabel = new JLabel("Username: ");
        userLabel.setBounds(100, 70, 100, 20);
        userLabel.setForeground(Color.WHITE);


        JTextField userText = new JTextField(30);
        userText.setBounds(100, 90, 100, 20);
        
        credentials.add(userLabel);
        credentials.add(userText);

        credentials.add(userPanel);

        //Panel containing the label and textfield for the password
        JPanel passPanel = new JPanel();
        passPanel.setBounds(100, 110, 100, 40);
        passPanel.setBackground(BLACK);

        JLabel passLabel = new JLabel("Password: ");
        passLabel.setBounds(100, 110, 100, 20);
        passLabel.setForeground(Color.WHITE);

        JPasswordField passText = new JPasswordField(30);
        passText.setBounds(100, 130, 100, 20);

        credentials.add(passLabel);
        credentials.add(passText);

        credentials.add(passPanel);
        
        //Button used to get credentials and login or sign up
        JButton enter = new JButton("Enter");
        enter.setBackground(RED);
        enter.setForeground(Color.WHITE);
        enter.setBounds(190, 200, 70, 30);
               
        credentials.add(enter); 

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText(); //When the enter button is pressed the credentials entered by the user are retrieved 
                String password = new String(passText.getPassword());
                switch (action) {
                    case 1 : //The dialog was called from the signUp button
                        user = User.signUp(username, password); //Creating a User Object using the method signUp()
                        if (!user.equals(User.nullUser)) { //If the registration was successful
                            openMainFrame(); //Open the main frame with the User Object
                            credentials.dispose(); //Close the credentials dialog
                            entryFrame.dispose(); //Close the entry frame
                            break;
                        } else { //The registration was not successful
                            credentials.dispose(); //Close the credentials dialog
                            createCredentialsDialog(1); //Open the credentials dialog again
                            break;
                        }
                    case 2 : //The dialog was called from the logIn button
                        user = User.logIn(username, password); //Creating a User Object using the method logIn()
                        if (!user.equals(User.nullUser)) { //If the connection was successful
                            openMainFrame(); //Open the main frame with the User Object
                            credentials.dispose(); //Close the credentials dialog
                            entryFrame.dispose(); //Close the entry frame
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
        backButton.setBackground(RED);
        backButton.setForeground(Color.WHITE);
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
    public static void openMainFrame() {
        mainFrame = new JFrame("ChatAUEB - Menu");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.getContentPane().setBackground(BLACK);
        entryFrame.setVisible(false);

        JMenuBar menuBar = createMenuBar(mainFrame);
        mainFrame.setJMenuBar(menuBar);
        mainFrame.setVisible(true);
        mainFrame.add(createMainLabelPhoto()); 
       //mainFrame.add(createMainLabelText());  
    }

    //Method used to import png(photo of university) on the main frame

    public static JLabel createMainLabelPhoto() {

        ImageIcon image = new ImageIcon("lib/Μαράσλειο_Μέγαρο_9723.jpg");
        JLabel label = new JLabel();
        label.setIcon(image);
        label.setBounds(500, 30, 1000, 1000);
        label.setHorizontalAlignment(JLabel.CENTER);  
        return label;   
    }

    public static JLabel createMainLabelText() {

        JLabel label = new JLabel("ChatAUEB : Ο επαγγελματικός οδηγός του Οικονομικού Πανεπιστημίου Αθηνών.");
        label.setBounds(500, 500, 480, 50); // Adjusted the width to 480 for centering
        label.setForeground(Color.WHITE); //White text colour font
        label.setHorizontalAlignment(JLabel.CENTER); // Center the text
        
        // Set the font to bold
        Font boldFont = new Font(label.getFont().getFontName(), Font.BOLD, 20);
        label.setFont(boldFont);
        return label;
    }

    
    
    //Method used to create all the components included in the MenuBar
    public static JMenuBar createMenuBar(JFrame calledByFrame) {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(RED);

        JMenu questionnaire = createQuestionnaireMenu(calledByFrame); //line 209
        questionnaire.setForeground(Color.WHITE);
        menuBar.add(questionnaire);

        JMenu chat = createChatMenu(calledByFrame); //line 238
        chat.setForeground(Color.WHITE);
        menuBar.add(chat);

        JMenu aboutUs = createAboutUsMenu(calledByFrame); //line 257
        aboutUs.setForeground(Color.WHITE);
        menuBar.add(aboutUs);

        JMenu help = createHelpMenu(calledByFrame); //line 288
        help.setForeground(Color.WHITE);
        menuBar.add(help);
 
        menuBar.add(Box.createHorizontalGlue()); //used to send the user menu to the far right of the screen

        JMenu userMenu = createUserMenu(); //line 331
        userMenu.setForeground(Color.WHITE);
        menuBar.add(userMenu);

        return menuBar;
    }
    
    //Method used to create the first menu in the main frame. It includes options to fill in the questionnaire and to view the user's answer already given
    public static JMenu createQuestionnaireMenu(JFrame calledByFrame) {
        JMenu questionnaire = new JMenu("Questionnaire");
        questionnaire.setBackground(RED);
        questionnaire.setForeground(Color.WHITE);

        JMenuItem answer = new JMenuItem("Fill in questionnaire");
        answer.setBackground(RED);
        answer.setForeground(Color.WHITE);
        
        JMenuItem view = new JMenuItem("See your answers");
        view.setBackground(RED);
        view.setForeground(Color.WHITE);

        answer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openQuestionnaireFrame(1);
                calledByFrame.dispose();
            }
        });

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openQuestionnaireFrame(2);
                calledByFrame.dispose();
            }
        });

        questionnaire.add(answer);
        questionnaire.add(view);

        return questionnaire;
    }

    //Questionnaire frame used to answer the questionnaire (action = 1) or view the user's previous answers (action = 2)
    public static void openQuestionnaireFrame(int action) {
        questionnaireFrame = new JFrame("CHATAUEB - Questionnaire");
        questionnaireFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionnaireFrame.setSize(1024, 1024);
        questionnaireFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        questionnaireFrame.setLayout(new BorderLayout());

        questionnaireFrame.setVisible(true);
        mainFrame.setVisible(false);
        
        JPanel questionnairePanel = new JPanel(new GridLayout(0,1, 20, 20));
        questionnairePanel.setBackground(BLACK);
        questionnairePanel.setBounds(40, 20, 2048, 5100);

        //Creating a similiar menu to the one in the main frame
        JMenuBar menuBar = createMenuBar(questionnaireFrame);
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
        radioButtons = initializeRadioButtons(radioButtons); 

        switch (action) {
            case 1 : 
                for (int i = 0; i < Questions.questionsLength; i++) {
                    questionnairePanel.add(questions[i]);
                    buttonGroups[i] = new ButtonGroup();

                    for (int j = 1; j < Questions.choices + 1; j++) {
                        if (!(Questions.fullQuestions[i][j].equals(""))) {
                            radioButtons[i][j] = new JRadioButton(Questions.fullQuestions[i][j]);
                            radioButtons[i][j].setBackground(BLACK);
                            radioButtons[i][j].setForeground(Color.WHITE);
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
                            radioButtons[i][j].setBackground(BLACK);
                            radioButtons[i][j].setForeground(Color.WHITE);
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
                buttonsPanel.setBackground(BLACK);
        
                final JRadioButton[][] tempRadioButtons = radioButtons;

                JButton enter = new JButton("Enter");
                enter.setBackground(RED);
                enter.setForeground(Color.WHITE);
                
                enter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        processAnswers(tempRadioButtons);
                        int count = user.countAnswers();
                        if (count < 10) {
                            JDialog dialog = new JDialog();
                            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                            dialog.setSize(400, 400);
                            dialog.getContentPane().setBackground(BLACK);
                            dialog.setLayout(null);
                            dialog.setVisible(true);

                            JLabel warning1 = new JLabel("Έχεις απαντήσει σε " + count + " απαντήσεις");
                            JLabel warning2 = new JLabel("Προτείνουμε να απαντήσεις σε περισσότερες από 10 ερωτήσεις");
                            warning1.setBounds(10, 30, 380, 30);
                            warning1.setBackground(BLACK);
                            warning1.setForeground(Color.WHITE);
                            warning2.setBounds(10, 60, 380, 30);
                            warning2.setBackground(BLACK);
                            warning2.setForeground(Color.WHITE);
                            dialog.add(warning1);
                            dialog.add(warning2);

                            JButton back = new JButton("Back");
                            back.setBackground(RED);
                            back.setForeground(Color.WHITE);
                            
                            back.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    dialog.dispose();
                                }
                            });
                            back.setBounds(10, 240, 150, 30);
                            dialog.add(back);

                            JButton cont = new JButton("Continue Anyway");
                            cont.setBackground(RED);
                            cont.setForeground(Color.WHITE);
                            
                            cont.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    dialog.dispose();
                                    questionnaireFrame.dispose();
                                    openResponseFrame("");
                                }
                            });
                            cont.setBounds(230, 240, 150, 30);
                            dialog.add(cont);
                
                        } else {
                            questionnaireFrame.dispose();
                            openResponseFrame("");
                        }
                    }
                });

                JButton back = new JButton("Back");
                back.setBackground(RED);
                back.setForeground(Color.WHITE);
                
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
            ret[i].setBackground(BLACK);
            ret[i].setForeground(Color.WHITE);
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

    public static void processAnswers(JRadioButton[][] radioButtons) {
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
        if (!(user.equals(User.guestUser) || user.equals(User.nullUser))) {
            ConnectionDB.updateAns(user);
        }
    }

    //Method used to create the second menu in the main frame. It includes an option to send a message to ChatGPT directly
    public static JMenu createChatMenu(JFrame calledByFrame) {
        JMenu chat = new JMenu("Chat with ChatAUEB");
        chat.setBackground(RED);
        chat.setForeground(Color.WHITE);

        JMenuItem prompt = new JMenuItem("Direct Prompt");
        prompt.setBackground(RED);
        prompt.setForeground(Color.WHITE);

        prompt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPromptFrame(calledByFrame);
            }
        });

        chat.add(prompt);

        return chat;
    }

    public static void openPromptFrame(JFrame calledByFrame) {
        promptFrame = new JFrame("CHATAUEB - Direct Prompt");
        promptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        promptFrame.setSize(500, 500);
        promptFrame.setLayout(null);
        promptFrame.getContentPane().setBackground(BLACK); 

        promptFrame.setVisible(true);
        //calledByFrame.setVisible(false); 
        
        JMenuBar menuBar = createMenuBar(promptFrame);
        menuBar.setBackground(RED);
        menuBar.setForeground(Color.WHITE);
        promptFrame.add(menuBar);
        
        JLabel promptLabel1 = new JLabel("Write down a question you would like to ask ChatGPT based on");
        promptLabel1.setBounds(50, 100, 400, 20);
        promptLabel1.setForeground(Color.WHITE);
        promptFrame.add(promptLabel1);

        JLabel promptLabel2 = new JLabel("the information you have filled out");
        promptLabel2.setBounds(50, 120, 400, 20);
        promptLabel2.setForeground(Color.WHITE);
        promptFrame.add(promptLabel2);

        JTextField promptField = new JTextField();
        promptField.setBounds(50, 160, 400, 40);
        promptFrame.add(promptField);

        JButton enter = new JButton("Enter");
        enter.setBackground(RED);
        enter.setForeground(Color.WHITE);

        enter.setBounds(400, 250, 70, 20);
        promptFrame.add(enter);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prompt = promptField.getText();
                promptFrame.dispose();
                openResponseFrame(prompt);
            }
        });
        
        JButton view = new JButton("View Answers");
        view.setBackground(RED);
        view.setForeground(Color.WHITE);
        view.setBounds(200, 250, 120, 20);
        promptFrame.add(view);

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openQuestionnaireFrame(2);
            }
        });

        JButton back = new JButton("Back");
        back.setBackground(RED);
        back.setForeground(Color.WHITE);
        back.setBounds(50, 250, 70, 20);
        promptFrame.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promptFrame.dispose();
                calledByFrame.setVisible(true);
            }
        });
    }

    public static void openResponseFrame(String prompt) {        
        responseFrame = new JFrame("ChatAUEB - Response");
        responseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        responseFrame.setSize(1024, 1024);
        responseFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        responseFrame.setVisible(true);
        responseFrame.setLayout(new BorderLayout());

        JMenuBar menuBar = createMenuBar(responseFrame);
        responseFrame.add(menuBar, BorderLayout.NORTH);

        JPanel responsePanel = new JPanel();
        responsePanel.setLayout(null);
        responsePanel.setSize(2048, 2048);
        responsePanel.setBackground(BLACK);
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

                String appropriateResponse = createAppropriateResponse(Message.retResponse);
                progress.bar.setValue(100);
                progress.bar.setString("Done");
                progress.bar.setVisible(false); 
                
                JLabel responseLabel = new JLabel();
                responseLabel.setText(appropriateResponse);
                responseLabel.setHorizontalAlignment(JLabel.CENTER);
                responseLabel.setBounds(100, 50, 1000, 600);
                responseLabel.setBackground(BLACK);
                responseLabel.setForeground(Color.WHITE);
                responsePanel.add(responseLabel);

                JPanel buttonsPanel = new JPanel(new GridLayout(1,1,20,0));

                JButton back = new JButton("Back");
                back.setBackground(RED);
                back.setForeground(Color.WHITE);
                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        responseFrame.dispose();
                        mainFrame.setVisible(true);
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

    //Method used to create the third menu in the main frame. It includes options to read about our purpose and about our members
    public static JMenu createAboutUsMenu(JFrame calledByFrame) {
        JMenu aboutUs = new JMenu("About Us");
        aboutUs.setBackground(RED);
        aboutUs.setForeground(Color.WHITE);

        JMenuItem aboutUsItem = new JMenuItem("Purpose and Team");
        aboutUsItem.setBackground(RED);
        aboutUsItem.setForeground(Color.WHITE);

        aboutUsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAboutUsFrame();
                calledByFrame.dispose();
            }
        });
        aboutUs.add(aboutUsItem);

        return aboutUs;
    }

    public static void openAboutUsFrame() {
        aboutUsFrame = new JFrame("CHATAUEB - About Us");
        aboutUsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutUsFrame.setSize(1024, 1024);
        aboutUsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        aboutUsFrame.setLayout(new BorderLayout()); 

        aboutUsFrame.setVisible(true);
        mainFrame.setVisible(false);

        JMenuBar menuBar = createMenuBar(aboutUsFrame);
        aboutUsFrame.add(menuBar, BorderLayout.NORTH);

        JPanel nullPanel = new JPanel();
        nullPanel.setBackground(BLACK);
        aboutUsFrame.add(nullPanel, BorderLayout.WEST);

        JPanel aboutUsPanel = new JPanel();
        aboutUsPanel.setLayout(null);
        aboutUsPanel.setBackground(BLACK);
        aboutUsFrame.add(aboutUsPanel, BorderLayout.CENTER);

        JLabel purposeLabel = new JLabel();
        purposeLabel.setBounds(0, 0, 1500, 200);
        purposeLabel.setText(Labels.PURPOSE);
        purposeLabel.setForeground(Color.WHITE);
        aboutUsPanel.add(purposeLabel);

        JLabel teamLabel = new JLabel();
        teamLabel.setBounds(0, 150, 1500, 600);
        teamLabel.setText(Labels.TEAM);
        teamLabel.setForeground(Color.WHITE);
        aboutUsPanel.add(teamLabel);

        aboutUsFrame.setVisible(true);
    }

    //Method used to create the fourth menu in the main frame. It includes options to help the user understand the usage of the questionnaire and the direct prompt as well as look at some frequently asked questions
    public static JMenu createHelpMenu(JFrame calledByFrame) {
        JMenu help = new JMenu("Help");
        help.setBackground(RED);
        help.setForeground(Color.WHITE);

        JMenuItem questionnaire = new JMenuItem("Questionnaire");
        questionnaire.setBackground(RED);
        questionnaire.setForeground(Color.WHITE);

        JMenuItem getHelp = new JMenuItem("Help");
        getHelp.setBackground(RED);
        getHelp.setForeground(Color.WHITE);

        getHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openHelpFrame();
                calledByFrame.dispose();
            }
        });

        help.add(getHelp);

        JMenuItem faq = new JMenuItem("FAQ's");
        faq.setBackground(RED);
        faq.setForeground(Color.WHITE);

        faq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFAQFrame();
                calledByFrame.dispose();
            }
        });

        help.add(faq);

        return help;
    }

    public static void openHelpFrame() {
        helpFrame = new JFrame("CHATAUEB - Help");
        helpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        helpFrame.setSize(1024, 1024);
        helpFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        helpFrame.setLayout(new BorderLayout()); 

        helpFrame.setVisible(true);
        mainFrame.setVisible(false);

        JMenuBar menuBar = createMenuBar(helpFrame);
        helpFrame.add(menuBar, BorderLayout.NORTH);

        JPanel nullPanel = new JPanel();
        nullPanel.setBackground(BLACK);
        helpFrame.add(nullPanel, BorderLayout.WEST);

        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(null);
        helpPanel.setBackground(BLACK);
        helpFrame.add(helpPanel, BorderLayout.CENTER);

        JLabel helpLabel = new JLabel();
        helpLabel.setBounds(0, 0, 1500, 800);
        helpLabel.setText(Labels.HELP);
        helpLabel.setForeground(Color.WHITE);
        helpPanel.add(helpLabel);

        helpFrame.setVisible(true);
    }

    public static void openFAQFrame() {
        FAQFrame = new JFrame("CHATAUEB - FAQ's");
        FAQFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FAQFrame.setSize(1024, 1024);
        FAQFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        FAQFrame.setLayout(new BorderLayout());

        FAQFrame.setVisible(true);
        mainFrame.setVisible(false);

        JMenuBar menuBar = createMenuBar(FAQFrame);
        FAQFrame.add(menuBar, BorderLayout.NORTH);

        JPanel nullPanel = new JPanel();
        nullPanel.setBackground(BLACK);
        FAQFrame.add(nullPanel, BorderLayout.WEST);

        JPanel FAQPanel = new JPanel();
        FAQPanel.setLayout(null);
        FAQPanel.setBackground(BLACK);
        FAQFrame.add(FAQPanel, BorderLayout.CENTER);

        JLabel FAQLabel = new JLabel();
        FAQLabel.setBounds(0, 0, 1500, 800);
        FAQLabel.setText(Labels.FAQ);
        FAQLabel.setForeground(Color.WHITE);
        FAQPanel.add(FAQLabel);

        FAQFrame.setVisible(true);
    }

    //Method used to create the fifth and final menu in the main frame. It includes an option to log out from the app
    public static JMenu createUserMenu() {
        JMenu userMenu = new JMenu(user.username);

        JMenuItem logOut = new JMenuItem("Log Out");
        logOut.setBackground(RED);
        logOut.setForeground(Color.WHITE);

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                openEntryFrame();
            }
        });

        userMenu.add(logOut);

        return userMenu;
    }



    

    public static void main(String[] args) {
        Questions.createQuestions();
        Labels.createLabels();
        User.UserList.clear();
        User.createDefaultUsers();
        ConnectionDB.download();
        openEntryFrame();
    }
}
