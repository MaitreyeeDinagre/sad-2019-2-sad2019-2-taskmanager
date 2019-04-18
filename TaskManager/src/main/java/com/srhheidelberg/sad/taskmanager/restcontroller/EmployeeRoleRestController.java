package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.EmployeeRoleDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.EmployeeRole;

@RestController
@RequestMapping ("/employeerole")
public class EmployeeRoleRestController {
	
	@Autowired
	EmployeeRoleDAOInterface employeeroleDAOInterface;
	
	@GetMapping("/")
	public List<EmployeeRole> getAllEmployeeRoles() {
		return employeeroleDAOInterface.getAllEmployeeRoles();
	}

}
