package me.ewan.springrestapi.Account;

import me.ewan.springrestapi.account.Account;
import me.ewan.springrestapi.account.AccountRepository;
import me.ewan.springrestapi.account.AccountRole;
import me.ewan.springrestapi.account.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findByUserName(){

        //Given
        String password = "930324";
        String userName = "Ewan@gmail.com";
        Account account = Account.builder()
                .email(userName)
                .password(password)
                .roles(new HashSet<>(Arrays.asList(AccountRole.ADMIN, AccountRole.USER)))
                .build();

        this.accountRepository.save(account);

        //When
        UserDetailsService userDetailsService = this.accountService;
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

        //Then
        assertThat(userDetails.getPassword()).isEqualTo(password);
    }
}
