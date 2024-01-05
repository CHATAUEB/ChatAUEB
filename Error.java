import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Error {
    private String errorName;
    private String errorMessage;

    public Error(String errorName, String errorMessage) {
        this.errorName = errorName;
        this.errorMessage = errorMessage;
    }

    public static void displayError(Error error, JFrame frame) {
        JOptionPane.showMessageDialog(frame, error.errorMessage, error.errorName, JOptionPane.ERROR_MESSAGE);
    }

    static Error invalidCredentials = new Error("Invalid Credentials", "You have not entered valid credentials. Please try again");
    static Error usernameTaken = new Error("Username Taken", "The username you have entered is taken. Please try again");
    static Error usernameDoesNotExist = new Error("Username Does Not Exist", "The username you have entered does not exist. Please try again");
    static Error wrongPassword = new Error("Wrong Password", "The password you have entered is not correct. Please try again");
}
//kataskeuasis ERROR gia unit testing an ola ta antikeimena exoun k ta 2 arg
//run methodos sthn Message na mhn einai null
