//User και UserMenu πρεπει να ειναι στο ιδιο package

import java.util.Scanner;

public class UserMenu {

    static Scanner scanner = new Scanner(System.in);
    
    // Main menu functionality
    public static void menu() {

        while (true) {
            // Displaying menu options
            System.out.println("Welcome to ChatAUEB.\nIf you wish to sign up press 1.\nIf you are already registered press 2.\nIf you want to change password press 3.\nIf you want to Exit press 4.\n");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    signUpUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    changePassword();
                    break;
                case 4:
                    // Exiting the program
                    System.out.println("Thank you for using ChatAueb. Goodbye!");
                    System.exit(0);
                default:
                    // Invalid option handling
                    System.out.println("Invalid option. Please choose a valid option.");
                    continue;
            }
        }
    }

    // Method for handling user login
    private static void loginUser() {
        // Collecting user input for username and password
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        scanner.nextLine(); // Consuming the newline character
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
      
        // Attempting to log in the user
        User user = User.logIn(username, password);
    }

    // Method for handling user sign-up
    private static void signUpUser() {
        // Collecting user input for username and password
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        scanner.nextLine(); // Consuming the newline character
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        // Attempting to sign up the user
        User user = User.signUp(username, password);
    }

    // Method for handling password change
    private static void changePassword() {
        // Collecting user input for username and current password
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter current password: ");
        String password = scanner.nextLine();

        // Attempting to log in the user for password change
        User user = User.logIn(username, password);

        if (user != User.nullUser) {
            // Collecting new password and changing it
            System.out.println("Enter new password: ");
            String newPassword = scanner.nextLine();
            user.SetPassword(newPassword);
        } else {
            // Displaying a message for failed password change
            System.out.println("Change password failed. Invalid username or password.");
        }
    }

    // Main method to start the program
    public static void main(String[] args) {
        menu();
    }
}
