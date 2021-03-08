// Zhubo Deng
// 03/02/21

import java.util.ArrayList;

public class BankAccountDAO {
    ArrayList<BankAccount> baList = new ArrayList<>();

    public void createAccount(BankAccount bankAccount) {
        baList.add(bankAccount);
    }

    // read all the Accounts
    public void readAccount() {
        for (BankAccount bankAccount : baList) {
            System.out.println("Account Number: " + bankAccount.getAccountNumber());
            System.out.println("Balance: " + bankAccount.getBalance());
            System.out.println("Customer Name: " + bankAccount.getCustomerName());
            System.out.println("Email: " + bankAccount.getEmail());
            System.out.println("Phone Number: " + bankAccount.getPhoneNumber());
            System.out.println("**************************");
        }
    }

    // read Account By its Account Number
    public void readAccountByAccountNumber(String account_number) {
        for (BankAccount bankAccount : baList) {
            if (bankAccount.getAccountNumber().equals(account_number)) {
                System.out.println("Account Number: " + bankAccount.getAccountNumber());
                System.out.println("Balance: " + bankAccount.getBalance());
                System.out.println("Customer Name: " + bankAccount.getCustomerName());
                System.out.println("Email: " + bankAccount.getEmail());
                System.out.println("Phone Number: " + bankAccount.getPhoneNumber());
                System.out.println("**************************");
            }
        }
    }

    // read Account By its Customer Name
    public void readAccountByCustomerName(String customer_name) {
        for (BankAccount bankAccount : baList) {
            if (bankAccount.getCustomerName().equals(customer_name)) {
                System.out.println("Account Number: " + bankAccount.getAccountNumber());
                System.out.println("Balance: " + bankAccount.getBalance());
                System.out.println("Customer Name: " + bankAccount.getCustomerName());
                System.out.println("Email: " + bankAccount.getEmail());
                System.out.println("Phone Number: " + bankAccount.getPhoneNumber());
                System.out.println("**************************");
            }
        }
    }

    // read Account By its Email
    public void readAccountByEmail(String email) {
        for (BankAccount bankAccount : baList) {
            if (bankAccount.getEmail().equals(email)) {
                System.out.println("Account Number: " + bankAccount.getAccountNumber());
                System.out.println("Balance: " + bankAccount.getBalance());
                System.out.println("Customer Name: " + bankAccount.getCustomerName());
                System.out.println("Email: " + bankAccount.getEmail());
                System.out.println("Phone Number: " + bankAccount.getPhoneNumber());
                System.out.println("**************************");
            }
        }
    }

    // read Account By its Phone Number
    public void readAccountByPhoneNumber(String phone_number) {
        for (BankAccount bankAccount : baList) {
            if (bankAccount.getPhoneNumber().equals(phone_number)) {
                System.out.println("Account Number: " + bankAccount.getAccountNumber());
                System.out.println("Balance: " + bankAccount.getBalance());
                System.out.println("Customer Name: " + bankAccount.getCustomerName());
                System.out.println("Email: " + bankAccount.getEmail());
                System.out.println("Phone Number: " + bankAccount.getPhoneNumber());
                System.out.println("**************************");
            }
        }
    }

    // update Account Customer Name
    public void updateAccountCustomerName(String account_number, String customer_name) {
        for (BankAccount bankAccount : baList) {
            if (bankAccount.getAccountNumber().equals(account_number)) {
                bankAccount.setCustomerName(customer_name);
            }
        }
    }

    // update Account Email
    public void updateAccountEmail(String account_number, String email) {
        for (BankAccount bankAccount : baList) {
            if (bankAccount.getAccountNumber().equals(account_number)) {
                bankAccount.setEmail(email);
            }
        }
    }

    // update Account Phone Number
    public void updateAccountPhoneNumber(String account_number, String phone_number) {
        for (BankAccount bankAccount : baList) {
            if (bankAccount.getAccountNumber().equals(account_number)) {
                bankAccount.setPhoneNumber(phone_number);
            }
        }
    }

    // deposit By Account Number
    public void depositByAccountNumber(String account_number, double deposit) {
        for (BankAccount bankAccount : baList) {
            if (bankAccount.getAccountNumber().equals(account_number)) {
                bankAccount.depositFunds(deposit);
            }
        }
    }

    // deposit By Customer Name
    public void depositByCustomerName(String customer_name, double deposit) {
        for (BankAccount bankAccount : baList) {
            if (bankAccount.getCustomerName().equals(customer_name)) {
                bankAccount.depositFunds(deposit);
            }
        }
    }

    // withdraw By Account Number
    public void withdrawByAccountNumber(String account_number, double withdraw) {
        for (BankAccount bankAccount : baList) {
            if (bankAccount.getAccountNumber().equals(account_number)) {
                bankAccount.withdrawFunds(withdraw);
            }
        }
    }

    // withdraw By Customer Name
    public void withdrawByCustomerName(String customer_name, double withdraw) {
        for (BankAccount bankAccount : baList) {
            if (bankAccount.getCustomerName().equals(customer_name)) {
                bankAccount.withdrawFunds(withdraw);
            }
        }
    }

    // delete Account By Account Number
    public void deleteAccountByAccountNumber(String account_number) {
        BankAccount bankAccountToRemove = null;
        for (BankAccount bankAccount : baList) {
            if (bankAccount.getAccountNumber().equals(account_number)) {
                bankAccountToRemove = bankAccount;
            }
        }
        if (bankAccountToRemove == null) {
            System.out.println("No account to delete!");
            return;
        }
        baList.remove(bankAccountToRemove);
    }

    // delete Account By Customer Name
    public void deleteAccountByCustomerName(String customer_name) {
        BankAccount bankAccountToRemove = null;
        for (BankAccount bankAccount : baList) {
            if (bankAccount.getCustomerName().equals(customer_name)) {
                bankAccountToRemove = bankAccount;
            }
        }
        if (bankAccountToRemove == null) {
            System.out.println("No account to delete!");
            return;
        }
        baList.remove(bankAccountToRemove);
    }
}


