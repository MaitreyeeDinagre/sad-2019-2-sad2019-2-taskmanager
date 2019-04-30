package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.StoryDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Story;
import com.srhheidelberg.sad.taskmanager.repository.StoryJPARepository;

@Service
public class StoryDAOImpl implements StoryDAOInterface{
	
	@Autowired
	StoryJPARepository storyJPARepository;

	public List<Story> getAllStory() {
		return storyJPARepository.findAll();
	}

	public Story getStory(Integer storyId) {
		return storyJPARepository.getOne(storyId);
	}

	public Story createStory(Story story) {
		return storyJPARepository.save(story);
	}
	
	public void deleteStory(Integer storyId) {
		storyJPARepository.deleteById(storyId);
	}
	
	public void deleteAllStory(List<Story> story) {
		storyJPARepository.deleteAll(story);
	}

	@Override
	public Story updateStory(Story story) {
		return storyJPARepository.save(story);
	}
	
	

}
