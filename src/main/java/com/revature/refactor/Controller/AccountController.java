package com.revature.refactor.Controller;

import com.revature.refactor.Model.Account;
import com.revature.refactor.Model.Message;
import com.revature.refactor.Service.AccountService;
import com.revature.refactor.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    MessageService messageService;

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

    @GetMapping("/accounts/{account_id}/messages")
    public List<Message> getAllMessagesOfAccount(@PathVariable int account_id) {
        return messageService.getMessagesByAccount(account_id);
    }
}
