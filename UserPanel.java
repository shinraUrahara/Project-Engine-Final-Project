import java.util.Scanner;

public class UserPanel {

    // ارايز لليوزر
    static String[] phones = new String[100];
    static String[] passwords = new String[100];
    static String[] names = new String[100];
    static int[] userIds = new int[100];
    static long[] balances = new long[100];
    static boolean[] statuses = new boolean[100];

    // اراي للسؤال عن الفاكهة في حالة نسيان الباسوورد
    static String[] securityAnswers = new String[100];

    // ارايز للحصالة
    static long[] vaultBalances = new long[100];

    static int userCount = 0;

    // ارايز لتسجيل المعاملات
    static int[] transIds = new int[100];
    static int[] transSenders = new int[100];
    static int[] transReceivers = new int[100];
    static long[] transAmounts = new long[100];
    static String[] transStatuses = new String[100];
    static String[] transTypes = new String[100];
    static String[] transNotes = new String[100];
    static int transCount = 0;

    static int[][] favorites = new int[100][5];
    static int[] favCounts = new int[100];

    static int loggedInUserIndex = -1;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean systemRunning = true;

        while (systemRunning) {
            System.out.println("\n========== QUICK PAY ==========");
            System.out.println("1. Register Account");
            System.out.println("2. Login");
            System.out.println("3. Exit Application");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Closing application. Goodbye!");
                    systemRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            if (systemRunning && choice != 3 && loggedInUserIndex == -1) {
                System.out.println("\nPress 1 to return to Main Menu, or 2 to Exit.");
                int nav = input.nextInt();
                if (nav == 2) {
                    systemRunning = false;
                }
            }
        }
    }

    public static void registerUser() {
        System.out.print("Enter your phone number (11 digits): ");
        String phoneInput = input.nextLine();

        // خلي اليوزر يدخل 11 رقم مش اكتر ولا اقل
        while (phoneInput.length() != 11) {
            System.out.print("Invalid! Phone number must be exactly 11 digits. Try again: ");
            phoneInput = input.nextLine();
        }

        // تأكد من ان الرقم مش متسجل
        for (int i = 0; i < userCount; i++) {
            if (phones[i].equals(phoneInput)) {
                System.out.println("This number is already registered.");
                return;
            }
        }

        System.out.print("Enter a password: ");
        String passInput = input.nextLine();
        System.out.print("Enter your full name: ");
        String nameInput = input.nextLine();

        System.out.print("Security Question: What is your favourite fruit? ");
        String fruitInput = input.nextLine();

        phones[userCount] = phoneInput;
        passwords[userCount] = passInput;
        names[userCount] = nameInput;
        securityAnswers[userCount] = fruitInput;

        userIds[userCount] = userCount + 1;

        // مبلغ مبدأي 5000 جنيه او خمسمية الف قرش
        balances[userCount] = 500000;
        vaultBalances[userCount] = 0;
        statuses[userCount] = true;

        System.out.printf("Registered successfully! Your ID is %03d\n", userIds[userCount]);
        userCount++;
    }

    public static void loginUser() {
        System.out.print("Enter phone number: ");
        String phoneInput = input.nextLine();
        System.out.print("Enter password: ");
        String passInput = input.nextLine();

        int foundIndex = -1;
        for (int i = 0; i < userCount; i++) {
            if (phones[i].equals(phoneInput)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            System.out.println("Phone number not found.");
            return;
        }

        if (passwords[foundIndex].equals(passInput)) {
            if (statuses[foundIndex] == false) {
                System.out.println("Account blocked.");
                return;
            }
            loggedInUserIndex = foundIndex;
            System.out.println("Welcome, " + names[foundIndex] + "!");
            userMenu();
        } else {
            System.out.println("Wrong password.");
            System.out.println("Press 1 to return to menu, or 2 if you forgot your password.");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 2) {
                forgotPassword(foundIndex);
            }
        }
    }

    // في حالة نسيان الباسوورد
    public static void forgotPassword(int userIndex) {
        System.out.println("\n--- Password Reset ---");
        System.out.print("Security Question: What is your favourite fruit? ");
        String answerInput = input.nextLine();

        if (securityAnswers[userIndex].equalsIgnoreCase(answerInput)) {
            System.out.print("Correct! Enter your new password: ");
            String newPassword = input.nextLine();
            passwords[userIndex] = newPassword;
            System.out.println("Password reset successfully! You can now log in.");
        } else {
            System.out.println("Wrong answer. Password reset failed.");
        }
    }

    public static void userMenu() {
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\n===== USER PANEL ==========");
            System.out.println("1. Show Balance");
            System.out.println("2. Transfer Money");
            System.out.println("3. Transaction History");
            System.out.println("4. Show Favorites");
            System.out.println("5. Add Favorite");
            System.out.println("6. Remove Favorite");
            System.out.println("7. Search Recipient");
            System.out.println("8. View Profile");
            System.out.println("9. Update Profile");
            System.out.println("10. Request Money");
            System.out.println("11. Split Bill");
            System.out.println("12. Savings Vault");
            System.out.println("13. Logout");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine();
        }
    }
}