package com.srhheidelberg.sad.taskmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.EmployeeRole;
import com.srhheidelberg.sad.taskmanager.model.RoleName;

public interface EmployeeRoleJPARepository extends JpaRepository<EmployeeRole, Long> {
	
	public static Optional<EmployeeRole> findByName(RoleName roleName) {
		// TODO Auto-generated method stub
		return null;
	}

}
