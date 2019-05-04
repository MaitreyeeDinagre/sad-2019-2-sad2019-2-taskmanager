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

import com.srhheidelberg.sad.taskmanager.DAOInterface.StoryTaskDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.StoryTask;

@RestController
@RequestMapping("/storytask")
public class StoryTaskRestController {
	
	@Autowired
	StoryTaskDAOInterface storytaskDAOInterface;
	
	@PostMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public StoryTask createStoryTask(StoryTask storytask) {
		return storytaskDAOInterface.createStoryTask(storytask);
	}
	
	@GetMapping("/{storytaskId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public StoryTask getStoryTask(ModelMap modelMap, @PathVariable Integer storytaskId) {
		return storytaskDAOInterface.getStoryTask(storytaskId);
	}
	
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<StoryTask> getAllStoryTask() {
		return storytaskDAOInterface.getAllStoryTask();
	}
	
	@GetMapping("/{deletestorytaskId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public StoryTask deleteStoryTask(ModelMap modelMap, @PathVariable Integer storytaskId) {
		return storytaskDAOInterface.getStoryTask(storytaskId);
	}
	
	@GetMapping("/deleteallstorytask")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<StoryTask> deleteAllStoryTask() {
		return storytaskDAOInterface.getAllStoryTask();
	}
	
	@PutMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public StoryTask updateStoryTask(StoryTask storytask) {
		return updateStoryTask(storytask);
	}


}
