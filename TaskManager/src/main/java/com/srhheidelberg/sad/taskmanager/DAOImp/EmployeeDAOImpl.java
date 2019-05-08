package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.EmployeeDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Employee;
import com.srhheidelberg.sad.taskmanager.repository.EmployeeJPARepository;

@Service
public class EmployeeDAOImpl implements EmployeeDAOInterface{
	
	@Autowired
	EmployeeJPARepository employeeJPARepository;

	public List<Employee> getAllEmployee() {
		return employeeJPARepository.findAll();
	}

	public Employee getEmployee(Integer employeeId) {
		return employeeJPARepository.getOne(employeeId);
	}

	public Employee createEmployee(Employee employee) {
		System.out.print("fffffffffffff" + employee);
		return employeeJPARepository.save(employee);
	}

	

}
