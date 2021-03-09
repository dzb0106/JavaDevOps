package com.bankAccountAPIs.bankAccountAPIs;

// Zhubo Deng
// 03/07/21

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;

@Component
public class BankAccountDAO {

    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://bankdatabase.c1uxa5jkd8lj.us-east-2.rds.amazonaws.com:3306/bankDB";
    final String USER = "admin";
    final String PASS = "admin123";

    final String INSERT_USER = "INSERT INTO bankDB (account_number, balance, customer_name, email, phone_number) VALUES (?, ?, ?, ?, ?)";

    final String SELECT_USER = "SELECT account_number, customer_name, balance, email, phone_number FROM bankDB";
    final String SELECT_USER_BY_ACCT = "SELECT customer_name, balance, email, phone_number FROM bankDB WHERE account_number = ?";
    final String SELECT_BALANCE_BY_ACCT = "SELECT balance FROM bankDB WHERE account_number = ?";

    final String UPDATE_NAME = "UPDATE bankDB SET customer_name = ? where account_number = ?";
    final String UPDATE_EMAIL = "UPDATE bankDB SET email = ? where account_number = ?";
    final String UPDATE_PHONE = "UPDATE bankDB SET phone_number = ? where account_number = ?";
    final String UPDATE_BALANCE_AN = "UPDATE bankDB SET balance = ? where account_number = ?";

    final String DELETE_BY_ACCT = "DELETE FROM bankDB WHERE account_number = ?";

    protected Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /*
    execute() : The method used for all types of SQL statements, and that is, returns a boolean value
    of TRUE or FALSE. If the method return TRUE, return the ResultSet object and FALSE returns the int value.
    executeUpdate() : This method is used for execution of DML statement(INSERT, UPDATE and DELETE)
    which is return int value, count of the affected rows.
    executeQuery() : This method is used to retrieve data from database using SELECT query.
    This method returns the ResultSet object that returns the data according to the query.
     */
    public void createAccount(BankAccount bankAccount) {
        try {
            Connection conn = getConnection();
            PreparedStatement prepStmt = conn.prepareStatement(INSERT_USER);
            prepStmt.setString(1, bankAccount.getAccountNumber());
            prepStmt.setDouble(2, bankAccount.getBalance());
            prepStmt.setString(3, bankAccount.getCustomerName());
            prepStmt.setString(4, bankAccount.getEmail());
            prepStmt.setString(5, bankAccount.getPhoneNumber());
            if (prepStmt.executeUpdate() == 1) {
                System.out.println("Successfully added one new user!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // read all the Accounts
    public List<BankAccount> readAllAccounts() {
        List<BankAccount> ba = new ArrayList<>();
        try {
            Connection conn = getConnection();
            PreparedStatement prepStmt = conn.prepareStatement(SELECT_USER);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                String acct = rs.getString("account_number");
                double balance = rs.getDouble("balance");
                String name = rs.getString("customer_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone_number");
                ba.add(new BankAccount(acct, balance, name, email, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ba;
    }

    // read Account By its Account Number
    public BankAccount readAccount(String account_number) {
        BankAccount ba = null;
        try {
            Connection conn = getConnection();
            PreparedStatement prepStmt = conn.prepareStatement(SELECT_USER_BY_ACCT);
            prepStmt.setString(1, account_number);
            ResultSet rs = prepStmt.executeQuery();
            rs.next();
            double balance = rs.getDouble("balance");
            String name = rs.getString("customer_name");
            String email = rs.getString("email");
            String phone = rs.getString("phone_number");
            ba = new BankAccount(account_number, balance, name, email, phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ba;
    }

    // update Account Customer Name
    public void updateAccountCustomerName(String account_number, String customer_name) {
        try {
            Connection conn = getConnection();
            PreparedStatement prepStmt = conn.prepareStatement(UPDATE_NAME);
            prepStmt.setString(1, customer_name);
            prepStmt.setString(2, account_number);
            if (prepStmt.executeUpdate() == 1) {
                System.out.println("Successfully updated customer name!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update Account Email
    public void updateAccountEmail(String account_number, String email) {
        try {
            Connection conn = getConnection();
            PreparedStatement prepStmt = conn.prepareStatement(UPDATE_EMAIL);
            prepStmt.setString(1, email);
            prepStmt.setString(2, account_number);
            if (prepStmt.executeUpdate() == 1) {
                System.out.println("Successfully updated email!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update Account Phone Number
    public void updateAccountPhoneNumber(String account_number, String phone_number) {
        try {
            Connection conn = getConnection();
            PreparedStatement prepStmt = conn.prepareStatement(UPDATE_PHONE);
            prepStmt.setString(1, phone_number);
            prepStmt.setString(2, account_number);
            if (prepStmt.executeUpdate() == 1) {
                System.out.println("Successfully updated phone number!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // deposit By Account Number
    public void deposit(String account_number, double deposit) {
        try {
            Connection conn = getConnection();

            PreparedStatement balanceStmt = conn.prepareStatement(SELECT_BALANCE_BY_ACCT);
            balanceStmt.setString(1, account_number);
            ResultSet rs = balanceStmt.executeQuery();
            rs.next();
            double balance = rs.getDouble("balance");

            PreparedStatement prepStmt = conn.prepareStatement(UPDATE_BALANCE_AN);
            prepStmt.setDouble(1, balance + deposit);
            prepStmt.setString(2, account_number);
            if (prepStmt.executeUpdate() == 1) {
                System.out.println("Successfully deposited!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // withdraw By Account Number
    public void withdraw(String account_number, double withdraw) {
        try {
            Connection conn = getConnection();

            PreparedStatement balanceStmt = conn.prepareStatement(SELECT_BALANCE_BY_ACCT);
            balanceStmt.setString(1, account_number);
            ResultSet rs = balanceStmt.executeQuery();
            rs.next();
            double balance = rs.getDouble("balance");

            if (withdraw > balance) {
                System.out.println("Insufficient Funds!");
                System.out.println(account_number + " has " + balance + " in this bank account.");
            } else {
                PreparedStatement prepStmt = conn.prepareStatement(UPDATE_BALANCE_AN);
                prepStmt.setDouble(1, balance - withdraw);
                prepStmt.setString(2, account_number);
                if (prepStmt.executeUpdate() == 1) {
                    System.out.println("Successfully withdrawn!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // delete Account By Account Number
    public void deleteAccount(String account_number) {
        try {
            Connection conn = getConnection();
            PreparedStatement prepStmt = conn.prepareStatement(DELETE_BY_ACCT);
            prepStmt.setString(1, account_number);
            if (prepStmt.executeUpdate() == 1) {
                System.out.println("Successfully deleted!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}



