package com.miracle.partyserv.repository;

import com.miracle.partyserv.model.PhUserRole;
import com.miracle.partyserv.model.PhRoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhUserRoleRepository extends JpaRepository<PhUserRole, Long> {
    PhUserRole findByRoleType(PhRoleType type);
}
