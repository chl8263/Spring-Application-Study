package me.ewan.springrestapi.evetns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
