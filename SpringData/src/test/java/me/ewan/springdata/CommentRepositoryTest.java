package me.ewan.springdata;

import me.ewan.springdata.domain.Comment;
import me.ewan.springdata.repositrory.CommentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud(){
        Comment comment= new Comment();
        comment.setCommentString("Hello Comment");
        commentRepository.save(comment);

        List<Comment> all = commentRepository.findAll();
        assertThat(all.size()).isEqualTo(1);

        assertThat(commentRepository.count()).isEqualTo(1);
    }

    @Test
    public void crud2(){
        Optional<Comment> byId = commentRepository.findById(100L);
        //Comment comment = byId.orElseThrow(IllegalArgumentException::new);

        assertThat(byId).isEmpty();

        List<Comment> comments = commentRepository.findAll();   //if not find any data, they return empty List, not null, because spring data JPA always not return null when using collection

        assertThat(comments).isEmpty();
    }
}
