package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.EmployeeRoleDAOInterface;
import com.srhheidelberg.sad.taskmanager.DAOInterface.StatusDAOInterface;
import com.srhheidelberg.sad.taskmanager.DAOInterface.TaskTypeDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.EmployeeRole;
import com.srhheidelberg.sad.taskmanager.model.Status;
import com.srhheidelberg.sad.taskmanager.model.TaskType;

@RestController
@RequestMapping("/enum")
public class EnumRestController {
	
	@Autowired
	EmployeeRoleDAOInterface employeeroleDAOInterface;
	
	@Autowired
	StatusDAOInterface statusDAOInterface;

	@Autowired
	TaskTypeDAOInterface tasktypeDAOInterface;
	
	
	@GetMapping("/employeerole")
	public List<EmployeeRole> getAllEmployeeRoles() {
		return employeeroleDAOInterface.getAllEmployeeRoles();
	}
	
	@GetMapping("/status")
	public List<Status> getAllStatus() {
		return statusDAOInterface.getAllStatus();
	}
	
	@GetMapping("/tasktype")
	public List<TaskType> getAllTaskTypes() {
		return tasktypeDAOInterface.getAllTaskTypes();
	}

}