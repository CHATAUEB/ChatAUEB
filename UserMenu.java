import java.util.Scanner;

public class UserMenu {

    static Scanner scanner = new Scanner(System.in);
    
    public static void menu() {

        while (true) {
            System.out.println("Welcome to ChatAUEB.\n If you wish to sign up press 1.\n If you are already registered press 2.\n If you want to change password press 3.\n If you want to Exit press 4.\n");
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
                    System.out.println("Thank you for using ChatAueb. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    continue;
            }
        }
    }

    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = User.connect(username, password);
    }

    private static void signUpUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        new User(username, password);
    }

    private static void changePassword() {
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
