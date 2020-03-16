package me.ewan.springdata;

import me.ewan.springdata.domain.Account;
import me.ewan.springdata.domain.Comment;
import me.ewan.springdata.domain.Post;
import me.ewan.springdata.domain.Study;
import me.ewan.springdata.repositrory.PostRepository;
import me.ewan.springdata.repositrory.PostRepository2;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class JpaRepoRunner implements ApplicationRunner {

    @Autowired
    PostRepository2 postRepository;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {

        postRepository.findAll().forEach(x -> {
            x.getComments().forEach(t -> {
                System.out.println(t.getCommentString());
            });
        });

    }
}
