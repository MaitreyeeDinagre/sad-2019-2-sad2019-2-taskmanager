package com.srhheidelberg.sad.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.EmployeeRole;

public interface EmployeeRoleJPARepository extends JpaRepository<EmployeeRole, Integer> {

}
