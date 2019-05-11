package com.srhheidelberg.sad.taskmanager.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {
	
	@GetMapping("/api/test/ta")
	@PreAuthorize("hasRole('Tester') or hasRole('Architect')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/cd")
	@PreAuthorize("hasRole('Consultant') or hasRole('Developer')")
	public String projectManagementAccess() {
		return ">>> Project Management Board";
	}
	
	@GetMapping("/api/test/manager")
	@PreAuthorize("hasRole('Manager')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}
}