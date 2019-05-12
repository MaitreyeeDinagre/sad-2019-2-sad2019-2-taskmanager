package com.srhheidelberg.sad.taskmanager.DAOInterface;

import java.util.List;

import com.srhheidelberg.sad.taskmanager.model.Issue;

public interface IssueDAOInterface {
	
	List<Issue> getAllIssue();
	
	Issue getIssue(Integer issueId);
	
	Issue createIssue(Issue issue);
	
	void deleteIssue(Integer issueId);
	
	void deleteAllIssue(List<Issue> issue);

	Issue updateIssue(Issue issue);
	
	List<Issue> getByIssueStory(Integer issueStory);

}
