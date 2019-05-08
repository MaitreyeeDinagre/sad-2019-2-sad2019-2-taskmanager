package com.srhheidelberg.sad.taskmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srhheidelberg.sad.taskmanager.model.Role;
import com.srhheidelberg.sad.taskmanager.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}