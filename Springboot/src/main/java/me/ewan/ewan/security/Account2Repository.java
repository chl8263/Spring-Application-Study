package me.ewan.ewan.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Account2Repository extends JpaRepository<Account2, Long> {
    Optional<Account2> findByUserName(String username);
}
