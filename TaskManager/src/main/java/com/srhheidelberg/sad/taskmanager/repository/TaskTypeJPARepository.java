package com.srhheidelberg.sad.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.TaskType;

public interface TaskTypeJPARepository extends JpaRepository<TaskType, Integer> {

}
