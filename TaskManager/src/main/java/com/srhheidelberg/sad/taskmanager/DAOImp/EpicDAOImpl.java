package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.EpicDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Epic;
import com.srhheidelberg.sad.taskmanager.repository.EpicJPARepository;

@Service
public class EpicDAOImpl implements EpicDAOInterface{
	
	@Autowired
	EpicJPARepository epicJPARepository;

	public List<Epic> getAllEpic() {
		return epicJPARepository.findAll();
	}

	public Epic getEpic(Integer epicId) {
		return epicJPARepository.getOne(epicId);
	}

	public Epic createEpic(Epic epic) {
		return epicJPARepository.save(epic);
	}

	@Override
	public List<Epic> getByEpicInitiative(Integer epicInitiative) {
		
		return epicJPARepository.getByEpicInitiative(epicInitiative);
	}

	
	}





	




