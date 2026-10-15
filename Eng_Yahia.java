import java.util.Scanner;
public class Eng_Yahia {
    static Scanner input = new Scanner(System.in);
    static int[] userIds = new int[50];
    static String[] userNames = new String[50];
    static String[] emails = new String[50];
    static String[] phoneNumbers = new String[50];
    static String[] passwords = new String[50];
    static long[] balances = new long[50];
    static boolean[] isBlocked = new boolean[50];
    static int userCount = 5;
    static int currentUserIndex = -1;
    static int[] transactionIds = new int[100];
    static int[] senderIndices = new int[100];
    static int[] receiverIndices = new int[100];
    static long[] amounts = new long[100];
    static String[] transactionStatuses = new String[100];
    static int transactionCount = 0;
    static {
        userIds[0] = 101;
        userNames[0] = "Ahmed";
        emails[0] = "ahmed@gmail.com";
        phoneNumbers[0] = "01011111111";
        passwords[0] = "1234";
        balances[0] = 100000;
        isBlocked[0] = false;
        userIds[1] = 102;
        userNames[1] = "Omar";
        emails[1] = "omar@gmail.com";
        phoneNumbers[1] = "01022222222";
        passwords[1] = "5678";
        balances[1] = 50000;
        isBlocked[1] = false;
        userIds[2] = 103;
        userNames[2] = "Yahia";
        emails[2] = "yahia@gmail.com";
        phoneNumbers[2] = "01033333333";
        passwords[2] = "9012";
        balances[2] = 250000;
        isBlocked[2] = false;
        userIds[3] = 104;
        userNames[3] = "Ali";
        emails[3] = "ali@gmail.com";
        phoneNumbers[3] = "01044444444";
        passwords[3] = "3456";
        balances[3] = 75000;
        isBlocked[3] = false;
        userIds[4] = 105;
        userNames[4] = "Mona";
        emails[4] = "mona@gmail.com";
        phoneNumbers[4] = "01055555555";
        passwords[4] = "7890";
        balances[4] = 120000;
        isBlocked[4] = true;
    }
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== QUICK PAY =====");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = readInt();
            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    System.out.println(
                            "User menu will be connected by the user-services team."
                    );
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);
        input.close();
    }
    public static int readInt() {
        while (!input.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            input.nextLine();
        }
        int number = input.nextInt();
        input.nextLine();
        return number;
    }
    public static void adminMenu() {
        int choice;
        do {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Show Statistics");
            System.out.println("2. Search User");
            System.out.println("3. View All Users");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = readInt();
            switch (choice) {
                case 1:
                    showStatistics();
                    break;
                case 2:
                    searchUser();
                    break;
                case 3:
                    viewAllUsers();
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
    public static void showStatistics() {
        int blockedUsers = 0;
        int activeUsers = 0;
        int successfulTransactions = 0;
        int failedTransactions = 0;
        long totalTransferred = 0;
        for (int i = 0; i < userCount; i++) {
            if (isBlocked[i]) {
                blockedUsers++;
            } else {
                activeUsers++;
            }
        }
        for (int i = 0; i < transactionCount; i++) {
            if ("SUCCESS".equalsIgnoreCase(
                    transactionStatuses[i])) {
                successfulTransactions++;
                totalTransferred += amounts[i];
            } else if ("FAILED".equalsIgnoreCase(
                    transactionStatuses[i])) {
                failedTransactions++;
            }
        }
        System.out.println("\n===== SYSTEM STATISTICS =====");
        System.out.println("Total users: " + userCount);
        System.out.println("Active users: " + activeUsers);
        System.out.println("Blocked users: " + blockedUsers);
        System.out.println(
                "Successful transactions: " + successfulTransactions
        );
        System.out.println(
                "Failed transactions: " + failedTransactions
        );
        System.out.printf(
                "Total transferred: %.2f EGP%n",
                totalTransferred / 100.0
        );
    }
    public static void searchUser() {
        System.out.println("\n===== SEARCH USER =====");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Phone");
        System.out.println("4. Search by Email");
        System.out.print("Choose search method: ");
        int searchType = readInt();
        if (searchType < 1 || searchType > 4) {
            System.out.println("Invalid search option!");
            return;
        }
        System.out.print("Enter search value: ");
        String searchValue = input.nextLine().trim();
        int foundIndex = -1;
        for (int i = 0; i < userCount; i++) {
            boolean matches = false;
            switch (searchType) {
                case 1:
                    matches = String.valueOf(userIds[i])
                            .equals(searchValue);
                    break;
                case 2:
                    matches = userNames[i]
                            .equalsIgnoreCase(searchValue);
                    break;
                case 3:
                    matches = phoneNumbers[i]
                            .equals(searchValue);
                    break;
                case 4:
                    matches = emails[i]
                            .equalsIgnoreCase(searchValue);
                    break;
            }
            if (matches) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1) {
            System.out.println("\nUser found!");
            displayUser(foundIndex);
        } else {
            System.out.println("User not found!");
        }
    }
    public static void viewAllUsers() {
        System.out.println("\n===== ALL USERS =====");
        if (userCount == 0) {
            System.out.println("No users available.");
            return;
        }
        for (int i = 0; i < userCount; i++) {
            System.out.println("\n--------------------");
            displayUser(i);
        }
    }
    public static void displayUser(int index) {
        System.out.println("ID: " + userIds[index]);
        System.out.println("Name: " + userNames[index]);
        System.out.println("Email: " + emails[index]);
        System.out.println("Phone: " + phoneNumbers[index]);
        System.out.printf(
                "Balance: %.2f EGP%n",
                balances[index] / 100.0
        );
        System.out.println(
                "Status: " +
                        (isBlocked[index] ? "Blocked" : "Active")
        );
    }
}