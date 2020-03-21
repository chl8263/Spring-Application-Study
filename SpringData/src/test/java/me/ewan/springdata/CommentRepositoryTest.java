package me.ewan.springdata;

import me.ewan.springdata.domain.Comment;
import me.ewan.springdata.domain.Post2;
import me.ewan.springdata.event.PostPublishedEvent;
import me.ewan.springdata.repositrory.CommentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class CommentRepositoryTest {

    //@Autowired
    CommentRepository commentRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void contextTest(){
        Post2 post = new Post2();
        post.setTitle("event");
        PostPublishedEvent event = new PostPublishedEvent<Post2>(post);

        applicationContext.publishEvent(event);
    }

    @Test
    public void commentRepoTest(){
        Comment commentLike100 = this.createComment(100, "Spring data JPA");
        Comment commentLike50 = this.createComment(50, "hibernate spring");

        commentRepository.save(commentLike100);
        commentRepository.save(commentLike50);

        //List<Comment> comments = commentRepository.findByCommentStringContainsIgnoreCaseAAndLikeCountGreaterThan("Spring data jpa", 10);
        //assertThat(comments.size()).isEqualTo(1);

        List<Comment> comments = commentRepository.findByCommentStringContainsIgnoreCaseOrderByLikeCountDesc("Spring data JPA");
        assertThat(comments.size()).isEqualTo(1);
        assertThat(comments).first().hasFieldOrPropertyWithValue("likeCount", 100);

        PageRequest page = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "likeCount"));

        Page<Comment> commentPage = commentRepository.findByCommentStringContainsIgnoreCase("Spring", page);

        assertThat(commentPage.getNumberOfElements()).isEqualTo(2);
    }

    private Comment createComment(int likeCount, String commentString){

        Comment comment= new Comment();
        comment.setCommentString(commentString);
        comment.setLikeCount(likeCount);

        return comment;
    }

    @Test
    public void crud(){
        Comment comment= new Comment();
        comment.setCommentString("commentString");
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
