// Zhubo Deng
// 03/02/21

public class BankAccount {
    private String account_number;
    private double balance;
    private String customer_name;
    private String email;
    private String phone_number;

    public BankAccount() {

    }

    public BankAccount(String account_name, String customer_name, String email, String phone_number) {
        this.account_number = account_name;
        this.balance = 0.0;
        this.customer_name = customer_name;
        this.email = email;
        this.phone_number = phone_number;
    }

    public BankAccount(String account_name, double balance, String customer_name, String email, String phone_number) {
        this.account_number = account_name;
        this.balance = balance;
        this.customer_name = customer_name;
        this.email = email;
        this.phone_number = phone_number;
    }

    public void depositFunds(double deposit) {
        balance += deposit;
    }

    public void withdrawFunds(double withdraw) {
        if (withdraw > balance) {
            System.out.println("Insufficient Funds!");
            System.out.println(customer_name + " has " + balance + " in this bank account.");
        } else {
            balance -= withdraw;
        }
    }

    public void printInfo() {
        System.out.println("Customer Name: " + customer_name);
        System.out.println("Account Number: " + account_number);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phone_number);
    }

    public String getAccountNumber() {
        return account_number;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customer_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setCustomerName(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }
}


