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
import java.util.Scanner;

public class UserMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the User Menu!");
            System.out.println("1. Log In");
            System.out.println("2. Sign Up");
            System.out.println("3. Change Password");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loginUser();
                    break;
                case 2:
                    signUpUser();
                    break;
                case 3:
                    changePassword();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static void loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = User.connect(username, password);

        if (user != User.nullUser) {
            System.out.println("Login successful! Welcome, " + user.username);
            // You can add more options or actions for a logged-in user here
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }

    private static void signUpUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        new User(username, password);
        // You might want to add more actions after successful signup
    }

    private static void changePassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter current password: ");
        String password = scanner.nextLine();

        User user = User.connect(username, password);

        if (user != User.nullUser) {
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            user.SetPassword(newPassword);
        } else {
            System.out.println("Change password failed. Invalid username or password.");
        }
    }
}
