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
//labels se kathe methodo na mhn einai null o builder
//Barprogress sthn run na kn assert an otnws exei kleisei dld einai false
//querybuilder oti exw balei se mia nea methodo sto UnitTest kai telos na ejasfalisw oti sto message uparxei oti xhteite opws se ena panepistomio uparxoun... dwse apantisi... 
//sthn user kataskeuasti kanw test gia contains
