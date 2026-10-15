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

            switch (choice) {
                case 1: showBalance(); break;
                case 2: transferMoney(); break;
                case 3: showTransactionHistory(); break;
                case 4: showFavorites(); break;
                case 5: addFavorite(); break;
                case 6: removeFavorite(); break;
                case 7: searchRecipient(); break;
                case 8: viewProfile(); break;
                case 9: updateProfile(); break;
                case 10: requestMoney(); break;
                case 11: splitBill(); break;
                case 12: manageVault(); break;
                case 13:
                    loggedInUserIndex = -1;
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            if (keepRunning) {
                System.out.println("\nPress 1 to return to User Menu, or 2 to Exit Application.");
                int nav = input.nextInt();
                input.nextLine();
                if (nav == 2) {
                    System.out.println("Closing application. Goodbye!");
                    System.exit(0);
                }
            }
        }
    }

    public static void showBalance() {
        double balanceInEGP = balances[loggedInUserIndex] / 100.0;
        System.out.println("Main Balance: " + balanceInEGP + " EGP");
    }

    public static void manageVault() {
        System.out.println("\n--- Savings Vault ---");
        double mainEGP = balances[loggedInUserIndex] / 100.0;
        double vaultEGP = vaultBalances[loggedInUserIndex] / 100.0;

        System.out.println("Main Balance: " + mainEGP + " EGP");
        System.out.println("Vault Balance: " + vaultEGP + " EGP");
        System.out.println("1. Deposit to Vault");
        System.out.println("2. Withdraw from Vault");
        System.out.print("Choose option: ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            System.out.print("Enter amount to deposit into Vault: ");
            double amountEGP = input.nextDouble();
            input.nextLine();
            long amountPiasters = (long) (amountEGP * 100);

            if (amountPiasters > 0 && balances[loggedInUserIndex] >= amountPiasters) {
                balances[loggedInUserIndex] -= amountPiasters;
                vaultBalances[loggedInUserIndex] += amountPiasters;
                System.out.println("Money moved to Vault successfully!");
                recordTransaction(loggedInUserIndex, loggedInUserIndex, amountPiasters, "SUCCESS", "VAULT_IN", "Deposit to Vault");
            } else {
                System.out.println("Invalid amount or not enough main balance.");
            }
        } else if (choice == 2) {
            System.out.print("Enter amount to withdraw to Main Balance: ");
            double amountEGP = input.nextDouble();
            input.nextLine();
            long amountPiasters = (long) (amountEGP * 100);

            if (amountPiasters > 0 && vaultBalances[loggedInUserIndex] >= amountPiasters) {
                vaultBalances[loggedInUserIndex] -= amountPiasters;
                balances[loggedInUserIndex] += amountPiasters;
                System.out.println("Money returned to Main Balance successfully!");
                recordTransaction(loggedInUserIndex, loggedInUserIndex, amountPiasters, "SUCCESS", "VAULT_OUT", "Withdraw from Vault");
            } else {
                System.out.println("Invalid amount or not enough vault balance.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void transferMoney() {
        System.out.print("Enter recipient phone number: ");
        String targetPhone = input.nextLine();

        int recipientIndex = -1;
        for (int i = 0; i < userCount; i++) {
            if (phones[i].equals(targetPhone)) {
                recipientIndex = i;
                break;
            }
        }

        if (recipientIndex == -1) {
            System.out.println("User not found.");
            return;
        }

        if (recipientIndex == loggedInUserIndex) {
            System.out.println("Cannot transfer to yourself.");
            return;
        }

        if (statuses[recipientIndex] == false) {
            System.out.println("Recipient account is blocked.");
            return;
        }

        System.out.print("Enter amount in EGP: ");
        double amountEGP = input.nextDouble();
        input.nextLine();
        long amountPiastres = (long) (amountEGP * 100);

        if (amountPiastres <= 0) {
            System.out.println("Amount must be more than zero.");
            return;
        }

        if (balances[loggedInUserIndex] < amountPiastres) {
            System.out.println("Not enough money in Main Balance.");
            return;
        }

        System.out.print("Enter a note (Optional): ");
        String note = input.nextLine();

        balances[loggedInUserIndex] -= amountPiastres;
        balances[recipientIndex] += amountPiastres;
        System.out.println("Transfer successful!");

        recordTransaction(loggedInUserIndex, recipientIndex, amountPiastres, "SUCCESS", "TRANSFER", note);
    }

    public static void requestMoney() {
        System.out.print("Enter phone number to request money from: ");
        String targetPhone = input.nextLine();

        int targetIndex = -1;
        for (int i = 0; i < userCount; i++) {
            if (phones[i].equals(targetPhone)) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter amount to request in EGP: ");
        double amountEGP = input.nextDouble();
        input.nextLine();
        long amountPiastres = (long) (amountEGP * 100);

        System.out.print("What is this request for? ");
        String note = input.nextLine();

        recordTransaction(targetIndex, loggedInUserIndex, amountPiastres, "PENDING", "REQUEST", note);
        System.out.println("Request sent!");
    }

    public static void splitBill() {
        System.out.print("Enter total bill in EGP: ");
        double totalEGP = input.nextDouble();
        System.out.print("How many people are sharing (including you)? ");
        int peopleCount = input.nextInt();
        input.nextLine();

        if (peopleCount < 2) {
            System.out.println("Need at least 2 people.");
        }

        double splitAmount = totalEGP / peopleCount;
        System.out.println("Each person owes: " + splitAmount + " EGP.");

        for (int i = 0; i < peopleCount - 1; i++) {
            System.out.print("Enter phone for person " + (i + 1) + ": ");
            String targetPhone = input.nextLine();

            int targetIndex = -1;
            for (int j = 0; j < userCount; j++) {
                if (phones[j].equals(targetPhone)) {
                    targetIndex = j;
                    break;
                }
            }
            if (targetIndex != -1) {
                long amountPiastres = (long) (splitAmount * 100);
                recordTransaction(targetIndex, loggedInUserIndex, amountPiastres, "PENDING", "SPLIT", "Bill Share");
                System.out.println("Split request sent to " + names[targetIndex]);
            } else {
                System.out.println("User not found. Skipping.");
            }
        }
    }

    public static void recordTransaction(int sender, int receiver, long amount, String status, String type, String note) {
        transIds[transCount] = transCount + 1;
        transSenders[transCount] = sender;
        transReceivers[transCount] = receiver;
        transAmounts[transCount] = amount;
        transStatuses[transCount] = status;
        transTypes[transCount] = type;
        transNotes[transCount] = note;
        transCount++;
    }

    public static void showTransactionHistory() {
        System.out.println("--- History ---");
        for (int i = 0; i < transCount; i++) {
            if (transSenders[i] == loggedInUserIndex || transReceivers[i] == loggedInUserIndex) {
                String role = "";
                if (transSenders[i] == loggedInUserIndex) {
                    role = "To: " + names[transReceivers[i]];
                } else {
                    role = "From: " + names[transSenders[i]];
                }

                if (transTypes[i].equals("VAULT_IN") || transTypes[i].equals("VAULT_OUT")) {
                    role = "Self Transfer";
                }

                double amtEGP = transAmounts[i] / 100.0;
                System.out.println("[" + transTypes[i] + "] " + role + " | " + amtEGP + " EGP | " + transStatuses[i] + " | " + transNotes[i]);
            }
        }
    }

    public static void showFavorites() {
        int count = favCounts[loggedInUserIndex];
        if (count == 0) {
            System.out.println("No favorites yet.");
            return;
        }
        for (int i = 0; i < count; i++) {
            int favIndex = favorites[loggedInUserIndex][i];
            System.out.println((i+1) + ". " + names[favIndex] + " (" + phones[favIndex] + ")");
        }
    }

    public static void addFavorite() {
        System.out.print("Enter phone to add: ");
        String targetPhone = input.nextLine();

        int foundIndex = -1;
        for (int i = 0; i < userCount; i++) {
            if (phones[i].equals(targetPhone)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1 || foundIndex == loggedInUserIndex) {
            System.out.println("Invalid user.");
            return;
        }

        int currentFavs = favCounts[loggedInUserIndex];
        for (int i = 0; i < currentFavs; i++) {
            if (favorites[loggedInUserIndex][i] == foundIndex) {
                System.out.println("Already in favorites.");
                return;
            }
        }

        if (currentFavs < 5) {
            favorites[loggedInUserIndex][currentFavs] = foundIndex;
            favCounts[loggedInUserIndex]++;
            System.out.println("Added!");
        } else {
            System.out.println("List is full.");
        }
    }

    public static void removeFavorite() {
        showFavorites();
        if (favCounts[loggedInUserIndex] == 0) return;

        System.out.print("Enter number to remove: ");
        int num = input.nextInt();
        input.nextLine();

        if (num > 0 && num <= favCounts[loggedInUserIndex]) {
            int removeIndex = num - 1;
            for (int i = removeIndex; i < favCounts[loggedInUserIndex] - 1; i++) {
                favorites[loggedInUserIndex][i] = favorites[loggedInUserIndex][i + 1];
            }
            favCounts[loggedInUserIndex]--;
            System.out.println("Removed.");
        }
    }

    public static void searchRecipient() {
        System.out.print("Enter phone: ");
        String targetPhone = input.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (phones[i].equals(targetPhone)) {
                System.out.println("Found: " + names[i]);
                return;
            }
        }
        System.out.println("Not found.");
    }

    public static void viewProfile() {
        System.out.println("Name: " + names[loggedInUserIndex]);
        System.out.println("Phone: " + phones[loggedInUserIndex]);
        System.out.printf("ID: %03d\n", userIds[loggedInUserIndex]);
    }

    public static void updateProfile() {
        System.out.print("Enter new name: ");
        String newName = input.nextLine();
        if (!newName.isEmpty()) {
            names[loggedInUserIndex] = newName;
            System.out.println("Updated.");
        }
    }
}