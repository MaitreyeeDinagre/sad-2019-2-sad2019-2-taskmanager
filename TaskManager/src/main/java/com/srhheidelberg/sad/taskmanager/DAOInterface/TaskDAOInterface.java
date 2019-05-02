package com.srhheidelberg.sad.taskmanager.DAOInterface;

import java.util.List;

import com.srhheidelberg.sad.taskmanager.model.Task;

public interface TaskDAOInterface {
	
	List<Task> getAllTask();
	
	Task getTask(Integer taskId);
	
	Task createTask(Task task);
	
    void deleteTask(Integer taskId);
	
	void deleteAllTask(List<Task> task);
	
	Task updateTask(Task task);

}
