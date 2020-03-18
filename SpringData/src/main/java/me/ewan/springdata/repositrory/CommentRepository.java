package me.ewan.springdata.repositrory;

import me.ewan.springdata.domain.Comment;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
//public interface CommentRepository {
//
//    Comment save (Comment comment);
//
//    List<Comment> findAll();
//}

public interface CommentRepository extends MyRepository<Comment, Long>{

}