package me.ewan.springdata.repositrory;

import me.ewan.springdata.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PostRepository2 extends JpaRepository<Post, Long> {

}
