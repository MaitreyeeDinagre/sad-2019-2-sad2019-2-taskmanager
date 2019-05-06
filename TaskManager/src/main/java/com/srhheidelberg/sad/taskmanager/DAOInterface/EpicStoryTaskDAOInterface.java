package com.srhheidelberg.sad.taskmanager.DAOInterface;

import java.util.List;

import com.srhheidelberg.sad.taskmanager.model.EpicStoryTask;

public interface EpicStoryTaskDAOInterface {
	
	List<EpicStoryTask> getAllEpicStoryTask();
	
	EpicStoryTask getEpicStoryTask(Integer epicstorytaskId);
	
	EpicStoryTask createEpicStoryTask(EpicStoryTask epicstorytask);
	
	void deleteEpicStoryTask(Integer epicstorytaskId);
	
	void deleteAllEpicStoryTask(List<EpicStoryTask> epicstorytask);

	EpicStoryTask updateEpicStoryTask(EpicStoryTask epicstorytask);

}
