package com.nyadesu.se.shikonokokoshitantan.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyadesu.se.shikonokokoshitantan.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
 
    Optional<Role> findByName(String name);
} 