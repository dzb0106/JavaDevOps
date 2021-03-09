package com.bankAccountAPIs.bankAccountAPIs;

// Zhubo Deng
// 03/02/21

// to do @RequestBody
// !!! must have all getter & setter ready
// !!! var name must be the same as the function name

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount() {

    }

    public BankAccount(String account_name, String customer_name, String email, String phone_number) {
        this.accountNumber = account_name;
        this.balance = 0.0;
        this.customerName = customer_name;
        this.email = email;
        this.phoneNumber = phone_number;
    }

    public BankAccount(String account_name, double balance, String customer_name, String email, String phone_number) {
        this.accountNumber = account_name;
        this.balance = balance;
        this.customerName = customer_name;
        this.email = email;
        this.phoneNumber = phone_number;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String account_number) {
        this.accountNumber = account_number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customer_name) {
        this.customerName = customer_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }
}



