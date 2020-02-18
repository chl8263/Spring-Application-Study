package me.ewan.ewan.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private Account2Repository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account2 createAccount(String username, String password){

        Account2 account2 = new Account2();
        account2.setUserName(username);
        account2.setPassword(passwordEncoder.encode(password));
        return repository.save(account2);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Account2> byUserName = repository.findByUserName(username);
        Account2 account2 = byUserName.orElseThrow(() -> new UsernameNotFoundException(username));

        return new User(account2.getUserName(), account2.getPassword(), authority());
    }

    private Collection<? extends GrantedAuthority> authority() {

        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
