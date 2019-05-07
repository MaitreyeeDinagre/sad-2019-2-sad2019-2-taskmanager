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

import com.srhheidelberg.sad.taskmanager.DAOInterface.TimeLogDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.TimeLog;

@RestController
@RequestMapping("/timelog")
public class TimeLogRestController {
	
	@Autowired
	TimeLogDAOInterface timelogDAOInterface;
	
	@PostMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public TimeLog createTimeLog(TimeLog timelog) {
		return timelogDAOInterface.createTimeLog(timelog);
	}
	
	@GetMapping("/{timelogId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public TimeLog getTimeLog(ModelMap modelMap, @PathVariable Integer timelogId) {
		return timelogDAOInterface.getTimeLog(timelogId);
	}
	
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<TimeLog> getAllTimeLog() {
		return timelogDAOInterface.getAllTimeLog();
	}
	
	@GetMapping("/delete/{deletetimelogId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteTimeLog(ModelMap modelMap, @PathVariable Integer timelogId) {
		timelogDAOInterface.deleteTimeLog(timelogId);
	}
	
	@GetMapping("/deleteall")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteAllTimeLog(List<TimeLog> timelog) {
		timelogDAOInterface.deleteAllTimeLog(timelog);	
	}
	
	@PutMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public TimeLog updateTimeLog(TimeLog timelog) {
		return updateTimeLog(timelog);
	}


}
