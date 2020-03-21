package me.ewan.springdata.repositrory;

import me.ewan.springdata.domain.Post;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomPostRepository extends BaseRepository<Post, Long> {
}
