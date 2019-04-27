package com.srhheidelberg.sad.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.StoryTask;


public interface StoryTaskJPARepository extends JpaRepository<StoryTask, Integer>{

}
