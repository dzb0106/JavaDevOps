package com.bankAccountAPIs.bankAccountAPIs;

// Zhubo Deng
// 03/08/21

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BankAccountController {

    @Autowired
    BankAccountDAO bankAccountDAO = new BankAccountDAO();

    @GetMapping(path = "/readAllAccounts")
    public List<BankAccount> readAllAccounts() {
        return bankAccountDAO.readAllAccounts();
    }

    @GetMapping(path = "/readAccount/{acct}")
    public BankAccount readAccount(@PathVariable String acct) {
        return bankAccountDAO.readAccount(acct);
    }

    @PostMapping(path = "/createAccount")
    public void createAccount(@RequestBody(required = false) BankAccount ba) {
        bankAccountDAO.createAccount(ba);
    }

    @PutMapping(path = "/updateAccount/name")
    public void updateAccountName(@RequestParam(value = "accountNumber") String acct,
                                  @RequestParam(value = "customerName") String name) {
        bankAccountDAO.updateAccountCustomerName(acct, name);
    }

    @PutMapping(path = "/updateAccount/email")
    public void updateAccountEmail(@RequestParam(value = "accountNumber") String acct,
                                   @RequestParam(value = "email") String email) {
        bankAccountDAO.updateAccountEmail(acct, email);
    }

    @PutMapping(path = "/updateAccount/phone")
    public void updateAccountPhone(@RequestParam(value = "accountNumber") String acct,
                                   @RequestParam(value = "phone") String phone) {
        bankAccountDAO.updateAccountPhoneNumber(acct, phone);
    }

    @PutMapping(path = "/updateAccount/deposit")
    public void deposit(@RequestParam(value = "accountNumber") String acct,
                        @RequestParam(value = "deposit") double deposit) {
        bankAccountDAO.deposit(acct, deposit);
    }

    @PutMapping(path = "/updateAccount/withdraw")
    public void withdraw(@RequestParam(value = "accountNumber") String acct,
                         @RequestParam(value = "withdraw") double withdraw) {
        bankAccountDAO.withdraw(acct, withdraw);
    }

    @DeleteMapping(path = "/deleteAccount/{acct}")
    public void deleteAccount(@PathVariable String acct) {
        bankAccountDAO.deleteAccount(acct);
    }

}
