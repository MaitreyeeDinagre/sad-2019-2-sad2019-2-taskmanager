package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.EpicDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Epic;

@RestController
@RequestMapping("/epic")
public class EpicRestController {
	
	@Autowired
	EpicDAOInterface epicDAOInterface;
	
	@PostMapping("/")
	public Epic createEpic(Epic epic) {
		return epicDAOInterface.createEpic(epic);
	}
	
	@GetMapping("/{epicId}")
	public Epic getEpic(ModelMap modelMap, @PathVariable Integer epicId) {
		return epicDAOInterface.getEpic(epicId);
	}
	
	@GetMapping("/")
	public List<Epic> getAllEpic() {
		return epicDAOInterface.getAllEpic();
	}

}
