package me.ewan.springdata;

import me.ewan.springdata.domain.Comment;
import me.ewan.springdata.webDomain.WebComment;
import me.ewan.springdata.webDomain.WebCommentRepository;
import me.ewan.springdata.webDomain.WebPost;
import me.ewan.springdata.webDomain.WebPostRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WebCommentTest {

    @Autowired
    WebCommentRepository webCommentRepository;

    @Autowired
    WebPostRepository webPostRepository;

    @Test
    public void getComment(){
        WebPost webPost = new WebPost();
        webPost.setTitle("jpa");
        WebPost savedWebPost = webPostRepository.save(webPost);

        WebComment webComment = new WebComment();
        webComment.setComment("comment");
        webComment.setWebPost(savedWebPost);
        webCommentRepository.save(webComment);

        Optional<WebComment> comment = webCommentRepository.findById(1L);
        System.out.println(comment.get().getComment());
    }

}
