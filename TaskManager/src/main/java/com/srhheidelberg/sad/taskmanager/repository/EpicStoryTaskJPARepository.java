package com.srhheidelberg.sad.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.EpicStoryTask;


public interface EpicStoryTaskJPARepository extends JpaRepository<EpicStoryTask, Integer>{

}
