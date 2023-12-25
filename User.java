import java.util.ArrayList;
import java.util.Scanner;

public class User {
    public static final int answersLength = 18; //array size depending on questionnaire size, 30 for testing

    protected String username;
    
    private String password;
    
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
    public static User signUp(String username, String password) {
        User returnUser = nullUser; //If the signUp is not successful the method returns the null user
        if (username.equals("") || password.equals("")) { //Checking if the credentials are not null
            System.out.println("Please enter valid credentials");
        } else { //If the credentials are valid we should check if the username is taken
            boolean taken = false; //Boolean variable used to check the availability of the username
            for (User tempUser : UserList) { //Getting the credentials from every User in the UserList
                if (tempUser.username.equals("")) { 
                    //If the username is null that means that tempUser is nullUser and in this iteration nothing should happen
                } else {
                    if (tempUser.username.equals(username)) { //If one user has the same username as the one from the inputs
                        taken = true; //The boolean variable becomes true showing that we found a user with the same username
                        System.out.println("Username is taken. Please try again");
                        break; //Break from the loop, no need to check any further
                    } else {
                        taken = false;
                    }
                }
            }
            if (!taken) { //If there are no matches, the username is available and thus a User objected is created
                returnUser = new User(username, password);
                System.out.println("Registration was successful. Welcome " + username);
            } 
        }
        return returnUser;
    }


    //A method used to connect into one of the users in the userList, if the connection is successful it returns the user with the given credentials, if not it returns the nullUser in line 11
    public static User logIn(String username, String password) {
        User returnUser = nullUser;
        if (username.equals("") || password.equals("")) {
            System.out.println("Please enter valid credentials");
        } else {
            boolean found = false; //Boolean variable used to check the existence of the username
            for (User tempUser : UserList) { //Getting the credentials from every User in the UserList
                if (tempUser.username.equals("")) { 
                    //If the username is null that means that tempUser is nullUser and in this iteration nothing should happen
                } else {
                    if (tempUser.username.equals(username)) { //If one user has the same username as the one from the inputs
                        if (tempUser.password.equals(password)) {
                            found = true; //The boolean variable becomes true showing that we found a user with the same username
                            System.out.println("Connection was successful. Welcome " + username);
                            returnUser = tempUser;
                            break; //Break from the loop, no need to check any further
                        } else {
                            System.out.println("Wrong password. Please try again");
                            found = true;
                            break;
                        }
                    } 
                }
            }
            if (!found) {
                System.out.println("The username does not exist. Please try again");
            }
        }
        return returnUser;
    }
    //Method used to change the username
    protected void SetUsername(String newUsername) {
        
        //Getting credentials and checking to see if they are correct before changing the username
        Scanner lineReader = new Scanner(System.in);
        System.out.println("Please insert your username and password in order to change your username");
        System.out.print("Username: ");
        String tempUsername = lineReader.nextLine();
        System.out.print("\n" + "Password");
        String tempPassword = lineReader.nextLine();

        User tempUser = logIn(tempUsername, tempPassword); //Using the connect method in order to check that the person trying to change the username has the credentials of said user

        lineReader.close();
        
        if (tempUser != nullUser) {
            this.username = newUsername; //Changes the username to the new one
            System.out.println("Username changed successfully");
        }
    }

    //Method used to change the password
    protected void SetPassword(String newPassword) {
        
        //Getting credentials and checking to see if they are correct before changing the username
        Scanner lineReader = new Scanner(System.in);
        System.out.println("Please insert your username and password in order to change your username");
        System.out.print("Username: ");
        String tempUsername = lineReader.nextLine();
        System.out.print("\n" + "Password");
        String tempPassword = lineReader.nextLine();

        User tempUser = logIn(tempUsername, tempPassword); //Using the connect method in order to check that the person trying to change the username has the credentials of said user

        if (tempUser != nullUser) {
            this.password = newPassword; //Changes the password to the new one
            System.out.println("Password changed successfully");
        }

        lineReader.close();
    }

    protected void clearAnswers() {
        for (int i = 0; i < User.answersLength; i++) {
            answers[i] = "";
        }
    }
}