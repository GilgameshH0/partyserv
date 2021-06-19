package com.miracle.partyserv.repository;

import com.miracle.partyserv.model.PhUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhUserRepository extends JpaRepository<PhUser, Long> {
    PhUser findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
