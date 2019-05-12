package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.IssueDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Issue;
import com.srhheidelberg.sad.taskmanager.repository.IssueJPARepository;

@Service
public class IssueDAOImpl implements IssueDAOInterface{
	
	@Autowired
	IssueJPARepository issueJPARepository;

	public List<Issue> getAllIssue() {
		return issueJPARepository.findAll();
	}

	public Issue getIssue(Integer issueId) {
		return issueJPARepository.getOne(issueId);
	}

	public Issue createIssue(Issue issue) {
		return issueJPARepository.save(issue);
	}
	
	public void deleteIssue(Integer issueId) {
		issueJPARepository.deleteById(issueId);
	}
	
	public void deleteAllIssue(List<Issue> issue) {
		issueJPARepository.deleteAll(issue);
	}	
	
	@Override
	public Issue updateIssue(Issue issue) {
		return issueJPARepository.save(issue);
		}

	public List<Issue> getByIssueStory(Integer issueStory) {
		return issueJPARepository.getByIssueStory(issueStory);
	}
}