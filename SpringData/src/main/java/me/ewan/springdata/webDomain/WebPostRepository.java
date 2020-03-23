package me.ewan.springdata.webDomain;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedNativeQuery;
import java.util.List;

public interface WebPostRepository extends JpaRepository<WebPost, Long> {

    List<WebPost> findByTitleStartingWith(String title);

    //@Query(value = "SELECT p FROM #{#entityName} AS p WHERE p.title = :title")
    List<WebPost> findByTitle(@Param("Title") String title);

    //@Query(value = "SELECT p FROM Post WHERE id = 1", nativeQuery = true)
    @Query(value = "SELECT p FROM WebPost AS p WHERE p.id = ?1")
    List<WebPost> findById(String title, Sort sort);

    @Modifying  //For update
    @Query(value = "UPDATE WebPost p SET p.title = ?1 WHERE p.id = ?2")
    int updateTitle(String jpa, Long id);
}
