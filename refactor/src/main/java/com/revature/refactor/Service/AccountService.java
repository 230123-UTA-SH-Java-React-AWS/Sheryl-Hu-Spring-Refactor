package com.revature.refactor.Service;

import com.revature.refactor.Model.Account;
import com.revature.refactor.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    public AccountRepository accountRepo;

    public Account createAccount(Account account) {
        if (account.getUsername() != "" && account.getPassword().length() >= 4 && accountRepo.findAccountByUsername(account.getUsername()) == null) {
            return accountRepo.save(account);
        } else {
            return null;
        }
    }

    public Account loginAccount(Account account) {
        if (accountRepo.findAccountByUsername(account.getUsername()) != null) {
            return accountRepo.findAccountByUsernameAndPassword(account.getUsername(), account.getPassword());
        } else {
            return null;
        }
    }
}
