package com.srhheidelberg.sad.taskmanager.DAOInterface;

import java.util.List;

import com.srhheidelberg.sad.taskmanager.model.StoryTask;

public interface StoryTaskDAOInterface {
	
	List<StoryTask> getAllStoryTask();
	
	StoryTask getStoryTask(Integer storytaskId);
	
	StoryTask createStoryTask(StoryTask storytask);
	
	void deleteStoryTask(Integer storytaskId);
	
	void deleteAllStoryTask(List<StoryTask> storytask);

	StoryTask updateStoryTask(StoryTask storytask);

}
