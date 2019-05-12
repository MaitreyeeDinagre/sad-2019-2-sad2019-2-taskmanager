package com.srhheidelberg.sad.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.Issue;


public interface IssueJPARepository extends JpaRepository<Issue, Integer>{
	
	List<Issue> getByIssueStory(Integer issueStory);

}
