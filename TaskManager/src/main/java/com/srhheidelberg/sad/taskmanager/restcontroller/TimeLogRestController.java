package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.TimeLogDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.TimeLog;

@RestController
@RequestMapping("/timelog")
public class TimeLogRestController {
	
	@Autowired
	TimeLogDAOInterface timelogDAOInterface;
	
	@PostMapping("/")
	public TimeLog createTimeLog(TimeLog timelog) {
		return timelogDAOInterface.createTimeLog(timelog);
	}
	
	@GetMapping("/{timelogId}")
	public TimeLog getTimeLog(ModelMap modelMap, @PathVariable Integer timelogId) {
		return timelogDAOInterface.getTimeLog(timelogId);
	}
	
	@GetMapping("/")
	public List<TimeLog> getAllTimeLog() {
		return timelogDAOInterface.getAllTimeLog();
	}
	
	@GetMapping("/{deletetimelogId}")
	public TimeLog deleteTimeLog(ModelMap modelMap, @PathVariable Integer timelogId) {
		return timelogDAOInterface.getTimeLog(timelogId);
	}
	
	@GetMapping("/deletealltimelog")
	public List<TimeLog> deleteAllTimeLog() {
		return timelogDAOInterface.getAllTimeLog();
	}

}
