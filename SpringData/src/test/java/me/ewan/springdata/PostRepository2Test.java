package me.ewan.springdata;

import me.ewan.springdata.domain.Post;
import me.ewan.springdata.domain.Post2;
import me.ewan.springdata.repositrory.PostRepository2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepository2Test {

    @Autowired
    PostRepository2 postRepository;

    @Test
    public void crud(){

        Post2 post = new Post2();
        post.setTitle("hibernate");

        postRepository.save(post);
        postRepository.findMyPost();
        postRepository.delete(post);

        postRepository.flush();
    }
}
