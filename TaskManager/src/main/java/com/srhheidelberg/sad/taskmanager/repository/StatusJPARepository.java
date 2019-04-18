package com.srhheidelberg.sad.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.Status;

public interface StatusJPARepository extends JpaRepository<Status, Integer> {
	
	

}
