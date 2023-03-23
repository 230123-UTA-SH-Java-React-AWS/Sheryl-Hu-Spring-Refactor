package com.revature.refactor.Controller;

import com.revature.refactor.Model.Account;
import com.revature.refactor.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<Account> createNewAccount(@RequestBody Account account) {
        Account newAccount = accountService.createAccount(account);
        if (newAccount != null) {
            return ResponseEntity.status(200).body(newAccount);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody Account account) {
        Account loginAttempt = accountService.loginAccount(account);
        if (loginAttempt != null) {
            return ResponseEntity.status(200).body(loginAttempt);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }
}
