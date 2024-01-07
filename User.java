import java.util.ArrayList;

/**
* Class used to create User objects 
*/

public class User {
    public static final int answersLength = 18; 

    protected String username;
    
    protected String password;
    
    protected String[] answers = new String[answersLength];
    
    protected static ArrayList<User> UserList = new ArrayList<User>(); //list containing all created users

    static User nullUser;
    static User guestUser;

    /**
    * Method used to create the default user objects, that is the nullUser and the guestUser.
    * nullUser is created to show that a connection has failed, whether due to invalid credentials, incorrect password, username taken or username not existing in the database
    * @see Error
    */

    public static void createDefaultUsers() {
        nullUser = new User("", ""); 
        guestUser = new User("Guest", "1234");
    }

    /**
    * A constructor for users 
    * @param username the chosen username
    * @param password the chosen password
    */
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        UserList.add(this); //When a user object is created it gets added to the UserList for later reference
    }
    
    /**
    * Method used to sign up to the database
    * In case of failure, it returns the nullUser, in all other scenarios it returns the user created with the given arguments
    * If the user signs up succesfully, their credentials are uploaded to the database for later reference
    * @see ConnectionDB#uploadCred()
    * @param username the chosen username
    * @param password the chosen password
    * @return a user object with the given credentials, or nullUser
    */
    
    public static User signUp(String username, String password) {
        User returnUser = nullUser;
        Error error;
        if (username.equals("") || password.equals("")) { 
            error = Error.invalidCredentials;
            Error.displayError(error, Gui.entryFrame);
        } else { 
            boolean taken = false; 
            for (User tempUser : UserList) { 
                if (tempUser.username.equals("")) { 
                    //If the username is null that means that tempUser is nullUser and in this iteration nothing should happen
                } else {
                    if (tempUser.username.equals(username)) { 
                        taken = true; 
                        error = Error.usernameTaken;
                        Error.displayError(error, Gui.entryFrame);
                        break; 
                    } else {
                        taken = false;
                    }
                }
            }
            if (!taken) { 
                returnUser = new User(username, password);
                ConnectionDB.uploadCred(returnUser); //When the user is created their credentials are uploaded to the database
            }
        }
        return returnUser;
    }

    /**
    * A method used to connect into one of the users in the userList. 
    * If the connection is successful it returns the user with the given credentials, if not it returns the nullUser
    * @param username the chosen username
    * @param password the chosen password
    * @return a user object with the given credentials, or nullUser
    */
    
    public static User logIn(String username, String password) {
        User returnUser = nullUser;
        Error error;
        if (username.equals("") || password.equals("")) {
            error = Error.invalidCredentials;
            Error.displayError(error, Gui.entryFrame);
        } else {
            boolean found = false; 
            for (User tempUser : UserList) { 
                if (tempUser.username.equals("")) { 
                    //If the username is null that means that tempUser is nullUser and in this iteration nothing should happen
                } else {
                    if (tempUser.username.equals(username)) { 
                        if (tempUser.password.equals(password)) {
                            found = true; 
                            returnUser = tempUser;
                            break; 
                        } else {
                            error = Error.wrongPassword;
                            Error.displayError(error, Gui.entryFrame);
                            found = true;
                            break;
                        }
                    } 
                }
            }
            if (!found) {
                error = Error.usernameDoesNotExist;
                Error.displayError(error, Gui.entryFrame);
            }
        }
        return returnUser;
    }

    /* Method used to clear out a users answers.
    * Used primarily to not save a guests answers
    */
    
    protected void clearAnswers() {
        for (int i = 0; i < User.answersLength; i++) {
            answers[i] = "";
        }
    }

    /**
    * Method used to count how many questions a user has answered
    * @see Gui#openQuestionnaireFrame()
    * @return the number of questions that are not empty
    */
    
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
