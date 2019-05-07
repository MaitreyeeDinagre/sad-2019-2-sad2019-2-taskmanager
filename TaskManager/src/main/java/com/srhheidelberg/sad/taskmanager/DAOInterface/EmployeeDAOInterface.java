package com.srhheidelberg.sad.taskmanager.DAOInterface;

import java.util.List;

import com.srhheidelberg.sad.taskmanager.model.Employee;

public interface EmployeeDAOInterface {
	
	List<Employee> getAllEmployee();
	
	Employee getEmployee(Integer employeeId);
	
	Employee createEmployee(Employee employee);
	
	public List<Employee> employeesunderinitiative(Integer initiativeId);

}
