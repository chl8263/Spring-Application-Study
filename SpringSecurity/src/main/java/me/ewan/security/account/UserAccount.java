package me.ewan.security.account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserAccount extends User {

    public UserAccount(Account account) {
        super(account.getUsername(), account.getPassword(), new ArrayList<>(Collections.singleton(new SimpleGrantedAuthority("ROLE_" + account.getRole()))));
    }
}
