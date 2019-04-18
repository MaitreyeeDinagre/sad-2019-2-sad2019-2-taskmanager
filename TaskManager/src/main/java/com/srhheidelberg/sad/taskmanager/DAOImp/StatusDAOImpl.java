package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.StatusDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Status;
import com.srhheidelberg.sad.taskmanager.repository.StatusJPARepository;

@Service
public class StatusDAOImpl implements StatusDAOInterface {
	
	@Autowired
	StatusJPARepository statusJPARepository;

	@Override
	public List<Status> getAllStatus() {
		// TODO Auto-generated method stub
		return statusJPARepository.findAll();
	}

}
