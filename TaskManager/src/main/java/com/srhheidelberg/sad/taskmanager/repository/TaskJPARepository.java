package com.srhheidelberg.sad.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.Task;


public interface TaskJPARepository extends JpaRepository<Task, Integer>{

}
