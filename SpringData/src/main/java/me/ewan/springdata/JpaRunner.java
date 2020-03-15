package me.ewan.springdata;

import me.ewan.springdata.domain.Account;
import me.ewan.springdata.domain.Study;
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

        Study study = new Study();
        study.setName("Spring Data JPA");

        account.addStudy(study);
        //study.setOwner(account);

        //entityManager.persist(session);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);
    }
}
