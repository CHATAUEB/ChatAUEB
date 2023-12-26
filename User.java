import java.util.ArrayList;

import javax.swing.JFrame;

public class User {
    public static final int answersLength = 18; //array size depending on questionnaire size, 30 for testing

    protected String username;
    
    protected String password;
    
    protected String[] answers = new String[answersLength];
    
    protected static ArrayList<User> UserList = new ArrayList<User>(); //list containing all created users

    static User nullUser = new User("", ""); //null User used to show that the connection failed
    static User guestUser = new User("Guest", "1234");

    //A constructor for users with a username and a password.
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        UserList.add(this);
    }
    //Method used to sign up to the database
    public static User signUp(String username, String password, JFrame frame) {
        User returnUser = nullUser; //If the signUp is not successful the method returns the null user
        Error error;
        if (username.equals("") || password.equals("")) { //Checking if the credentials are not null
            error = Error.invalidCredentials;
            Error.displayError(error, frame);
        } else { //If the credentials are valid we should check if the username is taken
            boolean taken = false; //Boolean variable used to check the availability of the username
            for (User tempUser : UserList) { //Getting the credentials from every User in the UserList
                if (tempUser.username.equals("")) { 
                    //If the username is null that means that tempUser is nullUser and in this iteration nothing should happen
                } else {
                    if (tempUser.username.equals(username)) { //If one user has the same username as the one from the inputs
                        taken = true; //The boolean variable becomes true showing that we found a user with the same username
                        error = Error.usernameTaken;
                        Error.displayError(error, frame);
                        break; //Break from the loop, no need to check any further
                    } else {
                        taken = false;
                    }
                }
            }
            if (!taken) { //If there are no matches, the username is available and thus a User objected is created
                returnUser = new User(username, password);
            } 
        }
        return returnUser;
    }


    //A method used to connect into one of the users in the userList, if the connection is successful it returns the user with the given credentials, if not it returns the nullUser in line 11
    public static User logIn(String username, String password, JFrame frame) {
        User returnUser = nullUser;
        Error error;
        if (username.equals("") || password.equals("")) {
            error = Error.invalidCredentials;
            Error.displayError(error, frame);
        } else {
            boolean found = false; //Boolean variable used to check the existence of the username
            for (User tempUser : UserList) { //Getting the credentials from every User in the UserList
                if (tempUser.username.equals("")) { 
                    //If the username is null that means that tempUser is nullUser and in this iteration nothing should happen
                } else {
                    if (tempUser.username.equals(username)) { //If one user has the same username as the one from the inputs
                        if (tempUser.password.equals(password)) {
                            found = true; //The boolean variable becomes true showing that we found a user with the same username
                            returnUser = tempUser;
                            break; //Break from the loop, no need to check any further
                        } else {
                            error = Error.wrongPassword;
                            Error.displayError(error, frame);
                            found = true;
                            break;
                        }
                    } 
                }
            }
            if (!found) {
                error = Error.usernameDoesNotExist;
                Error.displayError(error, frame);
            }
        }
        return returnUser;
    }
    //Method used to change the username
    protected static void SetUsername(String oldUsername, String oldpassword , String newUsername, JFrame calledByFrame) {
        User retUser = logIn(oldUsername, oldpassword, calledByFrame);
        if (!retUser.equals(nullUser)) {
            retUser.username = newUsername;
            //updateDatabase
        }
    }

    //Method used to change the password
    protected static void SetPassword(String oldUsername, String oldpassword , String newPassword, JFrame calledByFrame) {
        User retUser = logIn(oldUsername, oldpassword, calledByFrame);
        if (!retUser.equals(nullUser)) {
            retUser.password = newPassword;
            //updateDatabase
        }
    }

    protected void clearAnswers() {
        for (int i = 0; i < User.answersLength; i++) {
            answers[i] = "";
        }
    }

    protected int countAnswers() {
        int count = 0;
        for (int i = 0; i < User.answersLength; i++) {
            if (!this.answers[i].equals("")) {
                count++;
            }
        }
        return count;
    }
}