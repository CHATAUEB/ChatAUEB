//Gia na leitoyrgisei h User me thn UserMenu theloyn na einai sto idio paketo

import java.util.Scanner;

public class UserMenu {

    static Scanner scanner = new Scanner(System.in);
    
    public static void menu() {

        while (true) {
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
                    System.out.println("Thank you for using ChatAueb. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    continue;
            }
        }
    }

    private static void loginUser() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
      

        User user = User.logIn(username, password);
    }

    private static void signUpUser() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        User user = new User(username, password);
    }

    private static void changePassword() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter current password: ");
        String password = scanner.nextLine();

        User user = User.logIn(username, password);

        if (user != User.nullUser) {
            System.out.println("Enter new password: ");
            String newPassword = scanner.nextLine();
            user.SetPassword(newPassword);
        } else {
            System.out.println("Change password failed. Invalid username or password.");
        }
    }
    public static void main(String[] args) {
        menu();


    }
}
