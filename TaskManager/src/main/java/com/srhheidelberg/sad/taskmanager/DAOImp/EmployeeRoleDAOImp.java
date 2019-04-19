package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.EmployeeRoleDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.EmployeeRole;
import com.srhheidelberg.sad.taskmanager.repository.EmployeeRoleJPARepository;

@Service
public class EmployeeRoleDAOImp implements EmployeeRoleDAOInterface {
	
	@Autowired
	EmployeeRoleJPARepository employeeRoleJPARepository;
	
	public List<EmployeeRole> getAllEmployeeRoles() {
		return employeeRoleJPARepository.findAll();
	}

}
