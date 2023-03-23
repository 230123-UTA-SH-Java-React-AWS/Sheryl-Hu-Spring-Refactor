package com.revature.refactor.Repository;

import com.revature.refactor.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findAccountByUsernameAndPassword(String username, String password);
    Account findAccountByUsername(String username);
}
