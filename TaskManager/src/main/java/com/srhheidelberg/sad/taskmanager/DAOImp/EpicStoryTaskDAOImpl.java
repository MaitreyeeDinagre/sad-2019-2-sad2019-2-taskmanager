package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.EpicStoryTaskDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.EpicStoryTask;
import com.srhheidelberg.sad.taskmanager.repository.EpicStoryTaskJPARepository;

@Service
public class EpicStoryTaskDAOImpl implements EpicStoryTaskDAOInterface{
	
	@Autowired
	EpicStoryTaskJPARepository epicstorytaskJPARepository;

	public List<EpicStoryTask> getAllEpicStoryTask() {
		return epicstorytaskJPARepository.findAll();
	}

	public EpicStoryTask getEpicStoryTask(Integer epicstorytaskId) {
		return epicstorytaskJPARepository.getOne(epicstorytaskId);
	}

	public EpicStoryTask createEpicStoryTask(EpicStoryTask epicstorytask) {
		return epicstorytaskJPARepository.save(epicstorytask);
	}
	
	public void deleteEpicStoryTask(Integer epicstorytaskId) {
		epicstorytaskJPARepository.deleteById(epicstorytaskId);
	}
	
	public void deleteAllEpicStoryTask(List<EpicStoryTask> epicstorytask) {
		epicstorytaskJPARepository.deleteAll(epicstorytask);
	}	

	@Override
	public EpicStoryTask updateEpicStoryTask(EpicStoryTask epicstorytask) {
		return epicstorytaskJPARepository.save(epicstorytask);
	}

	@Override
	public List<EpicStoryTask> getByStory(Integer storyId) {
		return epicstorytaskJPARepository.getByEpicStoryTaskStory(storyId);
	}

	@Override
	public List<EpicStoryTask> getByEpic(Integer epicId) {
		return epicstorytaskJPARepository.getByEpicStoryTaskEpic(epicId);
	}
	
	/*public List<EpicStoryTask> storysunderepic(Integer storyId) {
		return epicstorytaskJPARepository.getByEpicStory(storyId);
	}
	
	public List<EpicStoryTask> tasksunderstory(Integer taskId) {
		return epicstorytaskJPARepository.getByStoryTask(taskId);
	}*/
}