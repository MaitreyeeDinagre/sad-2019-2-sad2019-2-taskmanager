package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.EmployeeProfileDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.EmployeeProfile;
import com.srhheidelberg.sad.taskmanager.repository.EmployeeProfileJPARepository;

@Service
public class EmployeeProfileDAOImpl implements EmployeeProfileDAOInterface {

	@Autowired
	EmployeeProfileJPARepository employeeProfileJPARepository;
	
	public List<EmployeeProfile> getAllEmployeeProfiles() {
		return employeeProfileJPARepository.findAll();
	}

}
