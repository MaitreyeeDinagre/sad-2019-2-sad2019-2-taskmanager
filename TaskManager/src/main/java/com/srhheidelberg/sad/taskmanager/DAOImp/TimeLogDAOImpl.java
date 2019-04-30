package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.TimeLogDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.TimeLog;
import com.srhheidelberg.sad.taskmanager.repository.TimeLogJPARepository;

@Service
public class TimeLogDAOImpl implements TimeLogDAOInterface{
	
	@Autowired
	TimeLogJPARepository timelogJPARepository;

	public List<TimeLog> getAllTimeLog() {
		return timelogJPARepository.findAll();
	}

	public TimeLog getTimeLog(Integer timelogId) {
		return timelogJPARepository.getOne(timelogId);
	}

	public TimeLog createTimeLog(TimeLog timelog) {
		return timelogJPARepository.save(timelog);
	}
	
	public void deleteTimeLog(Integer timelogId) {
		timelogJPARepository.deleteById(timelogId);
	}
	
	public void deleteAllTimeLog(List<TimeLog> timelog) {
		timelogJPARepository.deleteAll(timelog);
	}
	
	@Override
	public TimeLog updateTimeLog(TimeLog timelog) {
		return timelogJPARepository.save(timelog);
}

}
