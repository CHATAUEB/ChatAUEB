import java.util.scanner;
public class Main {
    public static void main(String args[]) {
        Scanner readAns = new Scanner(System.in);
        int ans;
        while (true) {
            System.Out.Println("welcome to chat aueb. if u wish to sign up press 1. If u are already registered press 2")
            readAns = read.nextInt();
            if (ans == 1) {
                System.out.println("Please insert your username");
                String username = read.nextLine();
                System.out.println("Please insert your password");
                String password = read.nextLine();
                User(username, password);
                break;
            } else if (ans == 2) {
                System.out.println("Please enter your username:");
                String username = loginScanner.nextLine();

                System.out.println("Please enter your password:");
                String password = loginScanner.nextLine();

                User loggedInUser = User.connect(username, password);
                break;
            }
        }
        readAns.close();
        Scanner read = new Scanner(System.in);

      
    }
}
