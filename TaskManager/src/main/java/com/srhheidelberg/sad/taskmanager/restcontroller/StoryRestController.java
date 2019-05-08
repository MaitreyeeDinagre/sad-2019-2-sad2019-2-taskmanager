package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.StoryDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Story;

@RestController
@RequestMapping("/story")
public class StoryRestController {
	
	@Autowired
	StoryDAOInterface storyDAOInterface;
	
	@PostMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public Story createStory(Story story) {
		return storyDAOInterface.createStory(story);
	}
	
	@GetMapping("/{storyId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Story getStory(ModelMap modelMap, @PathVariable Integer storyId) {
		return storyDAOInterface.getStory(storyId);
	}
	
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Story> getAllStory() {
		return storyDAOInterface.getAllStory();
	}
	
	@GetMapping("/delete/{storyId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteStory(ModelMap modelMap, @PathVariable Integer storyId) {
		storyDAOInterface.deleteStory(storyId);
	}
	
	@GetMapping("/deleteall")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteAllStory(List<Story> story) {
		storyDAOInterface.deleteAllStory(story);
	}
	
	@PutMapping("/")
	public Story updateStory(Story story) {
		return storyDAOInterface.updateStory(story);
	}

}
