package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.TaskTypeDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.TaskType;
import com.srhheidelberg.sad.taskmanager.repository.TaskTypeJPARepository;

@Service
public class TaskTypeDAOImp implements TaskTypeDAOInterface {
	
	@Autowired
	TaskTypeJPARepository taskTypeJPARepository;

	@Override
	public List<TaskType> getAllTaskTypes() {
		// TODO Auto-generated method stub
		return taskTypeJPARepository.findAll();
	}

}
