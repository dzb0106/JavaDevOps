// Zhubo Deng
// 03/02/21

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        BankAccountDAO bankAccountDAO = new BankAccountDAO();
        Scanner scanner = new Scanner(System.in);
        boolean exitFlag = false;
        do {
            System.out.println("Options: \n" +
                    "A. Add account \n" +
                    "B. Show account \n" +
                    "C. Update account information \n" +
                    "D. Deposit \n" +
                    "E. Withdraw \n" +
                    "F. Delete account \n" +
                    "G. Exit");
            char option = scanner.nextLine().toUpperCase().toCharArray()[0];
            if (option == 'A') {           // A. Add Account
                System.out.println("Enter your account number: ");
                String account_number = scanner.nextLine();
                System.out.println("Enter your balance: ");
                double balance = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter your name: ");
                String customer_name = scanner.nextLine();
                System.out.println("Enter your email: ");
                String email = scanner.nextLine();
                System.out.println("Enter your phone number: ");
                String phone_number = scanner.nextLine();
                BankAccount bankAccount = new BankAccount(account_number, balance, customer_name, email, phone_number);
                bankAccountDAO.createAccount(bankAccount);
            } else if (option == 'B') {    // B. Show Account
                System.out.println("Options: \n" +
                        "A. Show all accounts \n" +
                        "B. Read account by account number \n" +
                        "C. Read account by customer name \n" +
                        "D. Read account by email \n" +
                        "E. Read account by phone number");
                char read_option = scanner.nextLine().toUpperCase().toCharArray()[0];
                if (read_option == 'A') {
                    bankAccountDAO.readAccount();
                } else if (read_option == 'B') {
                    System.out.println("Enter your account number: ");
                    String account_number = scanner.nextLine();
                    bankAccountDAO.readAccountByAccountNumber(account_number);
                } else if (read_option == 'C') {
                    System.out.println("Enter your name: ");
                    String customer_name = scanner.nextLine();
                    bankAccountDAO.readAccountByCustomerName(customer_name);
                } else if (read_option == 'D') {
                    System.out.println("Enter your email: ");
                    String email = scanner.nextLine();
                    bankAccountDAO.readAccountByEmail(email);
                } else if (read_option == 'E') {
                    System.out.println("Enter your phone number: ");
                    String phone_number = scanner.nextLine();
                    bankAccountDAO.readAccountByPhoneNumber(phone_number);
                }
            } else if (option == 'C') {    // C. Update Account Information
                System.out.println("Options: \n" +
                        "A. Update customer name \n" +
                        "B. Update email \n" +
                        "C. Update phone number");
                char update_option = scanner.nextLine().toUpperCase().toCharArray()[0];
                if (update_option == 'A') {             // A. Update customer name
                    System.out.println("Enter your account number: ");
                    String account_number = scanner.nextLine();
                    System.out.println("Enter the new name you want to update: ");
                    String customer_name = scanner.nextLine();
                    bankAccountDAO.updateAccountCustomerName(account_number, customer_name);
                } else if (update_option == 'B') {      // B. Update email
                    System.out.println("Enter your account number: ");
                    String account_number = scanner.nextLine();
                    System.out.println("Enter the new email you want to update: ");
                    String email = scanner.nextLine();
                    bankAccountDAO.updateAccountEmail(account_number, email);
                } else if (update_option == 'C') {      // C. Update phone number
                    System.out.println("Enter your account number: ");
                    String account_number = scanner.nextLine();
                    System.out.println("Enter the new phone number you want to update: ");
                    String phone_number = scanner.nextLine();
                    bankAccountDAO.updateAccountPhoneNumber(account_number, phone_number);
                }
            } else if (option == 'D') {    // D. Deposit
                System.out.println("Options: \n" +
                        "A. Deposit by account number \n" +
                        "B. Deposit by name");
                char deposit_option = scanner.nextLine().toUpperCase().toCharArray()[0];
                if (deposit_option == 'A') {
                    System.out.println("Enter the account number you want to deposit: ");
                    String account_number = scanner.nextLine();
                    System.out.println("Enter the amount you want to deposit: ");
                    double deposit = Double.parseDouble(scanner.nextLine());
                    bankAccountDAO.depositByAccountNumber(account_number, deposit);
                } else if (deposit_option == 'B') {
                    System.out.println("Enter the customer name you want to deposit: ");
                    String customer_name = scanner.nextLine();
                    System.out.println("Enter the amount you want to deposit: ");
                    double deposit = Double.parseDouble(scanner.nextLine());
                    bankAccountDAO.depositByCustomerName(customer_name, deposit);
                }
            } else if (option == 'E') {    // E. Withdraw
                System.out.println("Options: \n" +
                        "A. Withdraw by account number \n" +
                        "B. Withdraw by name");
                char withdraw_option = scanner.nextLine().toUpperCase().toCharArray()[0];
                if (withdraw_option == 'A') {
                    System.out.println("Enter the account number you want to withdraw: ");
                    String account_number = scanner.nextLine();
                    System.out.println("Enter the amount you want to withdraw: ");
                    double withdraw = Double.parseDouble(scanner.nextLine());
                    bankAccountDAO.withdrawByAccountNumber(account_number, withdraw);
                } else if (withdraw_option == 'B') {
                    System.out.println("Enter the customer name you want to withdraw: ");
                    String customer_name = scanner.nextLine();
                    System.out.println("Enter the amount you want to withdraw: ");
                    double withdraw = Double.parseDouble(scanner.nextLine());
                    bankAccountDAO.withdrawByCustomerName(customer_name, withdraw);
                }
            } else if (option == 'F') {    // F. Delete Account
                System.out.println("Options: \n" +
                        "A. Delete by account number \n" +
                        "B. Delete by name");
                char delete_option = scanner.nextLine().toUpperCase().toCharArray()[0];
                if (delete_option == 'A') {
                    System.out.println("Enter the account number you want to delete: ");
                    String account_number = scanner.nextLine();
                    bankAccountDAO.deleteAccountByAccountNumber(account_number);
                } else if (delete_option == 'B') {
                    System.out.println("Enter the customer name you want to delete: ");
                    String customer_name = scanner.nextLine();
                    bankAccountDAO.deleteAccountByCustomerName(customer_name);
                }
            } else if (option == 'G') {    // G. Exit
                exitFlag = true;
            }
        } while (exitFlag != true);
    }
}


