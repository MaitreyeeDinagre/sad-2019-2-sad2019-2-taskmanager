package com.srhheidelberg.sad.taskmanager.DAOInterface;

import java.util.List;

import com.srhheidelberg.sad.taskmanager.model.TimeLog;

public interface TimeLogDAOInterface {
	
	List<TimeLog> getAllTimeLog();
	
	TimeLog getTimeLog(Integer timelogId);
	
	TimeLog createTimeLog(TimeLog timelog);
	
	void deleteTimeLog(Integer timelogId);
	
	void deleteAllTimeLog(List<TimeLog> timelog);
	
	TimeLog updateTimeLog(TimeLog timelog);

}
