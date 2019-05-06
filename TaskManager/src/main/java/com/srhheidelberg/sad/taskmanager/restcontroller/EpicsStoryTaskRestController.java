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

import com.srhheidelberg.sad.taskmanager.DAOInterface.EpicStoryTaskDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.EpicStoryTask;

@RestController
@RequestMapping("/epicstorytask")
public class EpicsStoryTaskRestController {
	
	@Autowired
	EpicStoryTaskDAOInterface epicstorytaskDAOInterface;
	
	@PostMapping("/")
	public EpicStoryTask createEpicStoryTask(EpicStoryTask storytask) {
		return epicstorytaskDAOInterface.createEpicStoryTask(storytask);
	}
	
	@GetMapping("/{storytaskId}")
	public EpicStoryTask getEpicStoryTask(ModelMap modelMap, @PathVariable Integer storytaskId) {
		return epicstorytaskDAOInterface.getEpicStoryTask(storytaskId);
	}
	
	@GetMapping("/")
	public List<EpicStoryTask> getAllEpicStoryTask() {
		return epicstorytaskDAOInterface.getAllEpicStoryTask();
	}
	
	@GetMapping("/deleteone/{epicstorytaskId}")
	public void deleteEpicStoryTask(ModelMap modelMap, @PathVariable Integer epicstorytaskId) {
		epicstorytaskDAOInterface.deleteEpicStoryTask(epicstorytaskId);
	}
	
	@GetMapping("/deleteall")
	public void deleteAllEpicStoryTask(List<EpicStoryTask> epicstorytask) {
		epicstorytaskDAOInterface.deleteAllEpicStoryTask(epicstorytask);
	}
	
	@PutMapping("/")
	public EpicStoryTask updateEpicStoryTask(EpicStoryTask storytask) {
		return updateEpicStoryTask(storytask);
	}


}
