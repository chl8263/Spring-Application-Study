package me.ewan.springdata;

import me.ewan.springdata.domain.Account;
import me.ewan.springdata.domain.Comment;
import me.ewan.springdata.domain.Post;
import me.ewan.springdata.domain.Study;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

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

        Post post = new Post();
        post.setTitle("Spring Data JPA..");

        Comment comment = new Comment();
        comment.setCommentString("init");

        Comment comment1 = new Comment();
        comment1.setCommentString("init11");

        post.addComment(comment);
        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);
        session.save(post);

//        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);
//        List<Post> postList = query.getResultList();
//        postList.forEach(x -> {
//            x.getComments().forEach(t -> {
//                System.out.println(t.getCommentString());
//            });
//        });

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query = builder.createQuery(Post.class);

        Root<Post> root = query.from(Post.class);
        query.select(root);

        List<Post> posts = entityManager.createNativeQuery("SELECT * FROM Post", Post.class).getResultList();
        posts.forEach(System.out::println);

        //Post post1 = session.get(Post.class, 4);

    }
}
