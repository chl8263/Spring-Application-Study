package me.ewan.springdata;

import me.ewan.springdata.repositrory.PostRepository;
import me.ewan.springdata.repositrory.PostRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class JpaRepoRunner implements ApplicationRunner {

    @Autowired
    PostRepository postRepository;

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
