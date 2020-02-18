package me.ewan.ewan.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account2 account2 = accountService.createAccount("ewan", "1234");
        System.out.println(account2.getUserName() + " " + account2.getPassword());
    }
}
