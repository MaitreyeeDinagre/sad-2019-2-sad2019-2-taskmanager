package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.InitiativeDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Initiative;

@RestController
@RequestMapping("/initiative")
public class InitiativeRestController {
	
	@Autowired
	InitiativeDAOInterface initiativeDAOInterface;
	
	
	@PostMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public Initiative createInitiative(Initiative initiative) {
		return initiativeDAOInterface.createInitiative(initiative);
	}
	
	@GetMapping("/{initiativeId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Initiative getInitiative(ModelMap modelMap, @PathVariable Integer initiativeId) {
		return initiativeDAOInterface.getInitiative(initiativeId);
	}
	
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Initiative> getAllInitiative() {
		return initiativeDAOInterface.getAllInitiative();
	}

}
