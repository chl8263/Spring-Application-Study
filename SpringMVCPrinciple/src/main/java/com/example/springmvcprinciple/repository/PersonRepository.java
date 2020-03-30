package com.example.springmvcprinciple.repository;

import com.example.springmvcprinciple.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
