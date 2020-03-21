package me.ewan.springdata.webDomain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WebPostRepository extends JpaRepository<WebPost, Long> {
}
