package me.ewan.springdata;

import me.ewan.springdata.webDomain.WebPost;
import me.ewan.springdata.webDomain.WebPostRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPAPostTest {

    @Autowired
    private WebPostRepository webPostRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void updateTitle(){
        WebPost webPost = new WebPost();
        webPost.setId(1L);
        webPost.setTitle("jpa");

        WebPost savedWebPost = webPostRepository.save(webPost);

        savedWebPost.setTitle("jpa2");

//        int update = webPostRepository.updateTitle("jpa2", webPost.getId());
//        assertThat(update).isEqualTo(1);

        List<WebPost> saveWebPost = webPostRepository.findAll();
        assertThat(saveWebPost.get(0).getTitle()).isEqualTo("jpa2");
    }

    @Test
    public void findById(){

        WebPost webPost = new WebPost();
        //webPost.setId(1L);
        webPost.setTitle("jpa");
        WebPost savedWebPost = webPostRepository.save(webPost);

        savedWebPost.setTitle("Spring");
        webPostRepository.save(savedWebPost);

        List<WebPost> all = webPostRepository.findById("Spring", Sort.by("Title"));
        assertThat(all.size()).isEqualTo(1);

    }

    @Test
    public void findByTitle(){

        WebPost webPost = new WebPost();
        //webPost.setId(1L);
        webPost.setTitle("jpa");
        WebPost savedWebPost = webPostRepository.save(webPost);

        savedWebPost.setTitle("Spring");
        webPostRepository.save(savedWebPost);

        List<WebPost> all = webPostRepository.findByTitle("Spring");
        assertThat(all.size()).isEqualTo(1);

    }

    @Test
    public void findByTitleStartingWith(){

        WebPost webPost = new WebPost();
        //webPost.setId(1L);
        webPost.setTitle("jpa");
        WebPost savedWebPost = webPostRepository.save(webPost);

        savedWebPost.setTitle("SpringjpaTest");
        webPostRepository.save(savedWebPost);

        List<WebPost> all = webPostRepository.findByTitleStartingWith("Spring");
        assertThat(all.size()).isEqualTo(1);

    }

    @Test
    public void save(){

        WebPost webPost = new WebPost();
        //webPost.setId(1L);
        webPost.setTitle("jpa");
        WebPost savedWebPost = webPostRepository.save(webPost);

        savedWebPost.setTitle("jpaTest");
        webPostRepository.save(savedWebPost);

//        WebPost webPost2 = new WebPost();
//        webPost2.setId(1L);
//        webPost2.setTitle("jpa2");
//        webPostRepository.save(webPost2);

        List<WebPost> all = webPostRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }
}
