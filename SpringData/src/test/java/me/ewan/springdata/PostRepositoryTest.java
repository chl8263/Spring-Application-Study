package me.ewan.springdata;

import me.ewan.springdata.domain.Post;
import me.ewan.springdata.repositrory.PostRepository2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace;

@RunWith(SpringRunner.class)
@DataJpaTest    //For slicing test, if want to test just repository, can use this and when use this one, can enroll just repository
public class PostRepositoryTest {

    @Autowired
    PostRepository2 postRepository;

    @Test
    @Rollback(false)
    public void crudRepository(){
        //Given
        Post post = new Post();
        post.setTitle("Hello spring boot common");
        assertThat(post.getId()).isNull();

        //When
        Post newPost = postRepository.save(post);

        //Then
        assertThat(newPost.getId()).isNotNull();

        //When
        List<Post> posts = postRepository.findAll();
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts).contains(newPost);

        //When
        Page<Post> page =  postRepository.findAll(PageRequest.of(0, 10));

        //Then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        //When
        postRepository.findByTitleContains("spring", PageRequest.of(0, 10));

        //Then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        //When
        long spring = postRepository.countByTitleContains("spring");

        //Then
        assertThat(spring).isEqualTo(1);
    }
}