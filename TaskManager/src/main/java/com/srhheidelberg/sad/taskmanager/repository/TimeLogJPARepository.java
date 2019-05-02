package com.srhheidelberg.sad.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.TimeLog;


public interface TimeLogJPARepository extends JpaRepository<TimeLog, Integer>{

}
