package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.EmployeeProfileDAOInterface;
import com.srhheidelberg.sad.taskmanager.DAOInterface.EmployeeRoleDAOInterface;
import com.srhheidelberg.sad.taskmanager.DAOInterface.StatusDAOInterface;
import com.srhheidelberg.sad.taskmanager.DAOInterface.TaskTypeDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.EmployeeProfile;
import com.srhheidelberg.sad.taskmanager.model.EmployeeRole;
import com.srhheidelberg.sad.taskmanager.model.Status;
import com.srhheidelberg.sad.taskmanager.model.TaskType;

@RestController
@RequestMapping("/enum")
public class EnumRestController {

	@Autowired
	EmployeeProfileDAOInterface employeeProfileDAOInterface;
	
	@Autowired
	EmployeeRoleDAOInterface employeeroleDAOInterface;
	
	@Autowired
	StatusDAOInterface statusDAOInterface;

	@Autowired
	TaskTypeDAOInterface tasktypeDAOInterface;
	
	@GetMapping("/employeeprofile")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<EmployeeProfile> getAllEmployeeProfiles() {
		return employeeProfileDAOInterface.getAllEmployeeProfiles();
	}
	
	@GetMapping("/employeerole")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<EmployeeRole> getAllEmployeeRoles() {
		return employeeroleDAOInterface.getAllEmployeeRoles();
	}
	
	@GetMapping("/status")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Status> getAllStatus() {
		return statusDAOInterface.getAllStatus();
	}
	
	@GetMapping("/tasktype")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<TaskType> getAllTaskTypes() {
		return tasktypeDAOInterface.getAllTaskTypes();
	}

}
