package com.srhheidelberg.sad.taskmanager.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.EpicStoryTask;


public interface EpicStoryTaskJPARepository extends JpaRepository<EpicStoryTask, Integer>{
	
	List<EpicStoryTask> getByEpicStoryTaskEpic(Integer epicStoryTaskEpic);
	
	List<EpicStoryTask> getByEpicStoryTaskStory(Integer epicstoryTaskStory);
}
