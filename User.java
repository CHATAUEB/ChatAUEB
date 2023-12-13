import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class User{
    private final int y = 30; //array size depending on questionnaire size, 30 for testing

    protected String username;
    
    private String password;
    
    private String[] answers = new String[y];
    
    protected static ArrayList<User> UserList = new ArrayList<User>(); //list containing all created users

    static User nullUser = new User(null, null); //null User used to show that the connection failed

    //A constructor for users with a username and a password.
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        UserList.add(this);
    }

    public static User signUp(String username, String password) {
        User returnUser;
        if (username != null && password != null) {    
            boolean flag = true; // metavliti alithiac emfanisis username
            if (UserList.size() > 1) {
                for(User i : UserList) {
                    if (i.username != null) {
                        if (i.username.equals(username)) { //checking if the username is taken
                            flag = false; //changes the flag to false to show that the username is taken
                            System.out.println("This username is already taken!!!");
                        }
                    }
                }
            }   
            if (flag) {
                returnUser = new User(username, password);
                System.out.print("Registration successful! Welcome " + username + "\n");
                return returnUser;
            } else {
                System.out.println("Registration failed: username already taken");
                return nullUser; 
            }       
        } else {
            return nullUser;
        }
    }


    //A method used to connect into one of the users in the userList, if the connection is successful it returns the user with the given credentials, if not it returns the nullUser in line 11
    public static User logIn(String username, String password) {
        
        User returnUser = nullUser; //the User object to be returned by the method
        if (username != null && password != null) {     
            for (User i  : UserList) {
                if (i.username != null) {
                    if (i.username.equals(username)) { //checking if the username exists
                        if (i.password.equals(password)) { //If the username does exist, checking the password
                            System.out.println("Succesful connection! Welcome " + username);
                            returnUser = i; //Returns the User object
                            break; 
                        } else {
                            System.out.println("Wrong password, please try again");
                            returnUser = nullUser; //Returns the null User, showing that the connection failed
                        }
                    } 
                }
            }
            return returnUser;
        } else {
            return nullUser;
        }
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
}