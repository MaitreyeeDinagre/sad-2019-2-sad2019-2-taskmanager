package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.TaskDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Task;
import com.srhheidelberg.sad.taskmanager.repository.TaskJPARepository;

@Service
public class TaskDAOImpl implements TaskDAOInterface{
	
	@Autowired
	TaskJPARepository taskJPARepository;

	public List<Task> getAllTask() {
		return taskJPARepository.findAll();
	}

	public Task getTask(Integer taskId) {
		return taskJPARepository.getOne(taskId);
	}

	public Task createTask(Task task) {
		return taskJPARepository.save(task);
	}
	
	public void deleteTask(Integer taskId) {
		taskJPARepository.deleteById(taskId);
	}
	
	public void deleteAllTask(List<Task> task) {
		taskJPARepository.deleteAll(task);
	}
	
	@Override
	public Task updateTask(Task task) {
		return taskJPARepository.save(task);
}

}
