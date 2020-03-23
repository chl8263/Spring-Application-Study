package me.ewan.springdata.webDomain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WebCommentRepository extends JpaRepository<WebComment, Long> {
}
