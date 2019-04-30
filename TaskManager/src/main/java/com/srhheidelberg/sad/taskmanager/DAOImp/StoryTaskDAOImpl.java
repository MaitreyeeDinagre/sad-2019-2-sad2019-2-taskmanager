package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.StoryTaskDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.StoryTask;
import com.srhheidelberg.sad.taskmanager.repository.StoryTaskJPARepository;

@Service
public class StoryTaskDAOImpl implements StoryTaskDAOInterface{
	
	@Autowired
	StoryTaskJPARepository storytaskJPARepository;

	public List<StoryTask> getAllStoryTask() {
		return storytaskJPARepository.findAll();
	}

	public StoryTask getStoryTask(Integer storytaskId) {
		return storytaskJPARepository.getOne(storytaskId);
	}

	public StoryTask createStoryTask(StoryTask storytask) {
		return storytaskJPARepository.save(storytask);
	}
	
	public void deleteStoryTask(Integer storytaskId) {
		storytaskJPARepository.deleteById(storytaskId);
	}
	
	public void deleteAllStoryTask(List<StoryTask> storytask) {
		storytaskJPARepository.deleteAll(storytask);
	}	

	@Override
	public StoryTask updateStoryTask(StoryTask storytask) {
		return storytaskJPARepository.save(storytask);
}
}