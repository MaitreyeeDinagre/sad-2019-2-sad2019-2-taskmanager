package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.EmployeeDAOInterface;
import com.srhheidelberg.sad.taskmanager.DAOInterface.InitiativeDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Initiative;
import com.srhheidelberg.sad.taskmanager.repository.InitiativeJPARepository;

@Service
public class InitiativeDAOImpl implements InitiativeDAOInterface{
	
	@Autowired
	InitiativeJPARepository initiativeJPARepository;
	@Autowired
	EmployeeDAOInterface employeeDAOInterface;

	public List<Initiative> getAllInitiative() {
		return initiativeJPARepository.findAll();
	}

	public Initiative getInitiative(Integer intitiativeId) {
		return initiativeJPARepository.getOne(intitiativeId);
	}

	public Initiative createInitiative(Initiative initiative) {
		return initiativeJPARepository.save(initiative);
	}

}
