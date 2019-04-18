package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.TaskTypeDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.TaskType;

@RestController
@RequestMapping ("/tasktype")
public class TaskTypeRestController {
	
	@Autowired
	TaskTypeDAOInterface tasktypeDAOInterface;
	
	@GetMapping("/")
	public List<TaskType> getAllTaskTypes() {
		return tasktypeDAOInterface.getAllTaskTypes();
	}

}
