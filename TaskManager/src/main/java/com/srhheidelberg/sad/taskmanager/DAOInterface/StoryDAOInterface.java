package com.srhheidelberg.sad.taskmanager.DAOInterface;

import java.util.List;

import com.srhheidelberg.sad.taskmanager.model.Story;

public interface StoryDAOInterface {
	
	List<Story> getAllStory();
	
	Story getStory(Integer storyId);
	
	Story createStory(Story story);
	
	void deleteStory(Integer storyId);
	
	void deleteAllStory(List<Story> story);
	
	Story updateStory(Story story);

}
