package me.ewan.springdata.repositrory;

import me.ewan.springdata.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Post add(Post post){
        entityManager.persist(post);
        return post;
    }

    public Post delete(Post post){
        entityManager.remove(post);
        return post;
    }

    public List<Post> findAll(){
        return entityManager.createQuery("SELECT p FROM Post As p", Post.class).getResultList();
    }
}
