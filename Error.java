import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
*A class used to show different error messages during the registration process
*/

public class Error {
    private String errorName;
    private String errorMessage;

    /**
    *Error constructor used to create static objects for later reference
    *@param errorName the name of an Error object
    *@param errorMessage the message the Error object displays
    */
    
    public Error(String errorName, String errorMessage) {
        this.errorName = errorName;
        this.errorMessage = errorMessage;
    }

    /**
    *Displays a message signifiying that an error has occured during the registration process
    *<p>
    *This method utilizes JOptionPane in order to display the error message
    *@param error the Error object related to the error that has occured
    *@param frame the JFrame which called this method
    *@see JOptionPane
    */
    
    public static void displayError(Error error, JFrame frame) {
        JOptionPane.showMessageDialog(frame, error.errorMessage, error.errorName, JOptionPane.ERROR_MESSAGE);
    }

    static Error invalidCredentials = new Error("Invalid Credentials", "You have not entered valid credentials. Please try again");
    static Error usernameTaken = new Error("Username Taken", "The username you have entered is taken. Please try again");
    static Error usernameDoesNotExist = new Error("Username Does Not Exist", "The username you have entered does not exist. Please try again");
    static Error wrongPassword = new Error("Wrong Password", "The password you have entered is not correct. Please try again");
}
