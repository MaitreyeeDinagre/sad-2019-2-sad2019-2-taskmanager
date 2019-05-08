package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.TaskDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Task;

@RestController
@RequestMapping("/task")
public class TaskRestController {
	
	@Autowired
	TaskDAOInterface taskDAOInterface;
	
	@PostMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public Task createTask(Task task) {
		return taskDAOInterface.createTask(task);
	}
	
	@GetMapping("/{taskId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Task getTask(ModelMap modelMap, @PathVariable Integer taskId) {
		return taskDAOInterface.getTask(taskId);
	}
	
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Task> getAllTask() {
		return taskDAOInterface.getAllTask();
	}
	
	@GetMapping("/delete/{taskId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteTask(ModelMap modelMap, @PathVariable Integer taskId) {
		taskDAOInterface.deleteTask(taskId);
	}
	
	@GetMapping("/deleteall")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteAllTask(List<Task> task) {
		taskDAOInterface.deleteAllTask(task);
	}
	@PutMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public Task updateTask(Task task) {
		return updateTask(task);
	}


}
