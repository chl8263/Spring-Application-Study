package me.ewan.springdata;

import me.ewan.springdata.domain.Account;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setName("Ewan");
        account.setPassword("930324");

        Session session = entityManager.unwrap(Session.class);

        //entityManager.persist(session);
        session.save(account);
    }
}
