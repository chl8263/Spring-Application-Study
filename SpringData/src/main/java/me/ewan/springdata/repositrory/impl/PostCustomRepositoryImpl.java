package me.ewan.springdata.repositrory.impl;

import me.ewan.springdata.domain.Post;
import me.ewan.springdata.domain.Post2;
import me.ewan.springdata.repositrory.PostCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class PostCustomRepositoryImpl implements PostCustomRepository<Post2> {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Post2> findMyPost() {
        return entityManager.createQuery("SELECT p FROM Post2 AS p", Post2.class).getResultList();
    }

    @Override
    public void delete(Post2 entity) {
        System.out.println("Custom delete");
        entityManager.remove(entity);
    }
}
