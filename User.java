import java.util.LinkedList;
import java.util.Scanner;

public class User{
    private final int y = 30; //array size depending on questionnaire size, 30 for testing
    private String username;
    private String password;
    private Answers[] answers = new Answers[y];
    private static LinkedList<User> UserList = new LinkedList(); //list containing all created users

    static User nullUser = new User(null, null); //null User used to show that the connection failed

    //A constructor for users with a username and a password. It checks if the username you added already exists and creates a new User object if the username is unique
    public User(String username , String password) {   

        boolean flag = true; // metqavliti alithiac emfanisis username
        
        for(User i : UserList) {
            if (i.username.equals(username)) { //checking if the username is taken
                flag = false; //changes the flag to false to show that the username is taken
                System.out.println("this username is already taken!!!");
            }
        }
            if (flag) {
                this.username = username; //creation of the object User with the given username and password
                this.password = password; 
                UserList.add(this); //Addition to the list of Users for later reference
                System.out.println("registration successfull!!! Welcome " + this.username);
            } else { 
                System.out.println("Registration failed: Username already taken");
            }       
    }

    //A method used to connect into one of the users in the userList, if the connection is successful it returns the user with the given credentials, if not it returns the nullUser in line 11
    public static User connect(String username, String password) {
        
        User returnUser = nullUser; //the User object to be returned by the method
        
        for (User i  : UserList) {
            if (i.username.equals(username)) { //checking if the username exists
                if (i.password.equals(password)) { //If the username does exist, checking the password
                    System.out.println("Succesful connection");
                    returnUser = i; //Returns the User object 
                } else {
                    System.out.println("Wrong password, please try again");
                    returnUser = nullUser; //Returns the null User, showing that the connection failed
                }
            } else {
                System.out.println("The username does not exist");
                returnUser = nullUser; //Returns the null User, showing that the connection failed
            }
        }
        return returnUser;
    }

    //Method used to add an answer from the questionnaire to the answer array
    protected void insertAnswer(int i, String answer) {
        this.answers[i] = answer;
    }

    //Method used to delete an answer from the questionnaire to the answer array
    protected void deleteAnswer(int i) {
        this.answers[i] = null;
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

        User tempUser = connect(tempUsername, tempPassword); //Using the connect method in order to check that the person trying to change the username has the credentials of said user

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

        User tempUser = connect(tempUsername, tempPassword); //Using the connect method in order to check that the person trying to change the username has the credentials of said user

        if (tempUser != nullUser) {
            this.password = newPassword; //Changes the password to the new one
            System.out.println("Password changed successfully");
        }

        lineReader.close();
    }
}
