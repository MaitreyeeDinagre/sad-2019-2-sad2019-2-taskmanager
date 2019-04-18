package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.StatusDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Status;

@RestController
@RequestMapping ("/status")
public class StatusRestController {
	
	@Autowired
	StatusDAOInterface statusDAOInterface;
	
	@GetMapping("/")
	public List<Status> getAllStatus() {
		return statusDAOInterface.getAllStatus();
	}

}
