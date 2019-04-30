package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.StoryTaskDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.StoryTask;

@RestController
@RequestMapping("/storytask")
public class StoryTaskRestController {
	
	@Autowired
	StoryTaskDAOInterface storytaskDAOInterface;
	
	@PostMapping("/")
	public StoryTask createStoryTask(StoryTask storytask) {
		return storytaskDAOInterface.createStoryTask(storytask);
	}
	
	@GetMapping("/{storytaskId}")
	public StoryTask getStoryTask(ModelMap modelMap, @PathVariable Integer storytaskId) {
		return storytaskDAOInterface.getStoryTask(storytaskId);
	}
	
	@GetMapping("/")
	public List<StoryTask> getAllStoryTask() {
		return storytaskDAOInterface.getAllStoryTask();
	}
	
	@GetMapping("/{deletestorytaskId}")
	public StoryTask deleteStoryTask(ModelMap modelMap, @PathVariable Integer storytaskId) {
		return storytaskDAOInterface.getStoryTask(storytaskId);
	}
	
	@GetMapping("/deleteallstorytask")
	public List<StoryTask> deleteAllStoryTask() {
		return storytaskDAOInterface.getAllStoryTask();
	}
	
	@PutMapping("/")
	public StoryTask updateStoryTask(StoryTask storytask) {
		return updateStoryTask(storytask);
	}


}
