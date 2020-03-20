package me.ewan.springdata.repositrory;

import me.ewan.springdata.domain.Post;
import me.ewan.springdata.domain.Post2;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post2> findMyPost();

    void delete(T entity);
}
