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

import com.srhheidelberg.sad.taskmanager.DAOInterface.EpicStoryTaskDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.EpicStoryTask;

@RestController
@RequestMapping("/epicstorytask")
public class EpicStoryTaskRestController {
	
	@Autowired
	EpicStoryTaskDAOInterface epicstorytaskDAOInterface;
	
	@PostMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public EpicStoryTask createEpicStoryTask(EpicStoryTask epicstorytask) {
		return epicstorytaskDAOInterface.createEpicStoryTask(epicstorytask);
	}
	
	@GetMapping("/{epicstorytaskId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public EpicStoryTask getEpicStoryTask(ModelMap modelMap, @PathVariable Integer epicstorytaskId) {
		return epicstorytaskDAOInterface.getEpicStoryTask(epicstorytaskId);
	}
	
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<EpicStoryTask> getAllEpicStoryTask() {
		return epicstorytaskDAOInterface.getAllEpicStoryTask();
	}
	
	@GetMapping("/delete/{epicstorytaskId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteEpicStoryTask(ModelMap modelMap, @PathVariable Integer epicstorytaskId) {
		epicstorytaskDAOInterface.deleteEpicStoryTask(epicstorytaskId);
	}
	
	@GetMapping("/deleteall")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteAllEpicStoryTask(List<EpicStoryTask> epicstorytask) {
		epicstorytaskDAOInterface.deleteAllEpicStoryTask(epicstorytask);
	}
	
	@PutMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public EpicStoryTask updateEpicStoryTask(EpicStoryTask epicstorytask) {
		return updateEpicStoryTask(epicstorytask);
	}

	/*@GetMapping("/getstorysunderepic")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<EpicStoryTask> storysunderepic(Integer storyId){
		return epicstorytaskDAOInterface.storysunderepic(storyId);
	}
	
	@GetMapping("/gettasksunderstory")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<EpicStoryTask> tasksunderstory(Integer taskId){
		return epicstorytaskDAOInterface.tasksunderstory(taskId);
	}*/
	
	@GetMapping("/getbystory/{storyId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<EpicStoryTask> getByStory(ModelMap modelMap, @PathVariable Integer storyId) {
		return epicstorytaskDAOInterface.getByStory(storyId);
	}
	
	@GetMapping("/getbyepic/{epicId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<EpicStoryTask> getByEpic(ModelMap modelMap, @PathVariable Integer epicId) {
		return epicstorytaskDAOInterface.getByStory(epicId);
	}
}
