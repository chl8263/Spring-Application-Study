package me.ewan.ewan;

import me.ewan.ewan.jpa.Account;
import me.ewan.ewan.jpa.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di(){
        try(Connection connection = dataSource.getConnection()){
            DatabaseMetaData dataBaseMetaData = connection.getMetaData();

            System.out.println(dataBaseMetaData.getURL());
            System.out.println(dataBaseMetaData.getDriverName());
            System.out.println(dataBaseMetaData.getUserName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Account account = new Account();

        account.setUserName("ewan");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);
        assertThat(newAccount).isNotNull();

//        Account existingAccount = accountRepository.findByUserName(newAccount.getUserName());
//        assertThat(existingAccount).isNotNull();
//
//        Account notExistingAccount = accountRepository.findByUserName("Wongyun");
//        assertThat(notExistingAccount).isNull();

        Optional<Account> existingAccount = accountRepository.findByUserName(newAccount.getUserName());
        assertThat(existingAccount).isNotEmpty();

        Optional<Account> notExistingAccount = accountRepository.findByUserName("Wongyun");
        assertThat(notExistingAccount).isEmpty();
    }
}
