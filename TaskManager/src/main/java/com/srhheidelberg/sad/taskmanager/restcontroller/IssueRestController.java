package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.IssueDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Issue;

@RestController
@RequestMapping("/issue")
public class IssueRestController {
	
	@Autowired
	IssueDAOInterface issueDAOInterface;
	
	@PostMapping("/")
	public Issue createIssue(Issue issue) {
		return issueDAOInterface.createIssue(issue);
	}
	
	@GetMapping("/{issueId}")
	public Issue getIssue(ModelMap modelMap, @PathVariable Integer issueId) {
		return issueDAOInterface.getIssue(issueId);
	}
	
	@GetMapping("/")
	public List<Issue> getAllIssue() {
		return issueDAOInterface.getAllIssue();
	}
	
	@GetMapping("/{deleteissueId}")
	public Issue deleteIssue(ModelMap modelMap, @PathVariable Integer issueId) {
		return issueDAOInterface.getIssue(issueId);
	}
	
	@GetMapping("/deleteallissue")
	public List<Issue> deleteAllIssue() {
		return issueDAOInterface.getAllIssue();
	}

}
