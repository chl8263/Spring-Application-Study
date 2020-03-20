package me.ewan.springdata.repositrory;

import me.ewan.springdata.domain.Post2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository2 extends JpaRepository<Post2, Long>, PostCustomRepository<Post2> {
}
